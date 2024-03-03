package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class CalculateBills extends JFrame {
    CalculateBills(){
        super("Calculate Bills");

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(241,195,247));
        add(panel);

        setSize(650,400);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CalculateBills();
    }
}
