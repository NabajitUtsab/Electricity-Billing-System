package electricity.billing.system;



import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class CustomerDetails extends JFrame {
    JLabel searchMeter,searchName;
    Choice searchMeterChoice,searchNameChoice;
    JTable table;
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

            ///-------- will start from there

        }
        catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);

    }
    public static void main(String[] args) {
        new CustomerDetails();
    }
}
