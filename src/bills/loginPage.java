package bills;

import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

class loginPage extends JFrame implements ActionListener {
    JLabel background;
    JPanel login,header;
    JTextField username;
    JPasswordField password;
    JButton signup;
    JButton login_btn;

    loginPage()
    {
        //header
        JPanel header;
        header = new JPanel();
        header.setBackground(new Color(0,0,0,25));// upper transparency
        header.setBounds(0,0,1370,100);
        JLabel name = new JLabel("Login");
        name.setBounds(200,50,400,50);
        //font
        Font f = new Font("Algerian",Font.BOLD, 50);
        name.setForeground(Color.BLACK);
        name.setFont(f);
        header.add(name);

        //login
        JPanel login = new JPanel();
        login.setLayout(null);
        setSize(400,350);
        login.setBounds(480,200,400,350);
        login.setBackground(Color.BLACK);


        username = new JTextField();
        username.setBounds(50,50,300,50);

        Font f1 = new Font("Times New Roman", Font.BOLD, 20);
        username.setForeground(Color.BLACK);
        username.setFont(f1);
        username.setBackground(new Color(210,180,140));
        login.add(username);

        password = new JPasswordField();
        password.setBackground(new Color(210,180,140));
        password.setForeground(Color.BLACK);
        password.setBounds(50,150,300,50);
        login.add(password);

        JButton signup= new JButton("Login");
        signup.setBounds(30,250,100,50);
        signup.setBackground(new Color(160,182,45));
        login.add(signup);
        signup.addActionListener(this);

        JButton login_btn = new JButton("Sign Up");
        login_btn.setBounds(270,250,100,50);
        login_btn.setBackground(new Color(160,182,45));
        login.add(login_btn);
        login_btn.addActionListener(this);



        //frame
        setSize(1370,730);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); // fix the size

        //background
        ImageIcon bg_image = new ImageIcon("src/images/bg.png");

        Image img = bg_image.getImage();
        Image temp_img = img.getScaledInstance(1370,730,Image.SCALE_SMOOTH);
        bg_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("",bg_image,JLabel.CENTER);

        background.add(login);
        background.add(header);
        background.setBounds(0,0,1370,730);
        add(background);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();
//        if(o == btn1) {
//            clearForm();
//            return;
//        }

        DatabaseConnectivity obj = new DatabaseConnectivity();
        Statement stmt;

        // Form validation for username
        String userText = username.getText();
        if(userText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter your Username!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Form validation for password
        char[] passText = password.getPassword();
        if(passText.length == 0) {
            JOptionPane.showMessageDialog(this, "Please Enter your Password!", "Error", JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    flag = 1;
                    clearForm();
                    break;
                }
            }

            if(flag == 0) {
                JOptionPane.showMessageDialog(this, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
//            homePage redirect = new homePage();
            obj.con.close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Login Error!", "Error", JOptionPane.ERROR_MESSAGE);
            clearForm();
            return;
        }
    }

    void clearForm() {
        // clear input fields
        username.setText("");
        password.setText("");
    }

}

class LoginForm{
    public static void main(String[]args)
    {
        loginPage obj = new loginPage();
    }
}