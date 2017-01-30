package com.company;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by dfreer on 1/30/2017.
 */
class EmpSalary{
    String name;
    double salary;

    public EmpSalary(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
public class ParseCSV {
    ArrayList<EmpSalary> allEmps = new ArrayList<>();

    public void readIn(){
        try  {
            Reader in = new FileReader("Data\\SalaryData.csv");
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader()
                    .parse(in);

            for(CSVRecord record : records){
                String name = record.get(0);
                String salary = record.get(1);
                NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.US);
                Number num = cf.parse(salary);
                double s = num.doubleValue();
                allEmps.add(new EmpSalary(name, s));
            }
        }
        catch (FileNotFoundException f){
            f.printStackTrace();
        }
        catch (IOException i){
            i.printStackTrace();
        }
        catch (ParseException p){
            p.printStackTrace();
        }
    }

    public void displayData(){
        System.out.printf("%-30.30s  %-30.30s%n", "NAME", "SALARY");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        double salary = 0.0;
        for(EmpSalary e : allEmps){
            salary += e.salary;
            System.out.printf("%-30.30s  %-30.30s%n", e.name.toString(),
                    formatter.format(e.salary));
        }

        System.out.printf("%-30.30s  %-30.30s%n","Average salary: " , formatter.format(salary/ allEmps.size()));
    }

    public static void main(String[] args) {
        ParseCSV p = new ParseCSV();
        p.readIn();
        p.displayData();
    }
}


