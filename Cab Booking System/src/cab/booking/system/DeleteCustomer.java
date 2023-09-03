package cab.booking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteCustomer extends JFrame {
    private  JPanel contentPane;

    Choice c1;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    DeleteCustomer frame = new DeleteCustomer();
                    frame.setVisible(true);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
    }
    public DeleteCustomer() throws SQLException{

        setBounds(500,220,850,550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("cab/booking/System/icons/delete.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500,100,300,300);
        add(l1);

        JLabel labelName = new JLabel("DELETE CUSTOMERS DETAILS");
        labelName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        labelName.setBounds(118,11,300,53);
        contentPane.add(labelName);

        JLabel lb3 = new JLabel("UserName : ");
        lb3.setBounds(35,70,200,14);
        contentPane.add(lb3);

        c1 = new Choice();
        Conn c = new Conn();
        try {
            ResultSet resultSet = c.s.executeQuery("select * from account");
            while (resultSet.next()){
                c1.add(resultSet.getString("username"));
            }
            resultSet.close();
        }catch (SQLException E){}

        c1.setBounds(271,70,150,30);
        add(c1);

        JLabel labelID = new JLabel("ID : ");
        labelID.setBounds(35,110,200,14);
        contentPane.add(labelID);

        JLabel l2 = new JLabel();
        l2.setBounds(271,110,200,14);
        contentPane.add(l2);

        JLabel lb2 = new JLabel("Number : ");
        lb2.setBounds(35,150,200,144);
        contentPane.add(lb2);

        JLabel l3 = new JLabel();
        l3.setBounds(271,150,200,14);
        contentPane.add(l3);

        JLabel labelName1 = new JLabel("Name : ");
        labelName1.setBounds(35,190,200,14);
        contentPane.add(labelName1);

        JLabel l4 = new JLabel();
        l4.setBounds(271,190,200,14);
        contentPane.add(l4);

        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setBounds(35,230,200,14);
        contentPane.add(labelGender);

        JLabel l5 = new JLabel();
        l5.setBounds(271,230,200,14);
        contentPane.add(l5);

        JLabel labelCountry = new JLabel("Country : ");
        labelCountry.setBounds(35,270,200,14);
        contentPane.add(labelCountry);

        JLabel l6 = new JLabel();
        l6.setBounds(271, 270, 200, 14);
        contentPane.add(l6);

        JLabel labelRSN = new JLabel("Permanent Address : ");
        labelRSN.setBounds(35,310,200,14);
        contentPane.add(labelRSN);

        JLabel l7 = new JLabel();
        l7.setBounds(271, 310, 200, 14);
        contentPane.add(l7);

        JLabel labelCS = new JLabel("Phone : ");
        labelCS .setBounds(35, 350, 200, 14);
        contentPane.add(labelCS);

        JLabel l8 = new JLabel();
        l8.setBounds(271, 350,200,14);
        contentPane.add(l8);

        JLabel labelDeposite = new JLabel("Email : ");
        labelDeposite.setBounds(35, 390, 200, 14);
        contentPane.add(labelDeposite);

        JLabel l9 = new JLabel();
        l9.setBounds(271, 390,200,14);
        contentPane.add(l9);

        JButton b1 = new JButton("Check");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();

                try {
                    ResultSet resultSet = c.s.executeQuery("select * from customer where username = '"+c1.getSelectedItem()+"'");
                    if (resultSet.next()){
                        l2.setText(resultSet.getString(2));
                        l3.setText(resultSet.getString(3));
                        l4.setText(resultSet.getString(4));
                        l5.setText(resultSet.getString(5));
                        l6.setText(resultSet.getString(6));
                        l7.setText(resultSet.getString(7));
                        l8.setText(resultSet.getString(8));
                        l9.setText(resultSet.getString(9));
                    }
                }catch (Exception ee){}
            }
        });

        b1.setBounds(425, 70, 80, 22);
        lb2.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        JButton btnNewButton = new JButton("Delete");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();

                try {
                    String s1 = c1.getSelectedItem();

                    String q1 = "delete from customer where username = '"+s1+"'";
                    String q2 = "delete from account where username = '"+s1+"'";
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);

                    JOptionPane.showMessageDialog(null, "Customer Detail Deleted Successfully");
                    setVisible(false);
                    new Home("").setVisible(false);
                    new Login().setVisible(true);
                }catch ( SQLException e1 ){
                    System.out.println(e1.getMessage());
                }catch ( NumberFormatException s){
                    JOptionPane.showMessageDialog(null,"Pleasze enter a valid Number" );
                }
            }
        });

        btnNewButton.setBounds(100,430,120,30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        btnExit.setBounds(260,430,120,30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);

    }
}
