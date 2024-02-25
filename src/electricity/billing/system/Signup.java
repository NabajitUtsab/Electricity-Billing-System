package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Signup extends JFrame implements ActionListener {
    Choice choicingAsText;
    JTextField meterNoText,employerIdText,userNameText,nameText,passwordText;
    JButton createButton,backButton;
    Signup(){
        super("SignUp");
        getContentPane().setBackground(new Color(168,203,255));

        JLabel createAs=new JLabel("Create Account As");
        createAs.setBounds(30,50,125,20);
        add(createAs);

        choicingAsText=new Choice();
        choicingAsText.setBounds(170,50,125,20);
        choicingAsText.add("Customer");
        choicingAsText.add("Admin");
        add(choicingAsText);

        JLabel meterNo=new JLabel("METER NUMBER");
        meterNo.setBounds(30,100,125,20);
        meterNo.setVisible(true);
        add(meterNo);

        meterNoText=new JTextField();
        meterNoText.setBounds(170,100,125,20);
        meterNoText.setVisible(true);
        add(meterNoText);

        JLabel employerId=new JLabel("EMPLOYER ID");
        employerId.setBounds(30,100,125,20);
        employerId.setVisible(false);
        add(employerId);

        employerIdText=new JTextField();
        employerIdText.setBounds(170,100,125,20);
        employerIdText.setVisible(false);
        add(employerIdText);

        JLabel userName=new JLabel("USERNAME");
        userName.setBounds(30,140,125,20);
        add(userName);

        userNameText=new JTextField();
        userNameText.setBounds(170,140,125,20);
        add(userNameText);

        JLabel name=new JLabel("NAME");
        name.setBounds(30,180,125,20);
        add(name);

        nameText=new JTextField();
        nameText.setBounds(170,180,125,20);
        add(nameText);

        JLabel password=new JLabel("PASSWORD");
        password.setBounds(30,220,125,20);
        add(password);

        passwordText=new JTextField();
        passwordText.setBounds(170,220,125,20);
        add(passwordText);




        choicingAsText.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user=choicingAsText.getSelectedItem();
                if(user.equals("Admin"))
                {
                    meterNo.setVisible(false);
                    meterNoText.setVisible(false);

                    employerId.setVisible(true);
                    employerIdText.setVisible(true);

                }
                else
                {
                    meterNo.setVisible(true);
                    meterNoText.setVisible(true);

                    employerId.setVisible(false);
                    employerIdText.setVisible(false);

                }

            }
        });

        ///----------Buttons----------///
        createButton=new JButton("CREATE");
        createButton.setBounds(50,285,100,25);
        createButton.setBackground(new Color(66,127,219));
        createButton.setForeground(Color.BLACK);
        createButton.addActionListener(this);
        add(createButton);

        backButton=new JButton("BACK");
        backButton.setBounds(190,285,100,25);
        backButton.setBackground(new Color(66,127,219));
        backButton.setForeground(Color.BLACK);
        backButton.addActionListener(this);
        add(backButton);


        ImageIcon imageForSignup=new ImageIcon(ClassLoader.getSystemResource("Icon/boy.png"));
        Image image=imageForSignup.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon boyImage= new ImageIcon(image);

        JLabel imageForSignupLabel=new JLabel(boyImage);
        imageForSignupLabel.setBounds(320,40,250,250);
        add(imageForSignupLabel);


        setSize(600,400);
        setLocation(400,200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Signup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==createButton)
        {
            String sLoggingAs=choicingAsText.getSelectedItem();
        //    meterNoText,employerIdText,userNameText,nameText,passwordText;
            String sUserName=userNameText.getText();
            String sName=nameText.getText();
            String sPassword=passwordText.getText();
            String sMeterNo=meterNoText.getText();
            try{
                Database database=new Database();
                String query="insert into Signup value ('"+sMeterNo+"','"+sUserName+"','"+sName+"','"+sPassword+"','"+sLoggingAs+"')";

                database.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account Created Successfully");

                setVisible(false);
                new Login();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }


        } else if (e.getSource()==backButton) {
            setVisible(false);
            new Login();
        }

    }
}
