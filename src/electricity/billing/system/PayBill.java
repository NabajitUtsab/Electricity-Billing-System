package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class PayBill extends JFrame implements ActionListener {

    JLabel heading,meterNo,name,month,unit,totalBill,status;
    JLabel meterNoText,nameText,unitText,totalBillText,statusText;
    Choice monthChoice;

    JButton payButton,backButton;
    String meterNoPass;
    PayBill(String meterNoPass){
        super("Pay Bills");
        this.meterNoPass=meterNoPass;

        setBounds(250,80,900,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        heading = new JLabel("Pay Bills");
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        heading.setBounds(120,5,400,30);
        add(heading);

        meterNo=new JLabel("Meter No");
        meterNo.setBounds(35,80,200,20);
        add(meterNo);

        meterNoText=new JLabel("");
        meterNoText.setBounds(270,80,200,20);
        add(meterNoText);

        name = new JLabel("Name");
        name.setBounds(35,140,200,20);
        add(name);

        nameText = new JLabel("");
        nameText.setBounds(270,140,200,20);
        add(nameText);

        try{
            Database database=new Database();
            ResultSet resultSet=database.statement.executeQuery("select * from new_customer where meter_no='"+meterNoPass+"'");
            while (resultSet.next()){
                meterNoText.setText(resultSet.getString("meter_no"));
                nameText.setText(resultSet.getString("name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        month = new JLabel("Month");
        month.setBounds(35,200,200,20);
        add(month);

        monthChoice = new Choice();
        monthChoice.setBounds(270,200,200,20);
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
        add(monthChoice);

        unit = new JLabel("Unit");
        unit.setBounds(35,260,200,20);
        add(unit);

        unitText = new JLabel("");
        unitText.setBounds(270,260,200,20);
        add(unitText);

        totalBill = new JLabel("Total Bill");
        totalBill.setBounds(35,320,200,20);
        add(totalBill);

        totalBillText=new JLabel("");
        totalBillText.setBounds(270,320,200,20);
        add(totalBillText);

        status = new JLabel("Status");
        status.setBounds(35,380,200,20);
        add(status);

        statusText=new JLabel("");
        statusText.setBounds(270,380,200,20);
        statusText.setForeground(Color.red);
        add(statusText);



        monthChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Database database = new Database();
                    ResultSet resultSet = database.statement.executeQuery("select * from bill where meter_no ='"+meterNoPass+"'and month='"+monthChoice.getSelectedItem()+"'");
                    while (resultSet.next()){
                        unitText.setText(resultSet.getString("unit"));
                        totalBillText.setText(resultSet.getString("total_bill"));
                        statusText.setText(resultSet.getString("status"));
                    }

                }catch(Exception exception){
                    exception.printStackTrace();
                }
            }
        });



        payButton = new JButton("Pay");
        payButton.setBounds(100,460,100,25);
        payButton.setBackground(Color.BLACK);
        payButton.setForeground(Color.WHITE);
        payButton.addActionListener(this);
        add(payButton);

        backButton = new JButton("Back");
        backButton.setBounds(230,460,100,25);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon imageIcon =new ImageIcon(ClassLoader.getSystemResource("Icon/pay.png"));
        Image imageAfterScale = imageIcon.getImage().getScaledInstance(400,410,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(imageAfterScale);
        JLabel imageLabel = new JLabel(imageIcon1);
        imageLabel.setBounds(500,30,380,410);
        add(imageLabel);

        setVisible(true);

    }

    public static void main(String[] args) {
        new PayBill("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==payButton){
            try{
                Database database = new Database();
                database.statement.executeUpdate("UPDATE bill set status='Paid' where meter_no='"+meterNoPass+"' and month ='"+monthChoice.getSelectedItem()+"' ");

            } catch (Exception exception){
                exception.printStackTrace();
            }
            setVisible(false);
            new PaymentBill(meterNoPass);

        }
        else {
            new Main_Class("Customer",meterNoPass);
            setVisible(false);
        }
    }
}
