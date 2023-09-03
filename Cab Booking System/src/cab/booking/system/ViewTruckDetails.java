package cab.booking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewTruckDetails extends JFrame {
    private  JPanel contentPane;
    Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ViewTruckDetails frame = new ViewTruckDetails("");
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public ViewTruckDetails(String username) {
        setBounds(450,220,1050,600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("cab/booking/System/icons/viewtrucking.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 370,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel la1 = new JLabel(i3);
        la1.setBounds(450,150,550,350);
        add(la1);

        JLabel labelName = new JLabel("VIEW TRUCKING DETAILS");
        labelName.setFont(new Font("Yu Mincho", Font.PLAIN,20));
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

        JLabel l2= new JLabel();
        l2.setBounds(271,110,200,14);
        contentPane.add(l2);

        JLabel lb2 = new JLabel("Source : ");
        lb2.setBounds(35,150,200,14);
        contentPane.add(lb2);

        JLabel l3 = new JLabel();
        l3.setBounds(271,150,200,14);
        contentPane.add(l3);

        JLabel labelName1 = new JLabel("Destination : ");
        labelName1.setBounds(35,190,200,14);
        contentPane.add(labelName1);

        JLabel l4 = new JLabel();
        l4.setBounds(271,190,200,14);
        contentPane.add(l4);

        JLabel labelTruck = new JLabel("Truck : ");
        labelTruck.setBounds(35,230,200,14);
        contentPane.add(labelTruck);

        JLabel l5 = new JLabel();
        l5.setBounds(271,230,200,14);
        contentPane.add(l5);

        JLabel labelW = new JLabel("Weight : ");
        labelW.setBounds(35,270,200,14);
        contentPane.add(labelW);

        JLabel l6 = new JLabel();
        l6.setBounds(271,270,200,14);
        contentPane.add(l6);

        JLabel lRRN = new JLabel("Distance : ");
        lRRN.setBounds(35,310,200,14);
        contentPane.add(lRRN);

        JLabel l7 = new JLabel();
        l7.setBounds(271,310,200,14);
        contentPane.add(l7);

        JLabel labelP = new JLabel("Price : ");
        labelP.setBounds(35,350,200,14);
        contentPane.add(labelP);

        JLabel l8 = new JLabel();
        l8.setBounds(271,350,200,14);
        contentPane.add(l8);

        Conn c = new Conn();
        try {
            ResultSet resultSet = c.s.executeQuery("select * from customer where username = '"+username+"'");
            String name = "";
            while (resultSet.next()){
                l1.setText(resultSet.getString("name"));
                name = resultSet.getString("name");
            }
            resultSet = c.s.executeQuery("select * from intransport where name = '"+name+"'");
            while (resultSet.next()){
                l2.setText(resultSet.getString("dname"));
                l3.setText(resultSet.getString("source"));
                l4.setText(resultSet.getString("destination"));
                l5.setText(resultSet.getString("truck"));
                l6.setText(resultSet.getString("weight"));
                l7.setText(resultSet.getString("distance"));
                l8.setText(resultSet.getString("price"));
            }
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        btnExit.setBounds(120,490,120,30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);

    }


}
