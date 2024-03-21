package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewInformation extends JFrame implements ActionListener {

    JLabel heading,name,meterNo,address,city,email,phone;
    JLabel nameText,meterNoText,addressText,cityText,emailText,phoneText;
    JButton cancelButton;
    String getMeterNo;
    ViewInformation(String getMeterNo){
        super("View Customer Information");

        this.getMeterNo=getMeterNo;
        setBounds(270,70,850,650);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        heading = new JLabel("View Customer Information");
        heading.setBounds(250,0,300,40);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        name = new JLabel("Name");
        name.setBounds(70,80,100,20);
        add(name);

        nameText = new JLabel("");
        nameText.setBounds(200,80,150,20);
        add(nameText);


        meterNo = new JLabel("Meter No");
        meterNo.setBounds(70,140,100,20);
        add(meterNo);

        meterNoText = new JLabel("");
        meterNoText.setBounds(200,140,150,20);
        add(meterNoText);


        address = new JLabel("Address");
        address.setBounds(70,200,100,20);
        add(address);

        addressText = new JLabel("");
        addressText.setBounds(200,200,150,20);
        add(addressText);


        city = new JLabel("City");
        city.setBounds(370,80,100,20);
        add(city);

        cityText = new JLabel("");
        cityText.setBounds(500,80,150,20);
        add(cityText);


        email = new JLabel("Email");
        email.setBounds(370,140,100,20);
        add(email);

        emailText = new JLabel("");
        emailText.setBounds(500,140,150,20);
        add(emailText);


        phone = new JLabel("Phone");
        phone.setBounds(370,200,100,20);
        add(phone);

        phoneText = new JLabel("");
        phoneText.setBounds(500,200,150,20);
        add(phoneText);



        try{
            Database database=new Database();
            ResultSet resultSet=database.statement.executeQuery("select * from new_customer where meter_no='"+getMeterNo+"'");

            if(resultSet.next()){
                nameText.setText(resultSet.getString("name"));
                meterNoText.setText(resultSet.getString("meter_no"));
                addressText.setText(resultSet.getString("address"));
                cityText.setText(resultSet.getString("city"));
                emailText.setText(resultSet.getString("email"));
                phoneText.setText(resultSet.getString("phone"));

            }

        }catch(Exception exception){
           exception.printStackTrace();
        }


        cancelButton =new JButton("Cancel");
        cancelButton.setBackground(new Color(24, 118, 212));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(220,300,120,25);
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon imageIcon =new ImageIcon(ClassLoader.getSystemResource("Icon/viewInfo.png"));
        Image image = imageIcon.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon imageIconAfterScale=new ImageIcon(image);
        JLabel imageLabel= new JLabel(imageIconAfterScale);
        imageLabel.setBounds(100,320,600,300);
        add(imageLabel);


        setVisible(true);
    }


    public static void main(String[] args) {
        new ViewInformation("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancelButton){

            setVisible(false);
        }


    }
}
