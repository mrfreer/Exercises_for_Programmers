package com.company;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

/**
 * Created by David on 1/27/2017.
 */
public class Multiplication {
    private JPanel ID;

    public Multiplication() {
        String [] columnNames = new String[20];
        for(int i = 0; i < 20; i++){
            columnNames[i] = Integer.toString(i);
        }

        Object [][] data = new Object[20][21];
        for(int i = 0; i < 20; i++) {
            data[i][0] = i;
            for (int j = 1; j <= 20; j++) {
                data[i][j] = (i * j);
            }
        }

        final JTable table = new JTable(data, columnNames);
        table.setSize(1050, 550);
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

 //       table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        JScrollPane scroll = new JScrollPane(table);
        ID.add(scroll);
        TableColumn column = null;
        for(int i = 0; i < 20; i++){

            column = table.getColumnModel().getColumn(i);
            if(i > 5){
                column.setPreferredWidth(200);
            }
            else{
                column.setWidth(75);
            }

        }
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(1050, 550);
        jf.setContentPane(new Multiplication().ID);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}

