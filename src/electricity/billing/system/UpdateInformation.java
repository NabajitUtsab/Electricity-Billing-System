package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateInformation extends JFrame implements ActionListener {
String meterNoPass;

JLabel heading,name,nameTextLabel,meterNo,meterNoTextLabel,address,city,email,phone;
JTextField addressText,cityText,emailText,phoneText;
JButton update,cancel;
    UpdateInformation(String meterNoPass){
        super("Update Information");

        this.meterNoPass=meterNoPass;
        setBounds(300,150,777,450);
        getContentPane().setBackground(new Color(229,255,227));
        setLayout(null);


        heading = new JLabel("Update Information");
        heading.setBounds(50,0,300,40);
        heading.setFont(new Font("serif",Font.BOLD,20));
        heading.setForeground(Color.red);
        add(heading);

        name = new JLabel("Name");
        name.setBounds(30,70,100,20);
        add(name);

        nameTextLabel=new JLabel("");
        nameTextLabel.setBounds(150,70,160,20);
        add(nameTextLabel);

        meterNo = new JLabel("Meter No");
        meterNo.setBounds(30,110,100,20);
        add(meterNo);

        meterNoTextLabel = new JLabel("");
        meterNoTextLabel.setBounds(150,110,160,20);
        add(meterNoTextLabel);

        address = new JLabel("Address");
        address.setBounds(30,150,100,20);
        add(address);

        addressText = new JTextField();
        addressText.setBounds(150,150,160,20);
        add(addressText);

        city = new JLabel("City");
        city.setBounds(30,190,100,20);
        add(city);

        cityText = new JTextField();
        cityText.setBounds(150,190,160,20);
        add(cityText);

        email = new JLabel("Email");
        email.setBounds(30,230,100,20);
        add(email);

        emailText = new JTextField();
        emailText.setBounds(150,230,160,20);
        add(emailText);

        phone = new JLabel("Phone");
        phone.setBounds(30,270,100,20);
        add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(150,270,160,20);
        add(phoneText);

        try{
            Database database = new Database();
            ResultSet resultSet = database.statement.executeQuery("select * from new_customer where meter_no='"+meterNoPass+"'");
            while(resultSet.next()){
                nameTextLabel.setText(resultSet.getString("name"));
                meterNoTextLabel.setText(resultSet.getString("meter_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }



        update=new JButton("Update");
        update.setBounds(50,360,120,25);
        update.setBackground(new Color(33,106,145));
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,360,120,25);
        cancel.setBackground(new Color(33,106,145));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon imageIcon =new ImageIcon(ClassLoader.getSystemResource("Icon/update.png"));
        Image imageAfterScale = imageIcon.getImage().getScaledInstance(400,410,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(imageAfterScale);
        JLabel imageLabel = new JLabel(imageIcon1);
        imageLabel.setBounds(370,0,400,410);
        add(imageLabel);

        setVisible(true);
    }


    public static void main(String[] args) {
        new UpdateInformation("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==update){
            String sAddress = addressText.getText();
            String sCity =cityText.getText();
            String sEmail=emailText.getText();
            String sPhone=phoneText.getText();

            try {
                Database database =new Database();
                database.statement.executeUpdate("update new_customer set address='"+sAddress+"',city='"+sCity+"',email='"+sEmail+"',phone='"+sPhone+"' where meter_no='"+meterNoPass+"' ");
                JOptionPane.showMessageDialog(null,"Updated successfully");
                setVisible(false);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        else {
            new Main_Class("Custmer",meterNoPass);
            setVisible(false);
        }

    }
}
