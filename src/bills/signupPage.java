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
    JButton btn, btn1;

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
        btn.setBounds(50, 300, 80, 20);
        c.add(btn);
        btn.addActionListener(this); // to take inputs

        btn1 = new JButton("Clear Form");
        btn1.setBounds(150, 300, 100, 20);
        c.add(btn1);
        btn1.addActionListener(this); // to clear input fields

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o == btn1) {
            clearForm();
            return;
        }

        DatabaseConnectivity obj = new DatabaseConnectivity();
        Statement stmt;
        PreparedStatement pstmt;


        // Form validation for name
        String nameText = name.getText();
        if(nameText.isEmpty()) {
            JOptionPane.showMessageDialog(c, "Please Enter your Name!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!nameText.matches("^[a-zA-Z]*$")) {
            JOptionPane.showMessageDialog(c, "Name can only consist of Alphabets!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(nameText.length() > 50) {
            JOptionPane.showMessageDialog(c, "Name can only be 50 characters long!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Form validation for username
        String userText = user.getText();
        if(userText.isEmpty()) {
            JOptionPane.showMessageDialog(c, "Please Enter your Username!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(userText.length() > 20) {
            JOptionPane.showMessageDialog(c, "Username can only be 20 characters long!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Form validation for password
        char[] passText = pass.getPassword();
        if(passText.length == 0) {
            JOptionPane.showMessageDialog(c, "Please Enter your Password!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(passText.length > 30) {
            JOptionPane.showMessageDialog(c, "Password can only be 30 characters long!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Form validation for email
        String emailText = email.getText();
        if(emailText.isEmpty()) {
            JOptionPane.showMessageDialog(c, "Please Enter your Email!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!emailText.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(c, "Invalid email!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(emailText.length() > 320) {
            JOptionPane.showMessageDialog(c, "Email can be maximum 320 characters long!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Form validation for phone number
        String phoneText = phone.getText();
        if(phoneText.isEmpty()) {
            JOptionPane.showMessageDialog(c, "Please Enter your Phone number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(phoneText.length() != 10) {
            JOptionPane.showMessageDialog(c, "Invalid phone number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // create statement for querying
        try {
            stmt = obj.con.createStatement();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        try {
            // Check if username already exists
            ResultSet rs = stmt.executeQuery("select username from customers");
            while(rs.next()) {
                String username = rs.getString("username");
                if(username.equals(user.toString())) {
                    JOptionPane.showMessageDialog(c, "This username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    clearForm();
                    return;
                }
            }

            // add new signup to database
            String sql = "insert into customers(name, username, password, email, phone) values (?, ?, ?, ?, ?)";
            pstmt = obj.con.prepareStatement(sql);
            pstmt.setString (1, nameText);
            pstmt.setString (2, userText);
            pstmt.setString   (3, Arrays.toString(passText));
            pstmt.setString(4, emailText);
            pstmt.setString    (5, phoneText);
            pstmt.execute();

            JOptionPane.showMessageDialog(c, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
//            homePage redirect = new homePage();
            obj.con.close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(c, "Registration Error!", "Error", JOptionPane.ERROR_MESSAGE);
            clearForm();
            return;
        }
    }
    void clearForm() {
        // clear input fields
        name.setText("");
        user.setText("");
        pass.setText("");
        email.setText("");
        phone.setText("");
    }
}