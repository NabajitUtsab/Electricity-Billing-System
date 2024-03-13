package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

public class CustomerDetails extends JFrame implements ActionListener{
    JLabel searchMeter,searchName;
    Choice searchMeterChoice,searchNameChoice;
    JTable table;
    JButton searchButton,printButton,closeButton;
    CustomerDetails(){
        super("Customer Details");

        getContentPane().setBackground(new Color(192,186,254));
        setSize(700,500);
        setLocation(350,150);
        setLayout(null);

        searchMeter = new JLabel("Search by Meter No");
        searchMeter.setBounds(20,20,150,20);
        add(searchMeter);

        searchMeterChoice=new Choice();
        searchMeterChoice.setBounds(180,20,150,20);
        add(searchMeterChoice);

        try{
            Database database=new Database();
            ResultSet resultSet=database.statement.executeQuery("select * from new_customer");
            while(resultSet.next()){
                searchMeterChoice.add(resultSet.getString("meter_no"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }


        searchName = new JLabel("Search by Name");
        searchName.setBounds(370,20,100,20);
        add(searchName);

        searchNameChoice = new Choice();
        searchNameChoice.setBounds(510,20,150,20);
        add(searchNameChoice);

        try{
            Database database=new Database();
            ResultSet resultSet= database.statement.executeQuery("Select * FROM new_customer");
            while(resultSet.next()){
                searchNameChoice.add(resultSet.getString("name"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }


        table = new JTable();
        try {
            Database database =new Database();
            ResultSet resultSet= database.statement.executeQuery("select * from new_customer");

            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }
        catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane scrollPane =new JScrollPane(table);
        scrollPane.setBounds(0,100,700,500);
        scrollPane.setBackground(Color.white);
        add(scrollPane);


        searchButton = new JButton("Search");
        searchButton.setBounds(20,70,80,20);
        searchButton.setBackground(Color.WHITE);
        searchButton.setForeground(Color.BLACK);
        searchButton.addActionListener(this);
        add(searchButton);

        printButton = new JButton("Print");
        printButton.setBounds(120,70,80,20);
        printButton.setBackground(Color.WHITE);
        printButton.setForeground(Color.BLACK);
        printButton.addActionListener(this);
        add(printButton);

        closeButton = new JButton("Close");
        closeButton.setBounds(550,70,80,20);
        closeButton.setBackground(Color.WHITE);
        closeButton.setForeground(Color.BLACK);
        closeButton.addActionListener(this);
        add(closeButton);

        setVisible(true);

    }
    public static void main(String[] args) {
        new CustomerDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==searchButton){
            String query_search = "select * from new_customer where meter_no ='"+searchMeterChoice.getSelectedItem()+"' and name = '"+searchNameChoice.getSelectedItem()+"' ";
            try{
                Database database = new Database();
                ResultSet resultSet = database.statement.executeQuery(query_search);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch(Exception exception){
                exception.printStackTrace();
            }
        }
        else if(e.getSource()==printButton){
            try{
                table.print();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }

    }
}
