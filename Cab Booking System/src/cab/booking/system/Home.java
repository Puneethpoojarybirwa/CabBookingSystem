package cab.booking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    String username;
    public static void main(String[] args) {
        new Home("").setVisible(true);
    }

    public  Home(String username){
        super("Cab Booking System");
        this.username = username;
        setForeground(Color.CYAN);
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("cab/booking/System/icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel newLable = new JLabel(i3);
        newLable.setBounds(0,0,1950,1000);
        add(newLable);

        JLabel l1 = new JLabel("Transpo Cab");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma", Font.PLAIN,55));
        l1.setBounds(780,60,1000,100);
        newLable.add(l1);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu m1 = new JMenu("CUSTOMER");
        m1.setForeground(Color.BLUE);
        menuBar.add(m1);

        JMenuItem mi1 = new JMenuItem("ADD CUSTOMER");
        m1.add(mi1);

        JMenuItem mi2 = new JMenuItem("UPDATE CUSTOMER DETAIL");
        m1.add(mi2);

        JMenuItem mi3 = new JMenuItem("VIEW CUSTOMER DETAILS");
        m1.add(mi3);

        JMenuItem mi4 = new JMenuItem("DELETE CUSTOMER DETAILS");
        m1.add(mi4);

        mi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new AddCustomer(username).setVisible(true);
                }catch (Exception E){

                }
            }
        });

        mi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateCustomer(username).setVisible(true);

                } catch (Exception E) {
                }
            }
        });

        mi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ViewCustomer().setVisible(true);

                } catch (Exception E) {
                }
            }
        });

        mi4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new DeleteCustomer().setVisible(true);

                } catch (Exception E) {
                }
            }
        });

        JMenu m2 = new JMenu("BOOK INTRACITY CAB");
        m2.setForeground(Color.RED);
        menuBar.add(m2);

        JMenuItem mi5 = new JMenuItem("BOOK CAB");
        m2.add(mi5);

        JMenuItem mi6 = new JMenuItem("VIEW BOOKED CAB");
        m2.add(mi6);

        mi5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new BookCab(username).setVisible(true);

                } catch (Exception E) {
                }
            }
        });

        mi6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ViewBookedCab(username).setVisible(true);

                } catch (Exception E) {
                }
            }
        });

        JMenu m3 = new JMenu("BOOK INTERCITY CAB");
        m3.setForeground(Color.BLUE);
        menuBar.add(m3);

        JMenuItem mi7 = new JMenuItem("VIEW CABS");
        m3.add(mi7);

        JMenuItem mi8 = new JMenuItem("BOOK CAB");
        m3.add(mi8);

        JMenuItem mi9 = new JMenuItem("VIEW BOOKED CABS");
        m3.add(mi9);

        mi7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ViewCabs().setVisible(true);

                } catch (Exception E) {
                }
            }
        });

        mi8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new BookIntercityCab(username).setVisible(true);

                } catch (Exception E) {
                }
            }
        });

        mi9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ViewInterCityBookedCab(username).setVisible(true);

                } catch (Exception E) {
                }
            }
        });

        JMenu m4 = new JMenu("TRANSPORT");
        m4.setForeground(Color.RED);
        menuBar.add(m4);

        JMenuItem mi10 = new JMenuItem("BOOKED PACKAGE");
        m4.add(mi10);

        JMenuItem mi11 = new JMenuItem("VIEW BOOKED PACKAGE");
        m4.add(mi11);

        mi10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Trucking(username).setVisible(true);
                }catch (Exception E){}
            }
        });

        mi11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ViewTruckDetails(username).setVisible(true);
                }catch (Exception E){}
            }
        });

        JMenu m5 = new JMenu("BILL");
        m5.setForeground(Color.BLUE);
        menuBar.add(m5);

        JMenuItem mi12 = new JMenuItem("CHECK BILL");
        m5.add(mi12);

        mi12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CheckBill(username).setVisible(true);
                }catch (Exception E){}
            }
        });

        JMenu m6 = new JMenu("PAYMENT");
        m6.setForeground(Color.RED);
        menuBar.add(m6);

        JMenuItem mi13 = new JMenuItem("PAY THE PAYTM");
        m6.add(mi13);

        mi13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Payment().setVisible(true);
                }catch (Exception E){}
            }
        });

        JMenu m7 = new JMenu("UTILITY");
        m7.setForeground(Color.BLUE);
        menuBar.add(m7);

        JMenuItem mi14 = new JMenuItem("NOTEPAD");
        m7.add(mi14);

        JMenuItem mi15 = new JMenuItem("CALCULATOR");
        m7.add(mi15);

        mi14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   Runtime.getRuntime().exec("notepad.exe");
                }catch (Exception E){}
            }
        });

        mi15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Runtime.getRuntime().exec("calc.exe");
                }catch (Exception E){}
            }
        });

        JMenu m8 = new JMenu("ABOUT");
        m8.setForeground(Color.RED);
        menuBar.add(m8);

        JMenuItem mi16 = new JMenuItem("ABOUT");
        m8.add(mi16);

        mi16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new About().setVisible(true);
                }catch (Exception E){}
            }
        });

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

    }
}
