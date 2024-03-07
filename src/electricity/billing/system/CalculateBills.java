package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class CalculateBills extends JFrame implements ActionListener {
    JLabel heading,meterNum,name,unitConsumed,month,nameText,address,addressText;
    JTextField unitConsumedText;
    Choice meterNumChoice,monthChoice;
    JButton submit,cancel;
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
        meterNum.setBounds(50,80,100,20);
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
        meterNumChoice.setBounds(150,80,100,20);
        panel.add(meterNumChoice);


        name = new JLabel("Name");
        name .setBounds(50,120,100,20);
        panel.add(name);

        nameText = new JLabel("");
        nameText.setBounds(150,120,150,20);
        panel.add(nameText);


        address = new JLabel("Address");
        address .setBounds(50,160,100,20);
        panel.add(address);

        addressText = new JLabel("");
        addressText.setBounds(150,160,150,20);
        panel.add(addressText);


        try{
            Database c= new Database();
            ResultSet resultSet=c.statement.executeQuery("select * from new_customer where meter_no='"+meterNumChoice.getSelectedItem()+"' ");
            while(resultSet.next()){
                nameText.setText(resultSet.getString("name"));
                addressText.setText(resultSet.getString("address"));
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }

        //---- Updated the name and address text----
        meterNumChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Database c= new Database();
                    ResultSet resultSet=c.statement.executeQuery("select * from new_customer where meter_no='"+meterNumChoice.getSelectedItem()+"' ");
                    while(resultSet.next()){
                        nameText.setText(resultSet.getString("name"));
                        addressText.setText(resultSet.getString("address"));
                    }

                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });


        unitConsumed=new JLabel("Unit Consumed");
        unitConsumed.setBounds(50,200,100,20);
        panel.add(unitConsumed);

        unitConsumedText=new JTextField();
        unitConsumedText.setBounds(150,200,100,20);
        panel.add(unitConsumedText);


        month = new JLabel("Month");
        month.setBounds(50,240,100,20);
        panel.add(month);

        monthChoice = new Choice();
        monthChoice.setBounds(150,240,100,20);
        monthChoice.add("January");
        monthChoice.add("February");
        monthChoice.add("March");
        monthChoice.add("April");
        monthChoice.add("May");
        monthChoice.add("June");
        monthChoice.add("July");
        monthChoice.add("August");
        monthChoice.add("September");
        monthChoice.add("October");
        monthChoice.add("November");
        monthChoice.add("December");
        panel.add(monthChoice);


        submit=new JButton("SUBMIT");
        submit.setBounds(60,300,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        panel.add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(200,300,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/budget.png"));
        Image image=imageIcon.getImage().getScaledInstance(250,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageLabel=new JLabel(imageIcon1);
        add(imageLabel,"East");

        setSize(650,400);
        setLocation(350,150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CalculateBills();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
