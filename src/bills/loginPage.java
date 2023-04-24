package bills;

import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

class loginPage extends JFrame implements ActionListener {
    JLabel background;
    JPanel login, header;
    JTextField username;
    JPasswordField password;
    JButton signup, login_btn, clear_btn;

    void loginFrame()
    {
        //header
        header = new JPanel();
        header.setBackground(new Color(0,0,0,25));// upper transparency
        header.setBounds(0,0,1370,100);
        JLabel name = new JLabel("Login");
        name.setBounds(200,50,400,50);
        //font
        Font f = new Font("Times New Roman", Font.BOLD, 50);
        name.setForeground(Color.WHITE);
        name.setFont(f);
        header.add(name);

        //login
        login = new JPanel();
        login.setLayout(null);
        login.setBounds(400,200,600,450);
        login.setBackground(new Color(0,0,0,100));

        Font F2= new Font("Algerian",Font.BOLD, 20);

        JLabel u = new JLabel("Username");
        u.setBounds(50,60,400,25);
        u.setForeground(Color.CYAN);
        u.setFont(F2);
        login.add(u);

        JLabel p = new JLabel("Password");
        p.setBounds(50,160,400,25);
        p.setForeground(Color.CYAN);
        p.setFont(F2);
        login.add(p);

        Font f1 = new Font("Times New Roman", Font.BOLD, 20);
        username = new JTextField();
        username.setBounds(200,55,300,40);
        username.setForeground(Color.BLACK);
        username.setFont(f1);
        username.setBackground(new Color(210,180,140));
        login.add(username);

        password = new JPasswordField();
        password.setBackground(new Color(210,180,140));
        password.setForeground(Color.BLACK);
        password.setBounds(200,155,300,40);
        login.add(password);

        login_btn = new JButton("Login");
        login_btn.setFont(f1);
        login_btn.setBounds(120,250,150,50);
        login_btn.setBackground(new Color(186, 144, 198));
        login.add(login_btn);
        login_btn.addActionListener(this);


        clear_btn = new JButton("Clear Form");
        clear_btn.setFont(f1);
        clear_btn.setBounds(340,250,150,50);
        clear_btn.setBackground(new Color(186, 144, 198));
        login.add(clear_btn);
        clear_btn.addActionListener(this);


        JLabel sign = new JLabel("Don't have an Account? Register Here.");
        sign.setFont(f1);
        sign.setForeground(Color.white);
        sign.setBounds(140, 350, 600, 25);
        login.add(sign);

        signup = new JButton("Sign Up");
        signup.setFont(f1);
        signup.setBounds(240,380,120,50);
        signup.setBackground(new Color(186, 144, 198));
        login.add(signup);
        signup.addActionListener(this);

        //frame
        setSize(1370,730);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); // fix the size

        //background
        ImageIcon bg_image = new ImageIcon("src/images/bg.png");

        Image img = bg_image.getImage();
        Image temp_img = img.getScaledInstance(1370,730,Image.SCALE_SMOOTH);
        bg_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", bg_image, JLabel.CENTER);

        background.add(login);
        background.add(header);
        background.setBounds(0,0,1370,730);
        add(background);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == signup) {
            this.dispose();
            new signupPage().signupFrame();
            return;
        }

        if(e.getSource() == clear_btn) {
            clearForm();
            return;
        }

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
            stmt = DatabaseConnectivity.getDatabase().createStatement();
        }
        catch (Exception ex) {
            new homePage().createFrame();
            throw new RuntimeException(ex);
        }

        try {
            // Check if username already exists
            int flag = 0;
            ResultSet rs = stmt.executeQuery("select * from customers");
            while(rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                if(username.equals(userText) && password.equals(Arrays.toString(passText))) {
                    JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new userPage(rs).userFrame();
                    flag = 1;
                    clearForm();
                    break;
                }
            }

            if(flag == 0) {
                JOptionPane.showMessageDialog(this, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            DatabaseConnectivity.getDatabase().close();
        }
        catch (Exception ex) {
            System.out.print(ex);
            JOptionPane.showMessageDialog(this, "Login Error!", "Error", JOptionPane.ERROR_MESSAGE);
            clearForm();
            this.dispose();
        }
    }

    void clearForm() {
        // clear input fields
        username.setText("");
        password.setText("");
    }

    public static void main(String[]args) {
        new loginPage().loginFrame();
    }
}