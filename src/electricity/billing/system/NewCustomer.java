package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NewCustomer extends JFrame implements ActionListener {
    JLabel heading,customerName,meterNum,address,city,email,phone,meterNumText;
    JTextField customerNameText,addressText,cityText,emailText,phoneText;
    JButton nextButton,cancelButton;
    NewCustomer()
    {
        super("New Customer");
        setSize(700,500);
        setLocation(350,150);

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        heading = new JLabel("NEW CUSTOMER");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        customerName=new JLabel("Customer Name");
        customerName.setBounds(50,80,100,20);
        panel.add(customerName);

        customerNameText=new JTextField();
        customerNameText.setBounds(180,80,150,20);
        panel.add(customerNameText);

        meterNum =new JLabel("Meter Number");
        meterNum.setBounds(50,120,100,20);
        panel.add(meterNum);

        meterNumText=new JLabel();
        meterNumText.setBounds(180,120,150,20);
        panel.add(meterNumText);
        //-------------RANDOM NUMBER GENERATING FOR meterNumText---------------------//
        Random randomNumber=new Random();
        long number=randomNumber.nextLong()%1000000;
        meterNumText.setText(""+Math.abs(number));

        address=new JLabel("Address");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addressText=new JTextField();
        addressText.setBounds(180,160,150,20);
        panel.add(addressText);

        city=new JLabel("City");
        city.setBounds(50,200,100,20);
        panel.add(city);

        cityText=new JTextField();
        cityText.setBounds(180,200,150,20);
        panel.add(cityText);

        email=new JLabel("Email");
        email.setBounds(50,240,100,20);
        panel.add(email);

        emailText=new JTextField();
        emailText.setBounds(180,240,150,20);
        panel.add(emailText);

        phone =new JLabel("Phone");
        phone.setBounds(50,280,100,20);
        panel.add(phone);

        phoneText=new JTextField();
        phoneText.setBounds(180,280,150,20);
        panel.add(phoneText);

        //Button creating
        nextButton=new JButton("Next");
        nextButton.setBounds(120,350,100,25);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.white);
        nextButton.addActionListener(this);
        panel.add(nextButton);

        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(250,350,100,25);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.white);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        //setLayout(null);
        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon newCusImage=new ImageIcon(ClassLoader.getSystemResource("Icon/boy.png"));
        Image scaleImage=newCusImage.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon newCusImage2=new ImageIcon(scaleImage);
        JLabel imageLabel=new JLabel(newCusImage2);
        add(imageLabel,"West");


        setVisible(true);
    }

    public static void main(String[] args) {

        new NewCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nextButton){
            String sname=customerNameText.getText();
            String smeter=meterNumText.getText();
            String saddress=addressText.getText();
            String scity=cityText.getText();
            String semail=emailText.getText();
            String sphone=phoneText.getText();


            String query_customer="insert into new_customer values('"+sname+"','"+smeter+"','"+saddress+"','"+scity+"','"+semail+"','"+sphone+"')";
            String query_signup="insert into signup values('"+smeter+"', '' ,'"+sname+"', '' , '' )";


            try {
                Database c=new Database();
                c.statement.executeUpdate(query_customer);
                c.statement.executeUpdate(query_signup);

                JOptionPane.showMessageDialog(null," Customer data added successfully");
                setVisible(false);
                new Meter_info(smeter);

            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }

    }
}
