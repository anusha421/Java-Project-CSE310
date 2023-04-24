package bills;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class userPage extends JFrame implements ActionListener {
    JLabel label1, label2;
    JButton menu_btn, pre_bills, exit;
    JScrollPane scrollPane;
    static ResultSet rs;
    ResultSet r;

    userPage(ResultSet rs) {
        userPage.rs = rs;
    }

    void userFrame() throws SQLException {
        //header
        JPanel header;
        header = new JPanel();
        header.setBackground(new Color(0,0,0,25));// upper transparency
        header.setBounds(0,0,1370,100);
        JLabel name = new JLabel("User Information");
        name.setBounds(200,50,400,50);

        //font
        Font f = new Font("Times New Roman", Font.BOLD, 50);
        name.setForeground(Color.WHITE);
        name.setFont(f);
        header.add(name);

        JPanel profile = new JPanel();
        profile.setLayout(null);
        setSize(1370,730);
        profile.setBounds(370,125,630,500);
        profile.setBackground(new Color(0,0,0,100));

        try {
            label1 = new JLabel("Welcome, " + rs.getString("name"));
        }
        catch(SQLException e) {
            this.dispose();
            System.out.print(e);
            JOptionPane.showMessageDialog(this, "Error! Try again later", "Error", JOptionPane.ERROR_MESSAGE);
            new homePage().createFrame();
        }

        Font f1= new Font("Times New Roman",Font.BOLD, 20);

        try {
            label1 = new JLabel("Welcome, " + rs.getString("name"));
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        label1.setBounds(10, 10, 300, 40);
        label1.setForeground(Color.white);
        label1.setFont(f1);
        profile.add(label1);

        Statement stmt;

        try {
            stmt = DatabaseConnectivity.getDatabase().createStatement();
        }
        catch (Exception ex) {
            new homePage().createFrame();
            throw new RuntimeException(ex);
        }

        try {
            r = stmt.executeQuery("select timestamp from bills where cust = " + rs.getInt("cust_id") + " ORDER BY timestamp desc limit 1");
            if(!r.next()) {
                label2 = new JLabel("You haven't made any transacctions yet");
            }
            else {
                label2 = new JLabel("Your last transaction was on " + r.getTimestamp(1));
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error!", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            throw new RuntimeException(ex);
        }

        label2.setBounds(10, 50, 600, 30);
        label2.setForeground(Color.white);
        label2.setFont(f1);
        profile.add(label2);

        pre_bills = new JButton("View Previous Bills");
        pre_bills.setFont(f1);
        pre_bills.setBounds(150,200,300,50);
        pre_bills.setBackground(new Color(186, 144, 198));
        profile.add(pre_bills);
        pre_bills.addActionListener(this);

        menu_btn = new JButton("Go to Shop");
        menu_btn.setFont(f1);
        menu_btn.setBounds(150,450,200,35);
        menu_btn.setBackground(new Color(186, 144, 198));
        profile.add(menu_btn);
        menu_btn.addActionListener(this);

        exit = new JButton("Exit");
        exit.setFont(f1);
        exit.setBounds(390,450,100,35);
        exit.setBackground(new Color(186, 144, 198));
        profile.add(exit);
        exit.addActionListener(this);

        //frame
        setSize(1370,730);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); // fix the size

        //background
        ImageIcon bg_image=new ImageIcon("src/images/bg.png");

        Image img=bg_image.getImage();
        Image temp_img=img.getScaledInstance(1370,730,Image.SCALE_SMOOTH);
        bg_image= new ImageIcon(temp_img);
        JLabel background =new JLabel("",bg_image,JLabel.CENTER);

        background.setBounds(0,0,1370,730);
        background.add(header);
        background.add(profile);
        add(background);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu_btn) {
            try {
                this.dispose();
                new ShoppingCart().main(Integer.toString(rs.getInt("cust_id")));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error! Try again later", "Error", JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException(ex);
            }
            return;
        }

        if (e.getSource() == pre_bills) {
            try {
                new prevBills(rs.getInt("cust_id")).createTable();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            return;
        }

        if (e.getSource() == exit) {
            this.dispose();
            return;
        }
    }

    public static void main (String [] args)
    {
        try {
            if (userPage.rs == null) {
                throw new Exception();
            }
            new userPage(rs).userFrame();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Login to continue!", "Error", JOptionPane.ERROR_MESSAGE);
            new loginPage().loginFrame();
        }
    }
}