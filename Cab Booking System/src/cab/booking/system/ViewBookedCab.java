package cab.booking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.RunnableScheduledFuture;

public class ViewBookedCab extends  JFrame {
    private JPanel contentPane;
    Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ViewBookedCab frame = new ViewBookedCab("");
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
    public ViewBookedCab(String username) {
        setBounds(450,220,1050,600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("cab/booking/System/icons/intracabdetails.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 450,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450,150,550,350);
        add(la1);

        JLabel labelName = new JLabel("VIEW BOOKED CAB DETAILS");
        labelName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        labelName.setBounds(88,1,350,53);
        contentPane.add(labelName);

        JLabel lb3 = new JLabel("Customer Name : ");
        lb3.setBounds(35,70,200,14);
        contentPane.add(lb3);

        JLabel l1 = new JLabel();
        l1.setBounds(271,70,200,14);
        contentPane.add(l1);

        JLabel labelID = new JLabel("Driver Name : ");
        labelID.setBounds(35,110,200,14);
        contentPane.add(labelID);

        JLabel l2 = new JLabel();
        l2.setBounds(271,110,200,14);
        contentPane.add(l2);

        JLabel lb2 = new JLabel("Source : ");
        lb2.setBounds(35,150,200,14);
        contentPane.add(lb2);

        JLabel l3 = new JLabel();
        l3.setBounds(271,150,200,14);
        contentPane.add(l3);

        JLabel lname1 = new JLabel("Destination : ");
        lname1.setBounds(35,190,200,14);
        contentPane.add(lname1);

        JLabel l4 = new JLabel();
        l4.setBounds(271,190,200,14);
        contentPane.add(l4);

        JLabel lt = new JLabel("Car : ");
        lt.setBounds(35,230,200,14);
        contentPane.add(lt);

        JLabel l5 = new JLabel();
        l5.setBounds(271,230,200,14);
        contentPane.add(l5);

        JLabel lID = new JLabel("ID: ");
        lID.setBounds(35,270,200,14);
        contentPane.add(lID);

        JLabel l6 = new JLabel();
        l6.setBounds(271,270,200,14);
        contentPane.add(l6);

        JLabel lPhone = new JLabel("Phone : ");
        lPhone.setBounds(35,310,200,14);
        contentPane.add(lPhone);

        JLabel l7 = new JLabel();
        l7.setBounds(271,310,200,14);
        contentPane.add(l7);

        JLabel lAddress = new JLabel("Address : ");
        lAddress.setBounds(35,350,200,14);
        contentPane.add(lAddress);

        JLabel l8 = new JLabel();
        l8.setBounds(271,350,200,14);
        contentPane.add(l8);

        JLabel lPrice = new JLabel("Price: ");
        lPrice.setBounds(35,390,200,14);
        contentPane.add(lPrice);

        JLabel l9 = new JLabel();
        l9.setBounds(271,390,200,14);
        contentPane.add(l9);

        JLabel la2 = new JLabel("Arriving-In : ");
        la2.setBounds(35,430,200,14);
        contentPane.add(la2);

        JLabel l10 = new JLabel();
        l10.setBounds(271,430,200,14);
        contentPane.add(l10);

        JLabel la3= new JLabel("Reference Number : ");
        la3.setBounds(35,470,200,14);
        contentPane.add(la3);

        JLabel l11 = new JLabel();
        l11.setBounds(271,470,200,14);
        contentPane.add(l11);

        Conn c = new Conn();
        try {
            ResultSet resultSet = c.s.executeQuery("select * from intraCab where username = '"+username+"'");
            while (resultSet.next()){
                l2.setText(resultSet.getString(2));
                l3.setText(resultSet.getString(3));
                l4.setText(resultSet.getString(4));
                l5.setText(resultSet.getString(5));
                l9.setText(resultSet.getString(6));
                l11.setText(resultSet.getString(7));
            }

            resultSet = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while (resultSet.next()){
                l1.setText(resultSet.getString("name"));
                l6.setText(resultSet.getString("Id_type")+ "("+resultSet.getString("number")+")");
                l7.setText(resultSet.getString("phone"));
                l8.setText(resultSet.getString("address"));
            }

            Random r = new Random();
            l10.setText(Math.abs((r.nextInt() % 10)) + " mins");

            resultSet.close();
        }catch (SQLException e){
        }

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        btnExit.setBounds(120,510,120,30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);


    }



}
