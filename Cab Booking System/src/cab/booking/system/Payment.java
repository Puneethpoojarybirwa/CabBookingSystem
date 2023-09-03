package cab.booking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame {

    public Payment() {
       setLayout(null);
       setBounds(600,220,800,600);

       JLabel label = new JLabel("Pay the Payment");
       label.setFont(new Font("Raleway", Font.BOLD, 40));
       label.setBounds(50,20,350,45);
       add(label);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("cab/booking/System/icons/paytm.jpeg"));
        Image i1 = c1.getImage().getScaledInstance(800, 600,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);

        JLabel l4 = new JLabel(i2);
        l4.setBounds(0,150,800,600);
        add(l4);

        JButton pay = new JButton("Pay");
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Paid Successfully");
            }
        });

        pay.setBounds(420,20,80,40);
        add(pay);

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        back.setBounds(510,20,80,40);
        add(back);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    public static void main(String[] args) {
new Payment().setVisible(true);
    }

}
