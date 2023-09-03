package cab.booking.system;

import javax.swing.*;
import java.sql.ResultSet;
import  java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class CheckBill extends JFrame {
    public static void main(String[] args) {
        new CheckBill("").setVisible(true);
    }
    public CheckBill(String username) {
        setBounds(550, 220, 900, 600);
        setVisible(true);
        String price1 = "0";
        String price2 = "0";
        String price3 = "0";

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.s.executeQuery("select from intercab where username = '" + username + "' ");
            while (resultSet.next()) {
                price1 = resultSet.getString("price");
            }
            resultSet = c.s.executeQuery("select * from intracab where username = '" + username + "'");
            while (resultSet.next()) {
                price2 = resultSet.getString("price");
            }
            String name = "";
            resultSet = c.s.executeQuery("select * from customer where username = '" + username + "'");
            while (resultSet.next()) {
                name = resultSet.getString("name");
            }
            resultSet = c.s.executeQuery("select * from intrasnport where name = '" + username + "'");
            while (resultSet.next()) {
                price3 = resultSet.getString("price");
            }
        } catch (Exception E) {

        }
        String[] package1 = new String[]{"package1.png", "INTERCITY CAB BILL", price1};
        String[] package2 = new String[]{"package2.jpg", "INTRACITY CAB BILL", price2};
        String[] package3 = new String[]{"package3.jpg", "TRANSPORT CAB BILL", price3};

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tabbedPane.addTab("Intercity Cab", null, p1);

        JPanel p2 = createPackage(package2);
        tabbedPane.addTab("Intracity Cab", null, p2);

        JPanel p3 = createPackage(package3);
        tabbedPane.addTab("Transport", null, p3);

        add(tabbedPane, BorderLayout.CENTER);
    }



    public JPanel createPackage(String[] pack) {
            JPanel p1 = new JPanel();
            p1.setLayout(null);
            p1.setBackground(Color.WHITE);

            ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("cab/booking/System/icons/"+pack[0]));
            Image i3 = i1.getImage().getScaledInstance(550, 300,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel l1 = new JLabel(i2);
            l1.setBounds(300,50,550,300);
            p1.add(l1);

            JLabel labelName = new JLabel(pack[1]);
            labelName.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
            labelName.setBounds(10,5,350,53);
            p1.add(labelName);

            JLabel l3 = new JLabel("Transpo Cab");
            l3.setFont(new Font("Yu Mincho", Font.PLAIN, 25));
            l3.setForeground(Color.RED);
            l3.setBounds(35,80,200,30);
            p1.add(l3);

            JLabel labelID = new JLabel("TOTAL BILL");
            labelID.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
            labelID.setForeground(Color.RED);
            labelID.setBounds(35,160,200,25);
            p1.add(labelID);

            JLabel l2 = new JLabel(pack[2]);
            l2.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
            l2.setBounds(35,200,200,25);
            p1.add(l2);

            JLabel la1 = new JLabel("Today we aspire to make transportation as reliable as running water, everywhere and for everyone");
            la1.setFont(new Font("Yu Mincho", Font.PLAIN, 18));
            la1.setBounds(50,460,1000,30);
            p1.add(la1);

            return p1;

        }
    }



