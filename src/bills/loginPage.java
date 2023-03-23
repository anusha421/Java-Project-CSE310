package bills;

import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

class MyFrame extends JFrame implements ActionListener {

    Container c;
    JLabel label1,label2;
    JTextField user;
    JPasswordField pass;
    JButton btn, btn1;
    MyFrame(){
        setTitle("\t\tLogin Form");
        setBounds(500,150,700,500);          //location left and top , then size
        setDefaultCloseOperation(EXIT_ON_CLOSE);  //terminate the program when frame is closed
        ImageIcon x = new ImageIcon("logo.jpg");
        setIconImage(x.getImage());
        setResizable(false);              //fix the size

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.CYAN);
        label1 = new JLabel("Username");
        label2 = new JLabel("Password");
        label1.setBounds(10,50,100,50);
        label2.setBounds(10,100,100,50);
        c.add(label1);
        c.add(label2);

        user = new JTextField();
        user.setBounds(120,50,120,20);
        c.add(user);
        pass = new JPasswordField();
        pass.setBounds(120,100,120,20);
        c.add(pass);

        btn = new JButton("Login");
        btn.setBounds(50,150,70,20);
        c.add(btn);
        btn.addActionListener(this); // to take inputs

        btn1 = new JButton("Clear Form");
        btn1.setBounds(150,150,100,20);
        c.add(btn1);
        btn1.addActionListener(this); // to clear field inputs

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();
        if(o == btn1) {
            clearForm();
            return;
        }

        DatabaseConnectivity obj = new DatabaseConnectivity();
        Statement stmt;

        // Form validation for username
        String userText = user.getText();
        if(userText.isEmpty()) {
            JOptionPane.showMessageDialog(c, "Please Enter your Username!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Form validation for password
        char[] passText = pass.getPassword();
        if(passText.length == 0) {
            JOptionPane.showMessageDialog(c, "Please Enter your Password!", "Error", JOptionPane.ERROR_MESSAGE);
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
            int flag = 0;
            ResultSet rs = stmt.executeQuery("select username, password from customers");
            while(rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                if(username.equals(userText) && password.equals(Arrays.toString(passText))) {
                    JOptionPane.showMessageDialog(c, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    flag = 1;
                    clearForm();
                    break;
                }
            }

            if(flag == 0) {
                JOptionPane.showMessageDialog(c, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
//            homePage redirect = new homePage();
            obj.con.close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(c, "Login Error!", "Error", JOptionPane.ERROR_MESSAGE);
            clearForm();
            return;
        }
    }

    void clearForm() {
        // clear input fields
        user.setText("");
        pass.setText("");
    }
}

class LoginForm {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }
}