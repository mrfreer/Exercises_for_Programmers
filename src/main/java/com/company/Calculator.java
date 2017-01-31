package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by David on 1/19/2017.
 */
public class Calculator {
    private JButton calculateButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JPanel jPanelD;
    private JPanel jPanel;
    public Calculator() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                int add = num1 + num2;
                int multiply = num1 * num2;
                double divide = ((double)num1) / num2;
                int subtract = num1 - num2;
                textArea1.setText("Adding " + num1 + " and " + num2 +  " = " + add + '\n' +
                        "Subtracting " + num2 + " from " + num1 + " = " + subtract + '\n' +
                        "Multiplying " + num1 + " and " + num2 + " = " + multiply + '\n' +
                        "Dividing " + num1 + " divided by " + num2 + " = " + divide + '\n');
            }
        });
    }

    public static void main(String[] args) {
        JFrame j = new JFrame("Calculator");
        j.setContentPane(new Calculator().jPanelD);
        j.pack();
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

