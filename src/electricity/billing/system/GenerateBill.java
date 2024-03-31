package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterGraphics;
import java.sql.ResultSet;

public class GenerateBill extends JFrame implements ActionListener {
String meterNoPass;
JLabel selectMonth,name,meterNo,address,city,email,phone,nameText,meterNoText,addressText,cityText,emailText,phoneText ;
JLabel heading1,meterLoc,meterType,meterPhase,meterBill,meterLocText,meterTypeText,meterPhaseText,meterBillText;

JLabel heading2,costPerUnit, meterRent, serviceCharge, serviceTax, fixedTax,costPerUnitText, meterRentText, serviceChargeText, serviceTaxText, fixedTaxText;

JLabel heading3,month,unit,totalBill,unitText,totalBillText,monthText;

JButton genBillButton,backButton;
Choice monthChoice;

    GenerateBill(String meterNoPass){
        super("Generate Bills");
        this.meterNoPass=meterNoPass;
        setBounds(270,20,850,700);
        getContentPane().setBackground(new Color(125,222,150));
        setLayout(null);

        selectMonth=new JLabel("Select Month");
        selectMonth.setBounds(120,10,100,25);
        add(selectMonth);

        monthChoice=new Choice();
        monthChoice.setBounds(250,10,150,25);
        monthChoice.add("January");
        monthChoice.add("February");
        monthChoice.add("March");
        monthChoice.add("April");
        monthChoice.add("May");
        monthChoice.add("June");
        monthChoice.add("July");
        monthChoice.add("August");
        monthChoice.add("September");
        monthChoice.add("October");
        monthChoice.add("November");
        monthChoice.add("December");
        add(monthChoice);

        genBillButton=new JButton("Generate Bill");
        genBillButton.setBounds(430,10,150,23);
        genBillButton.setBackground(Color.WHITE);
        genBillButton.setForeground(Color.black);
        genBillButton.addActionListener(this);
        add(genBillButton);

        backButton=new JButton("Back");
        backButton.setBounds(610,10,150,23);
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.black);
        backButton.addActionListener(this);
        add(backButton);



        name = new JLabel("Name");
        name.setBounds(70,80,100,20);
        add(name);

        nameText = new JLabel("");
        nameText.setBounds(200,80,150,20);
        add(nameText);


        meterNo = new JLabel("Meter No");
        meterNo.setBounds(70,120,100,20);
        add(meterNo);

        meterNoText = new JLabel("");
        meterNoText.setBounds(200,120,150,20);
        add(meterNoText);


        address = new JLabel("Address");
        address.setBounds(70,160,100,20);
        add(address);

        addressText = new JLabel("");
        addressText.setBounds(200,160,150,20);
        add(addressText);


        city = new JLabel("City");
        city.setBounds(370,80,100,20);
        add(city);

        cityText = new JLabel("");
        cityText.setBounds(500,80,150,20);
        add(cityText);


        email = new JLabel("Email");
        email.setBounds(370,120,100,20);
        add(email);

        emailText = new JLabel("");
        emailText.setBounds(500,120,150,20);
        add(emailText);


        phone = new JLabel("Phone");
        phone.setBounds(370,160,100,20);
        add(phone);

        phoneText = new JLabel("");
        phoneText.setBounds(500,160,150,20);
        add(phoneText);



