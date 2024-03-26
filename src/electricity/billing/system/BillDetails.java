package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.ResultSet;

public class BillDetails extends JFrame {

    String meterNoPass;
    JTable table;
    BillDetails(String meterNoPass){
        super("Bill Details");

        this.meterNoPass=meterNoPass;
        setBounds(300,50,700,650);
        setLayout(null);

        table = new JTable();
        try{
            Database database =new Database();
            ResultSet resultSet=database.statement.executeQuery("select * from bill where meter_no='"+meterNoPass+"'");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){

            e.printStackTrace();
        }

        JScrollPane sp= new JScrollPane(table);
        sp.setBounds(0,0,700,650);
        add(sp);

        setVisible(true);

    }

    public static void main(String[] args) {
        new BillDetails("");
    }
}
