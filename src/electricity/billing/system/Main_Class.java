package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener {
    String accType,meterNoPass;
    Main_Class(String accType,String meterNoPass){

        super("Main");

        this.meterNoPass=meterNoPass;
        this.accType=accType;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon backgroundImageIcon=new ImageIcon(ClassLoader.getSystemResource("Icon/ebs.png"));
        Image image=backgroundImageIcon.getImage().getScaledInstance(1366,830,Image.SCALE_DEFAULT);
        ImageIcon backgroundImageIconTwo=new ImageIcon(image);
        JLabel backgroundImageLabel=new JLabel(backgroundImageIconTwo);
        add(backgroundImageLabel);

        //--------------FOR MENU BAR-----------------------//
        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);



        //--------- OPTIONS OF MENU---------------------//
        JMenu menu=new JMenu("Menu");
        menu.setFont(new Font("serif",Font.PLAIN,18));


        JMenuItem nCustomer=new JMenuItem("New Customer");
        nCustomer.setFont(new Font("Monospace",Font.PLAIN,14));
        ImageIcon newCustomerImage=new ImageIcon(ClassLoader.getSystemResource("Icon/newcustomer.png"));
        Image newCustomerImageScale=newCustomerImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        nCustomer.setIcon(new ImageIcon(newCustomerImageScale));
        nCustomer.addActionListener(this);
        menu.add(nCustomer);

        JMenuItem customerDetails=new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("Monospace",Font.PLAIN,14));
        ImageIcon customerDetailsImage= new ImageIcon(ClassLoader.getSystemResource("Icon/customerDetails.png"));
        Image customerDetailsImageScale= customerDetailsImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(customerDetailsImageScale));
        customerDetails.addActionListener(this);
        menu.add(customerDetails);

        JMenuItem depositDetails=new JMenuItem("Deposit Details");
        depositDetails.setFont(new Font("Monospace",Font.PLAIN,14));
        ImageIcon depositDetailsImage=new ImageIcon(ClassLoader.getSystemResource("Icon/depositdetails.png"));
        Image depositDetailsImageScale=depositDetailsImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositDetails.setIcon(new ImageIcon(depositDetailsImageScale));
        depositDetails.addActionListener(this);
        menu.add(depositDetails);

        JMenuItem calculateBills=new JMenuItem("Calculate Bills");
        calculateBills.setFont(new Font("Monospace",Font.PLAIN,14));
        ImageIcon calculateBillsImage=new ImageIcon(ClassLoader.getSystemResource("Icon/calculatorbills.png"));
        Image calculateBillsImageScale=calculateBillsImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculateBills.setIcon(new ImageIcon(calculateBillsImageScale));
        calculateBills.addActionListener(this);
        menu.add(calculateBills);



        //--------------Options FOR INFORMATION--------------//
       JMenu information=new JMenu("Information");
       information.setFont(new Font("serif",Font.PLAIN,18));


       JMenuItem updateInformation=new JMenuItem("Update Information");
       updateInformation.setFont(new Font("Monospace",Font.PLAIN,14));
       ImageIcon updateInformationImage =new ImageIcon(ClassLoader.getSystemResource("Icon/refresh.png"));
       Image updateInformationImageScale=updateInformationImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       updateInformation.setIcon(new ImageIcon(updateInformationImageScale));
       updateInformation.addActionListener(this);
       information.add(updateInformation);

       JMenuItem viewInformation=new JMenuItem("View Information");
       viewInformation.setFont(new Font("monospace",Font.PLAIN,14));
       ImageIcon viewInformationImage=new ImageIcon(ClassLoader.getSystemResource("Icon/information.png"));
       Image viewInformationImageScale=viewInformationImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       viewInformation.setIcon(new ImageIcon(viewInformationImageScale));
       viewInformation.addActionListener(this);
       information.add(viewInformation);



       //-----------User menu-----------//
        JMenu user=new JMenu("User");
        user.setFont(new Font("serif",Font.PLAIN,18));


        JMenuItem payBills=new JMenuItem("Pay Bills");
        payBills.setFont(new Font("monospace",Font.PLAIN,14));
        ImageIcon payBillsImage=new ImageIcon(ClassLoader.getSystemResource("Icon/pay.png"));
        Image payBillsImageScale=payBillsImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        payBills.setIcon(new ImageIcon(payBillsImageScale));
        payBills.addActionListener(this);
        user.add(payBills);

        JMenuItem billDetails=new JMenuItem("Bill Details");
        billDetails.setFont(new Font("monospace",Font.PLAIN,14));
        ImageIcon billDetailsImage=new ImageIcon(ClassLoader.getSystemResource("Icon/bill detail.png"));
        Image billDetailsImageScale=billDetailsImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billDetails.setIcon(new ImageIcon(billDetailsImageScale));
        billDetails.addActionListener(this);
        user.add(billDetails);



        //---------- For bill menu-------------//
        JMenu bill=new JMenu("Bill");
        bill.setFont(new Font("serif",Font.PLAIN,18));


        JMenuItem generateBill=new JMenuItem("Generate Bill");
        generateBill.setFont(new Font("monospace",Font.PLAIN,14));
        ImageIcon generateBillImage=new ImageIcon(ClassLoader.getSystemResource("Icon/bill.png"));
        Image generateBillImageScale=generateBillImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        generateBill.setIcon(new ImageIcon(generateBillImageScale));
        generateBill.addActionListener(this);
        bill.add(generateBill);



        //----------For utility-------------//
        JMenu utility=new JMenu("Utility");
        utility.setFont(new Font("serif",Font.PLAIN,18));


        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setFont(new Font("monospace",Font.PLAIN,14));
        ImageIcon notepadImage=new ImageIcon(ClassLoader.getSystemResource("Icon/notepad.png"));
        Image notepadImageScale=notepadImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadImageScale));
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator=new JMenuItem("Calculator");
        calculator.setFont(new Font("monospace",Font.PLAIN,14));
        ImageIcon calculatorImage= new ImageIcon(ClassLoader.getSystemResource("Icon/calculator.png"));
        Image calculatorImageScale=calculatorImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculatorImageScale));
        calculator.addActionListener(this);
        utility.add(calculator);



        //--------Exit-----------//
        JMenu exit=new JMenu("Exit");
        exit.setFont(new Font("serif",Font.PLAIN,18));


        JMenuItem goExit=new JMenuItem("Exit");
        goExit.setFont(new Font("monospace",Font.PLAIN,14));
        ImageIcon goExitImage=new ImageIcon(ClassLoader.getSystemResource("Icon/exit.png"));
        Image goExitImageScale=goExitImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        goExit.setIcon(new ImageIcon(goExitImageScale));
        goExit.addActionListener(this);
        exit.add(goExit);


        if(accType.equals("Admin")){
            menuBar.add(menu);
        }
        else {
            menuBar.add(bill);
            menuBar.add(information);
            menuBar.add(user);

        }

        menuBar.add(utility);
        menuBar.add(exit);


        setLayout(new FlowLayout());
        setVisible(true);
    }
    public static void main(String[] args) {
        new Main_Class("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if(msg.equals("New Customer")){
            new NewCustomer();
            setVisible(false);
        }
        else if (msg.equals("Customer Details")) {
            new CustomerDetails();
            setVisible(false);
        }
        else if (msg.equals("Deposit Details")) {
            new DepositDetails();
            setVisible(false);
        }
        else if (msg.equals("Calculate Bills")) {
            new CalculateBills();
            setVisible(false);
        }
        else if (msg.equals("Update Information")) {
            new UpdateInformation(meterNoPass);
            setVisible(false);
        }
        else if (msg.equals("View Information")) {
            new ViewInformation(meterNoPass);
            setVisible(false);
        }
        else if (msg.equals("Pay Bills")) {
           // new ViewInformation();
            setVisible(false);
        }
        else if (msg.equals("Bill Details")) {
            // new ViewInformation();
            setVisible(false);
        }
        else if (msg.equals("Generate Bill")) {
            // new ViewInformation();
            setVisible(false);
        }
        else if (msg.equals("Notepad")) {
            // new ViewInformation();
            setVisible(false);
        }
        else if (msg.equals("Calculator")) {
            // new ViewInformation();
            setVisible(false);
        }
        else if (msg.equals("Exit")) {

           setVisible(false);
        }

    }
}
