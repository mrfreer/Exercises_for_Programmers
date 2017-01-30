package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dfreer on 1/27/2017.
 */
public class InvestmentDoubling {
    private JButton calculateYearsToDoubleButton;
    private JTextField textFieldRateReturn;
    private JLabel jLabelInvestment;
    private JPanel jPanelID;

    public InvestmentDoubling() {
        calculateYearsToDoubleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double rateOfReturn = Double.parseDouble(textFieldRateReturn.getText());
                    if(rateOfReturn == 0){
                        JOptionPane.showMessageDialog(null, "Sorry. That's not a valid input.");
                        textFieldRateReturn.setText("");
                    }
                    else{
                        int years = (int)(72 / rateOfReturn);
                        jLabelInvestment.setText(years + " years to double your initial investment.");
                        textFieldRateReturn.setText("");
                    }
                }
                catch (NumberFormatException ne){
                    JOptionPane.showMessageDialog(null, "Sorry. That's not a valid input.");
                    textFieldRateReturn.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame j = new JFrame("Investment Doubling");
        j.setContentPane(new InvestmentDoubling().jPanelID);
        j.pack();
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
