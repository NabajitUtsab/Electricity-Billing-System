package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentBill extends JFrame implements ActionListener {
    JButton backButton;
    String meterNoPass;
    PaymentBill(String meterNoPass){

        super("Payment");
        this.meterNoPass=meterNoPass;
        setBounds(270,80,800,600);


        JEditorPane jEditorPane = new JEditorPane();
        jEditorPane.setEditable(false);

        try{

            jEditorPane.setPage("https://paytm.com/online-payments");
            jEditorPane.setBounds(270,80,800,600);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            jEditorPane.setContentType("text/html");
            jEditorPane.setText("<html> Error !  Error !  Error !  Error ! </html>");
        }



        JScrollPane jScrollPane=new JScrollPane(jEditorPane);
        add(jScrollPane);

        backButton = new JButton("Back");
        backButton.setBounds(640,20,80,30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        jEditorPane.add(backButton);



        setVisible(true);
    }

    public static void main(String[] args) {
        new PaymentBill("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==backButton){
            new PayBill(meterNoPass);
            setVisible(false);
        }

    }
}
