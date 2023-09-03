package cab.booking.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewCustomer extends JFrame {
    Connection conn = null;
    private  JPanel contentPane;
    private JTable table;
    private  JLabel labelAvailability;
    private  JLabel labelCleanStatus;
    private JLabel labelNewLable;
    private  JLabel labelNewLable1;
    private  JLabel labelRoomNumber;
    private  JLabel labelID;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ViewCustomer frame = new ViewCustomer();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public ViewCustomer()throws SQLException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,220,900,680);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("cab/booking/System/icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(626, 201,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,450,626,201);
        add(l1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("cab/booking/System/icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(626, 201,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(615,450,626,201);
        add(l2);

        table = new JTable();
        table.setBounds(0,40,900,350);
        contentPane.add(table);

        try {
           Conn c = new Conn();
           String dispayCustomersql = "select * from customer";
            ResultSet resultSet = c.s.executeQuery(dispayCustomersql);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e1){
            e1.printStackTrace();
        }

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        btnNewButton.setBounds(390,400,120,30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        labelAvailability = new JLabel("Username");
        labelAvailability.setBounds(10,15,69,14);
        contentPane.add(labelAvailability);

        labelCleanStatus = new JLabel("ID Type");
        labelCleanStatus.setBounds(110,15,76,14);
        contentPane.add(labelCleanStatus);

        labelNewLable = new JLabel("Number");
        labelNewLable.setBounds(220,15,46,14);
        contentPane.add(labelNewLable);

        labelNewLable1 = new JLabel("Name");
        labelNewLable1.setBounds(320,15,76,14);
        contentPane.add(labelNewLable1);

        labelID= new JLabel("Gender");
        labelID.setBounds(420,15,90,14);
        contentPane.add(labelID);

        JLabel l3 = new JLabel("Country");
        l3.setBounds(520,15,90,14);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Address");
        l4.setBounds(620,15,90,14);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Phone");
        l5.setBounds(720,15,90,14);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Email");
        l6.setBounds(820,15,90,14);
        contentPane.add(l6);

        getContentPane().setBackground(Color.WHITE);
    }
}