        try{
            Database database=new Database();
            ResultSet resultSet=database.statement.executeQuery("select * from new_customer where meter_no='"+meterNoPass+"'");

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



        heading1 =new JLabel("Meter Information");
        heading1.setBounds(70,200,200,20);
        heading1.setFont(new Font("Tahoma",Font.ITALIC,20));
        heading1.setForeground(Color.red);
        add(heading1);

        meterLoc = new JLabel("Meter Location");
        meterLoc.setBounds(70,240,100,20);
        add(meterLoc);

        meterLocText =new JLabel("");
        meterLocText.setBounds(200,240,150,20);
        add(meterLocText);

        meterType=new JLabel("Meter Type");
        meterType.setBounds(70,280,100,20);
        add(meterType);

        meterTypeText =new JLabel("");
        meterTypeText.setBounds(200,280,150,20);
        add(meterTypeText);

        meterPhase = new JLabel("Phase Code");
        meterPhase.setBounds(370,240,100,20);
        add(meterPhase);

        meterPhaseText=new JLabel("");
        meterPhaseText.setBounds(500,240,150,20);
        add(meterPhaseText);

        meterBill = new JLabel("Bill Type");
        meterBill.setBounds(370,280,100,20);
        add(meterBill);

        meterBillText=new JLabel("");
        meterBillText.setBounds(500,280,150,20);
        add(meterBillText);

        try{
            Database database =new Database();
            ResultSet resultSet=database.statement.executeQuery("select * from meter_info where meter_number ='"+meterNoPass+"'");
            while(resultSet.next())
            {
                meterLocText.setText(resultSet.getString("meter_location"));
                meterTypeText.setText(resultSet.getString("meter_type"));
                meterPhaseText.setText(resultSet.getString("phase_code"));
                meterBillText.setText(resultSet.getString("bill_type"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }



        heading2 =new JLabel("Tax Information");
        heading2.setBounds(70,320,200,20);
        heading2.setFont(new Font("Tahoma",Font.ITALIC,20));
        heading2.setForeground(Color.red);
        add(heading2);

        costPerUnit = new JLabel("Cost Per Unit");
        costPerUnit.setBounds(70,360,100,20);
        add(costPerUnit);

        costPerUnitText =new JLabel("");
        costPerUnitText.setBounds(200,360,150,20);
        add(costPerUnitText);

        meterRent=new JLabel("Meter Rent");
        meterRent.setBounds(70,400,100,20);
        add(meterRent);

        meterRentText =new JLabel("");
        meterRentText.setBounds(200,400,150,20);
        add(meterRentText);

        serviceCharge=new JLabel("Service Charge");
        serviceCharge.setBounds(70,440,100,20);
        add(serviceCharge);

        serviceChargeText =new JLabel("");
        serviceChargeText.setBounds(200,440,150,20);
        add(serviceChargeText);

        serviceTax = new JLabel("Service Tax");
        serviceTax.setBounds(370,360,100,20);
        add(serviceTax);

        serviceTaxText=new JLabel("");
        serviceTaxText.setBounds(500,360,150,20);
        add(  serviceTaxText);

        fixedTax = new JLabel("Fixed Tax");
        fixedTax.setBounds(370,400,100,20);
        add(fixedTax);

        fixedTaxText=new JLabel("");
        fixedTaxText.setBounds(500,400,150,20);
        add(fixedTaxText);

        try{
            Database database =new Database();
            ResultSet resultSet=database.statement.executeQuery("select * from tax");
            while(resultSet.next())
            {

                costPerUnitText.setText(resultSet.getString("cost_per_unit")+" Taka");
                meterRentText.setText(resultSet.getString("meter_rent")+" Taka");
                serviceChargeText.setText(resultSet.getString("service_charge")+" Taka");
                serviceTaxText.setText(resultSet.getString("service_tax")+" Taka");
                fixedTaxText.setText(resultSet.getString("fixed_tax")+" Taka");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }


        heading3 =new JLabel("Bill Information");
        heading3.setBounds(70,480,200,20);
        heading3.setFont(new Font("Tahoma",Font.ITALIC,20));
        heading3.setForeground(Color.red);
        add(heading3);

        month = new JLabel("Current Month");
        month.setBounds(70,520,100,20);
        add(month);

        monthText =new JLabel("");
        monthText.setBounds(200,520,150,20);
        add(monthText);

        unit = new JLabel("Unit");
        unit.setBounds(70,560,100,20);
        add(unit);

        unitText = new JLabel("");
        unitText.setBounds(200,560,150,20);
        add(unitText);

        totalBill = new JLabel("Total Bill");
        totalBill.setBounds(370,520,100,20);
        add(totalBill);

        totalBillText=new JLabel("");
        totalBillText.setBounds(500,520,150,20);
        add(totalBillText);

        setVisible(true);

    }
    public static void main(String[] args) {
        new GenerateBill("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==genBillButton){
            try {

                Database database=new Database();
                ResultSet resultSet=database.statement.executeQuery("select * from bill where meter_no='"+meterNoPass+"' and month='"+monthChoice.getSelectedItem()+"'");
                //monthText.setText(monthChoice.getSelectedItem());
                while (resultSet.next()){
                    monthText.setText(resultSet.getString("month"));
                    unitText.setText(resultSet.getString("unit"));
                    totalBillText.setText(resultSet.getString("total_bill")+" Taka");

                }

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
