package com.company;

/**
 * Created by dfreer on 1/30/2017.
 */
import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

class MysqlCon{
    public static void main(String args[]){
        try{
            Scanner scan = new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/exercisesprogrammers","test","test");
            System.out.println("Enter a name:");
            String userPick = scan.next();

            Statement stmt=con.createStatement();

            ResultSet rs=stmt.executeQuery("select * from employee39" +
                    " WHERE first LIKE '%" + userPick + "%' OR " +
                    " last LIKE '%" + userPick +"%'" );

            //ResultSet rs = stmt.executeQuery("SELECT * FROM employee39");
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}