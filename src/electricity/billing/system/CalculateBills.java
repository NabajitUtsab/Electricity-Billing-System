package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class CalculateBills extends JFrame {
    JLabel heading,meterNum;
    Choice meterNumChoice;
    CalculateBills(){
        super("Calculate Bills");

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(241,195,247));
        add(panel);

        heading=new JLabel("Calculate Electricity Bill");
        heading.setBounds(70,10,300,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        meterNum=new JLabel("Meter Number");
        meterNum.setBounds(50,80,100,15);
        panel.add(meterNum);

        meterNumChoice=new Choice();
        try {
            Database c=new Database();
            ResultSet resultSet=c.statement.executeQuery("select * from new_customer");
            while (resultSet.next()){
                meterNumChoice.add(resultSet.getString("meter_no"));
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }
        meterNumChoice.setBounds(150,80,100,15);
        panel.add(meterNumChoice);



        setSize(650,400);
        setLocation(350,150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CalculateBills();
    }
}
