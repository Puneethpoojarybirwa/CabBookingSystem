package cab.booking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCustomer extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;

    private  JPanel contentPane;

    private  JTextField t1,t2,t3,t4,t5,t6,t7,t8;

    JComboBox comboBox;
    JRadioButton r1,r2;

    Choice c1;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    AddCustomer frame = new AddCustomer("");
                    frame.setVisible(true);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
    }

    public  AddCustomer(String username)throws SQLException {
        System.out.println(username);
        setBounds(500,220,850,550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("cab/booking/System/icons/newcustomer.jpg"));
        Image i3 = i1.getImage().getScaledInstance(450, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);

        JLabel l1 = new JLabel(i2);
        l1.setBounds(450,40,450,420);
        add(l1);

        JLabel labelName = new JLabel("NEW CUSTOMER FORM");
        labelName.setFont(new Font("Yu Mincho", Font.PLAIN,20));
        labelName.setBounds(118,11,260,53);
        contentPane.add(labelName);

        JLabel l3 = new JLabel("Username :");
        l3.setBounds(35,70,200,14);
        contentPane.add(l3);

        t7 = new JTextField();
        t7.setBounds(271,70,150,20);
        contentPane.add(t7);
        t7.setColumns(10);

        JLabel lbuild = new JLabel("ID :");
        lbuild.setBounds(35,110,200,14);
        contentPane.add(lbuild);

        comboBox = new JComboBox(new String[]{"Passport", "Aadhar Card", "Voter ID", "Driving licence"});
        comboBox.setBounds(271,110,150,20);
        contentPane.add(comboBox);

        JLabel l2 = new JLabel("Number :");
        l2.setBounds(35,150,200,14);
        contentPane.add(l2);

        t1 = new JTextField();
        t1.setBounds(271,150,150,20);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel labelName1 = new JLabel("Name :");
        labelName1.setBounds(35,190,200,14);
        contentPane.add(labelName1);

        t2 = new JTextField();
        t2.setBounds(271,190,150,20);
        contentPane.add(t2);
        t2.setColumns(10);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35,230,200,14);
        contentPane.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD,14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(271,230,80,12);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD,14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,230,100,12);
        add(r2);

        JLabel labelCountry = new JLabel("Country :");
        labelCountry.setBounds(35,270,200,14);
        contentPane.add(labelCountry);

        t3 = new JTextField();
        t3.setBounds(271,270,150,20);
        contentPane.add(t3);
        t3.setColumns(10);

        JLabel labelRRN = new JLabel("Permanent Address :");
        labelRRN.setBounds(35,310,200,14);
        contentPane.add(labelRRN);

        t5 = new JTextField();
        t5.setBounds(271,310,150,20);
        contentPane.add(t5);
        t5.setColumns(10);

        JLabel labelCI = new JLabel("Phone :");
        labelCI.setBounds(35,350,200,14);
        contentPane.add(labelCI);

        t6 = new JTextField();
        t6.setBounds(271,350,150,20);
        contentPane.add(t6);
        t6.setColumns(10);

        JLabel labelEm = new JLabel("Email :");
        labelEm.setBounds(35,390,200,14);
        contentPane.add(labelEm);

        t8 = new JTextField();
        t8.setBounds(271,390,150,20);
        contentPane.add(t8);
        t8.setColumns(10);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.s.executeQuery("select * from account where username = '"+username+"'");
            while (resultSet.next()){
                t7.setText(resultSet.getString("username"));
                t2.setText(resultSet.getString("name"));
            }
        }catch (Exception e){}


        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                String radio = null;

                if(r1.isSelected()){
                    radio = "Male";
                } else if (r2.isSelected()) {
                    radio = "Female";
                }

                try {
                    String s9 = t7.getText();
                    String s1 = (String) comboBox.getSelectedItem();
                    String s2 = t1.getText();
                    String s3 = t2.getText();
                    String s4 = radio;
                    String s5 = t3.getText();
                    String s7 = t5.getText();
                    String s8 = t6.getText();
                    String s10 = t8.getText();
                    String q1 = "insert into customer values('"+s9+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s7+"','"+s8+"','"+s10+"')";
                    c.s.executeUpdate(q1);

                    JOptionPane.showMessageDialog(null,"Customer added Successfully" );
                    setVisible(false);

                }catch (SQLException e1){
                    System.out.println(e1.getMessage());
                } catch (NumberFormatException s){
                    JOptionPane.showMessageDialog(null,"Please enter a valid Number" );

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
