package cab.booking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateCustomer extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;

    private  JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                  UpdateCustomer frame = new UpdateCustomer("");
                  frame.setVisible(true);
                } catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
    }
    public UpdateCustomer(String username) throws  Exception {
        System.out.println(username);
        setBounds(500,220,850,550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("cab/booking/system/icons/update.png"));
        Image i1 = c1.getImage().getScaledInstance(200, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500,40,200,400);
        add(l1);

        JLabel labelName = new JLabel("UPDATE CUSTOMER DETAILS");
        labelName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        labelName.setBounds(118,11,300,53);
        contentPane.add(labelName);

        JLabel l3 = new JLabel("Username : ");
        l3.setBounds(35,70,200,14);
        contentPane.add(l3);

        t1 = new JTextField();
        t1.setBounds(271,70,150,20);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel labelID = new JLabel("ID : ");
        labelID.setBounds(35,110,200,14);
        contentPane.add(labelID);

        t2 =  new JTextField();
        t2.setBounds(271,110,150,20);
        contentPane.add(t2);
        t2.setColumns(10);

        JLabel l2= new JLabel("Number  : ");
        l2.setBounds(35,150,200,14);
        contentPane.add(l2);

        t3 =  new JTextField();
        t3.setBounds(271,150,150,20);
        contentPane.add(t3);
        t3.setColumns(10);

        JLabel labelname1 = new JLabel("Name : ");
        labelname1.setBounds(35,190,200,14);
        contentPane.add(labelname1);

        t4 =  new JTextField();
        t4.setBounds(271,190,150,20);
        contentPane.add(t4);
        t4.setColumns(10);

        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setBounds(35,230,200,14);
        contentPane.add(labelGender);

        t5 =  new JTextField();
        t5.setBounds(271,230,150,20);
        contentPane.add(t5);
        t5.setColumns(10);

        JLabel labelCountry= new JLabel("Country : ");
        labelCountry.setBounds(35,270,200,14);
        contentPane.add(labelCountry);

        t6 =  new JTextField();
        t6.setBounds(271,270,150,20);
        contentPane.add(t6);
        t6.setColumns(10);

        JLabel lableRRN = new JLabel("Permanent Address : ");
        lableRRN.setBounds(35,310,200,14);
        contentPane.add(lableRRN);

        t7 =  new JTextField();
        t7.setBounds(271,310,150,20);
        contentPane.add(t7);
        t7.setColumns(10);

        JLabel lableCheck = new JLabel("Phone : ");
        lableRRN.setBounds(35,350,200,14);
        contentPane.add(lableRRN);

        t8 =  new JTextField();
        t8.setBounds(271,350,150,20);
        contentPane.add(t8);
        t8.setColumns(10);

        JLabel lableEmail= new JLabel("Email : ");
        lableEmail.setBounds(35,390,200,14);
        contentPane.add(lableEmail);

        t9 =  new JTextField();
        t9.setBounds(271,390,150,20);
        contentPane.add(t9);
        t9.setColumns(10);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.s.executeQuery("select * from customer where username = '"+username+"' ");
            if (resultSet.next()){
                t1.setText(resultSet.getString(1));
                t2.setText(resultSet.getString(2));
                t3.setText(resultSet.getString(3));
                t4.setText(resultSet.getString(4));
                t5.setText(resultSet.getString(5));
                t6.setText(resultSet.getString(6));
                t7.setText(resultSet.getString(7));
                t8.setText(resultSet.getString(8));
                t9.setText(resultSet.getString(9));
            }
        }catch (Exception E){}

        JButton btnNewButton = new JButton("UPdate");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();

                try {
                    String  s1 = t1.getText();
                    String  s2 = t2.getText();
                    String  s3 = t3.getText();
                    String  s4 = t4.getText();
                    String  s5 = t5.getText();
                    String  s6 = t6.getText();
                    String  s7 = t7.getText();
                    String  s8 = t8.getText();
                    String  s9 = t9.getText();

                    String  q1 = "update customer set id_type = '"+s2+"', number = '"+s3+"', name = '"+s4+"', gender = '"+s5+"',country = '"+s6+"', address = '"+s7+"',phone = '"+s8+"', email  = '"+s9+"' where username =  '"+s1+"'";
                    c.s.executeUpdate(q1);

                    JOptionPane.showMessageDialog(null, "Customer Detail Update Successfully");
                    setVisible(false);

                }catch (SQLException E1){
                    System.out.println(E1.getMessage());
                } catch (NumberFormatException s){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
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
