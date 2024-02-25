package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Meter_info extends JFrame implements ActionListener {
    JLabel heading,meterNumber,meterNumberText,meterLocation,meterType,phaseCode,billType,day,note,writtingNote;
    Choice meterLocationChoice,meterTypeChoice,phaseCodeChoice,billTypeChoice;
    JButton submitButton;

    String meter_no;
    Meter_info(String meter_no){


        super("Meter Information");

        this.meter_no=meter_no;
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.YELLOW);
        add(panel);

        heading=new JLabel("METER INFORMATION");
        heading.setBounds(180,10,300,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        meterNumber=new JLabel("Meter Number");
        meterNumber.setBounds(50,80,100,20);
        panel.add(meterNumber);

        meterNumberText=new JLabel(meter_no);
        meterNumberText.setBounds(180,80,100,20);
        panel.add(meterNumberText);

        meterLocation=new JLabel("Meter Location");
        meterLocation.setBounds(50,120,100,20);
        panel.add(meterLocation);

        meterLocationChoice=new Choice();
        meterLocationChoice.add("Outside");
        meterLocationChoice.add("Inside");
        meterLocationChoice.setBounds(180,120,150,20);
        panel.add(meterLocationChoice);

        meterType=new JLabel("Meter Type");
        meterType.setBounds(50,160,100,20);
        panel.add(meterType);

        meterTypeChoice = new Choice();
        meterTypeChoice.add("Electric Meter");
        meterTypeChoice.add("Solar Meter");
        meterTypeChoice.add("Smart Meter");
        meterTypeChoice.setBounds(180,160,150,20);
        panel.add(meterTypeChoice);

        phaseCode = new JLabel("Phase Code");
        phaseCode.setBounds(50,200,100,20);
        panel.add(phaseCode);

        phaseCodeChoice=new Choice();
        phaseCodeChoice.add("011");
        phaseCodeChoice.add("022");
        phaseCodeChoice.add("033");
        phaseCodeChoice.add("044");
        phaseCodeChoice.add("055");
        phaseCodeChoice.add("066");
        phaseCodeChoice.add("077");
        phaseCodeChoice.add("088");
        phaseCodeChoice.add("099");
        phaseCodeChoice.setBounds(180,200,150,20);
        panel.add(phaseCodeChoice);

        billType=new JLabel("Bill Type");
        billType.setBounds(50,240,100,20);
        panel.add(billType);

        billTypeChoice=new Choice();
        billTypeChoice.add("Normal");
        billTypeChoice.add("Industrial");
        billTypeChoice.setBounds(180,240,150,20);
        panel.add(billTypeChoice);

        day=new JLabel("30 days of Billing time ...");
        day.setBounds(50,280,150,20);
        panel.add(day);

        note=new JLabel("Note :-");
        note.setFont(new Font("Arial",Font.BOLD,15));
        note.setBounds(50,320,100,20);
        panel.add(note);

        writtingNote=new JLabel("By default bill is calculated for 30 days only");
        writtingNote.setBounds(50,340,300,20);
        panel.add(writtingNote);


        submitButton=new JButton("SUBMIT");
        submitButton.setBounds(220,380,100,25);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.white);
        submitButton.addActionListener(this);
        panel.add(submitButton);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("Icon/details.png"));
        Image image=imageIcon.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel imgLabel=new JLabel(imageIcon1);
        add(imgLabel,"East");

        setSize(700,500);
        setLocation(350,150);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Meter_info("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submitButton){
            String smeterNum=meter_no;
            String smeterLoc=meterLocationChoice.getSelectedItem();
            String smeterType=meterTypeChoice.getSelectedItem();
            String sphase=phaseCodeChoice.getSelectedItem();
            String sbill=billTypeChoice.getSelectedItem();
            String sday="30";


            String query_meterInfo="insert into meter_info values('"+smeterNum+"','"+smeterLoc+"','"+smeterType+"','"+sphase+"','"+sbill+"','"+sday+"')";

            try{
                Database c=new Database();
                c.statement.executeUpdate(query_meterInfo);
                JOptionPane.showMessageDialog(null,"Meter Information submitted successfully");
                setVisible(false);

            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }

    }
}
