package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField userText,passText;

    Choice loggingChoice;
    JButton loginButton,cancelButton,signUpButton;
    Login()
    {
        super("LogIn");
        getContentPane().setBackground(new Color(3, 252, 161));

        ImageIcon profileImage=new ImageIcon(ClassLoader.getSystemResource("Icon/profile.png"));
        Image imageTwo=profileImage.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageForShow=new ImageIcon(imageTwo);
        JLabel imageLabel=new JLabel(imageForShow);
        imageLabel.setBounds(10,10,250,250);
        add(imageLabel);


        //Jlabel use for showing text to form
        JLabel username=new JLabel("USERNAME");
        username.setBounds(300,60,100,20);
        add(username);

        userText=new JTextField();
        userText.setBounds(400,60,200,20);
        add(userText);

        JLabel password=new JLabel("PASSWORD");
        password.setBounds(300,100,100,20);
        add(password);

        passText=new JTextField();
        passText.setBounds(400,100,200,20);
        add(passText);


        JLabel loggingAs=new JLabel("LOGGING AS");
        loggingAs.setBounds(300,140,100,20);
        add(loggingAs);

        loggingChoice=new Choice();
        loggingChoice.setBounds(400,140,200,20);
        loggingChoice.add("Customer");
        loggingChoice.add("Admin");
        add(loggingChoice);

        //*----------For button---------*//
        loginButton=new JButton("LOGIN");
        loginButton.setBounds(350,180,100,25);
        loginButton.setBackground(new Color(153, 209, 188));
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton=new JButton("CANCEL");
        cancelButton.setBounds(500,180,100,25);
        cancelButton.setBackground(new Color(153, 209, 188));
        cancelButton.addActionListener(this);
        add(cancelButton);

        signUpButton=new JButton("SIGNUP");
        signUpButton.setBounds(425,210,100,25);
        signUpButton.setBackground(new Color(153, 209, 188));
        signUpButton.addActionListener(this);
        add(signUpButton);


        setSize(640,300);
        setLocation(400,200);
        setLayout(null); //We will design layout that why we define the layout null
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginButton)
        {
            String sUserName=userText.getText();
            String sPassword=passText.getText();
            String user=loggingChoice.getSelectedItem();

            try {
                Database database=new Database();
                String query="select * from signup where username = '"+sUserName+"' and password= '"+sPassword+"' and usertype = '"+user+"' ";
                ResultSet resultSet= database.statement.executeQuery(query);
                if(resultSet.next())
                {
                    String meter_no = resultSet.getString("meter_no");
                    setVisible(false);
                    new Main_Class(user,meter_no);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid login");
                }

            }catch (Exception logInException)
            {
                logInException.printStackTrace();
            }

        } else if (e.getSource()==cancelButton) {
            setVisible(false);

        } else if (e.getSource()==signUpButton) {
            setVisible(false);
            new Signup();
            

        }
    }
}
