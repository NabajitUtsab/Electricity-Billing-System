package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DepositDetails extends JFrame implements ActionListener {
    JLabel searchMeter,searchMonth;
    Choice searchMeterChoice,searchMonthChoice;
    JButton searchButton,printButton,closeButton;
    JTable table;

    DepositDetails(){
        super("Deposit Details");
        getContentPane().setBackground(new Color(117, 225, 145));
        setSize(700,500);
        setLocation(350,150);
        setLayout(null);

        searchMeter = new JLabel("Search by meter no");
        searchMeter.setBounds(20,20,150,20);
        add(searchMeter);

        searchMeterChoice = new Choice();
        searchMeterChoice.setBounds(180,20,150,20);
        add(searchMeterChoice);
        try{
            Database database =new Database();
            ResultSet resultSet = database.statement.executeQuery("select * from bill");
            while(resultSet.next()){
                searchMeterChoice.add(resultSet.getString("meter_no"));
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }

        searchMonth = new JLabel("Search by month");
        searchMonth .setBounds(350,20,100,20);
        add(searchMonth);

        searchMonthChoice = new Choice();
        searchMonthChoice.setBounds(470,20,150,20);
        searchMonthChoice.add("January");
        searchMonthChoice.add("February");
        searchMonthChoice.add("March");
        searchMonthChoice.add("April");
        searchMonthChoice.add("May");
        searchMonthChoice.add("June");
        searchMonthChoice.add("July");
        searchMonthChoice.add("August");
        searchMonthChoice.add("Septemer");
        searchMonthChoice.add("October");
        searchMonthChoice.add("November");
        searchMonthChoice.add("December");
        add(searchMonthChoice);

        searchButton = new JButton("Search");
        searchButton.setBounds(20,70,100,25);
        searchButton.setBackground(Color.WHITE);
        searchButton.setForeground(Color.BLACK);
        searchButton.addActionListener(this);
        add(searchButton);

        printButton = new JButton("Print");
        printButton.setBounds(140,70,100,25);
        printButton.setBackground(Color.WHITE);
        printButton.setForeground(Color.BLACK);
        printButton.addActionListener(this);
        add(printButton);

        closeButton = new JButton("Close");
        closeButton.setBounds(520,70,100,25);
        closeButton.setBackground(Color.WHITE);
        closeButton.setForeground(Color.BLACK);
        closeButton.addActionListener(this);
        add(closeButton);


        //-------------Table--------------
        table = new JTable();
        try{
            Database database = new Database();
            ResultSet resultSet=database.statement.executeQuery("select * from bill");

            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception exception){
            exception.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,700,500);
        scrollPane.setBackground(Color.WHITE);
        add(scrollPane);



        setVisible(true);
    }

    public static void main(String[] args) {
        new DepositDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==searchButton){
            String query = "select * from bill where meter_no='"+searchMeterChoice.getSelectedItem()+"' and month = '"+searchMonthChoice.getSelectedItem()+"' ";
            try{
                Database database = new Database();
                ResultSet resultSet = database.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch(Exception exception){
                exception.printStackTrace();
            }
        }
        else if(e.getSource()==printButton){
            try {
                table.print();
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }

    }
}
