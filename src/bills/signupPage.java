package bills;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;

public class signupPage {
    public static void main(String args[]) throws SQLException {
        signupGUI frame = new signupGUI();
    }
}

class signupGUI extends JFrame implements ActionListener {
    Container c;
    JLabel label1, label2, label3, label4, label5;
    JTextField name, user, email, phone;
    JPasswordField pass;
    JButton btn;

    signupGUI() {
        setTitle("\t\tSignUp Form");
        setBounds(500,150,700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  //terminate the program when frame is closed
        ImageIcon x = new ImageIcon("logo.jpg");
        setIconImage(x.getImage());

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.CYAN);
        label1 = new JLabel("Name");
        label2 = new JLabel("Username");
        label3 = new JLabel("Password");
        label4 = new JLabel("Email");
        label5 = new JLabel("Phone Number");
        label1.setBounds(10, 50, 100, 50);
        label2.setBounds(10, 100, 100, 50);
        label3.setBounds(10, 150, 100, 50);
        label4.setBounds(10, 200, 100, 50);
        label5.setBounds(10, 250, 100, 50);
        c.add(label1);
        c.add(label2);
        c.add(label3);
        c.add(label4);
        c.add(label5);
        name = new JTextField();
        name.setBounds(120, 50, 120, 20);
        c.add(name);
        user = new JTextField();
        user.setBounds(120, 100, 120, 20);
        c.add(user);
        pass = new JPasswordField();
        pass.setBounds(120, 150, 120, 20);
        c.add(pass);
        email = new JTextField();
        email.setBounds(120, 200, 120, 20);
        c.add(email);
        phone = new JTextField();
        phone.setBounds(120, 250, 120, 20);
        c.add(phone);
        btn = new JButton("Sign Up");
        btn.setBounds(100, 300, 80, 20);
        c.add(btn);
        btn.addActionListener(this); // to show inputs in command prompt

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        DatabaseConnectivity obj = new DatabaseConnectivity();
        Statement stmt;
        PreparedStatement pstmt;

        try {
            String n = name.getText();
            String u = user.getText();
            char[] p = pass.getPassword();
            String em = email.getText();
            String ph = phone.getText();
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(c, "Please Enter valid details!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            stmt = obj.con.createStatement();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        System.out.println("Name: " + name.getText());
        System.out.println("Username: " + user.getText());         //cmd me user details show krne ke liye
        System.out.println("Password: " + Arrays.toString(pass.getPassword()));
        System.out.println("Email: " + email.getText());
        System.out.println("Phone Number: " + phone.getText());

        try {
            String sql = "insert into customers values (?, ?, ?, ?, ?)";
            pstmt = obj.con.prepareStatement(sql);
            pstmt.setString (1, name.getText());
            pstmt.setString (2, user.getText());
            pstmt.setString   (3, Arrays.toString(pass.getPassword()));
            pstmt.setString(4, email.getText());
            pstmt.setString    (5, phone.getText());
            pstmt.execute();

            obj.con.close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(c, "Registration Error!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}