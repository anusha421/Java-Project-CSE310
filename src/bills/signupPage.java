package bills;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;

class signupPage extends JFrame implements ActionListener  {
    JLabel label1, label2, label3, label4, label5;
    JTextField Name, username, email, phone_no;
    JPasswordField password;
    JButton signup_btn, clear_btn, login_btn;

    void signupFrame(){
        //header
        JPanel header;
        header=new JPanel();
        header.setBackground(new Color(0,0,0,25));// upper transparency
        header.setBounds(0,0,1370,100);
        JLabel name= new JLabel("Signup");
        name.setBounds(200,50,400,50);

        //font
        Font f = new Font("Times New Roman", Font.BOLD, 50);
        name.setForeground(Color.WHITE);
        name.setFont(f);
        header.add(name);

        //Signup
        JPanel signup =new JPanel();
        signup.setLayout(null);
        setSize(1370,730);
        signup.setBounds(370,125,630,500);
        signup.setBackground(new Color(0,0,0,100));


        JLabel n= new JLabel("Name");
        n.setBounds(50,50,400,25);
        //font for labels
        Font F= new Font("Algerian",Font.BOLD, 25);
        n.setForeground(Color.CYAN);
        n.setFont(F);
        signup.add(n);

        JLabel u= new JLabel("Username");
        u.setBounds(50,100,400,25);
        //font for labels
        Font F2= new Font("Algerian",Font.BOLD, 25);
        u.setForeground(Color.CYAN);
        u.setFont(F2);
        signup.add(u);

        JLabel p= new JLabel("Password");
        p.setBounds(50,150,400,25);
        //font for labels
        Font F3= new Font("Algerian",Font.BOLD, 25);
        p.setForeground(Color.CYAN);
        p.setFont(F3);
        signup.add(p);

        JLabel e= new JLabel("Email");
        e.setBounds(50,200,400,25);
        //font for labels
        Font F4= new Font("Algerian",Font.BOLD, 25);
        e.setForeground(Color.CYAN);
        e.setFont(F4);
        signup.add(e);

        JLabel ph= new JLabel("Phone No.");
        ph.setBounds(50,250,400,25);
        //font for labels
        Font F5= new Font("Algerian",Font.BOLD, 25);
        ph.setForeground(Color.CYAN);
        ph.setFont(F5);
        signup.add(ph);

        label1 = new JLabel("Enter Name");
        label2 = new JLabel("Enter Username");
        label3 = new JLabel("Enter Password");
        label4 = new JLabel("Enter Email ID");
        label5 = new JLabel("Enter Phone No");
        label1.setBounds(320, 50, 100, 25);
        label2.setBounds(320, 100, 100, 25);
        label3.setBounds(320, 150, 100, 25);
        label4.setBounds(320, 200, 100, 25);
        label5.setBounds(320, 250, 100, 25);
        signup.add(label1);
        signup.add(label2);
        signup.add(label3);
        signup.add(label4);
        signup.add(label5);

        Font f1= new Font("Times New Roman",Font.BOLD, 20);

        Name=new JTextField();
        Name.setBounds(250,50,300,25);
        Name.setForeground(Color.BLACK);
        Name.setFont(f1);
        Name.setBackground(new Color(210,180,140));
        signup.add(Name);

        username=new JTextField();
        username.setBounds(250,100,300,25);
        username.setForeground(Color.BLACK);
        username.setFont(f1);
        username.setBackground(new Color(210,180,140));
        signup.add(username);

        password=new JPasswordField();
        password.setBackground(new Color(210,180,140));
        password.setForeground(Color.BLACK);
        password.setBounds(250,150,300,25);
        signup.add(password);

        email=new JTextField();
        email.setBounds(250,200,300,25);
        email.setForeground(Color.BLACK);
        email.setFont(f1);
        email.setBackground(new Color(210,180,140));
        signup.add(email);

        phone_no=new JTextField();
        phone_no.setBounds(250,250,300,25);
        phone_no.setForeground(Color.BLACK);
        phone_no.setFont(f1);
        phone_no.setBackground(new Color(210,180,140));
        signup.add(phone_no);

        //Button
        signup_btn= new JButton("Signup");
        signup_btn.setFont(f1);
        signup_btn.setBounds(270,300,100,35);
        signup_btn.setBackground(new Color(186, 144, 198));
        signup.add(signup_btn);
        signup_btn.addActionListener(this);

        clear_btn= new JButton("Clear Form");
        clear_btn.setFont(f1);
        clear_btn.setBounds(245,350,150,35);
        clear_btn.setBackground(new Color(186, 144, 198));
        signup.add(clear_btn);
        clear_btn.addActionListener(this);

        JLabel log = new JLabel("Already Registered? Login here.");
        log.setFont(f1);
        log.setForeground(Color.WHITE);
        log.setBounds(190, 410, 300, 25);
        signup.add(log);

        login_btn = new JButton("Login");
        login_btn.setFont(f1);
        login_btn.setBounds(270,450,100,35);
        login_btn.setBackground(new Color(186, 144, 198));
        signup.add(login_btn);
        login_btn.addActionListener(this);


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
        background.add(signup);
        add(background);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear_btn) {
            clearForm();
            return;
        }

        if(e.getSource() == login_btn) {
            this.dispose();
            new loginPage().loginFrame();
            return;
        }

        Statement stmt;
        PreparedStatement pstmt, pstmt2;


        // Form validation for name
        String nameText = Name.getText();
        if(nameText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter your Name!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!nameText.matches("^[a-zA-Z ]*$")) {
            JOptionPane.showMessageDialog(this, "Name can only consist of Alphabets!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(nameText.length() > 50) {
            JOptionPane.showMessageDialog(this, "Name can only be 50 characters long!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Form validation for username
        String userText = username.getText();
        if(userText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter your Username!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(userText.length() > 20) {
            JOptionPane.showMessageDialog(this, "Username can only be 20 characters long!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Form validation for password
        char[] passText = password.getPassword();
        if(passText.length == 0) {
            JOptionPane.showMessageDialog(this, "Please Enter your Password!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(passText.length > 30) {
            JOptionPane.showMessageDialog(this, "Password can only be 30 characters long!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Form validation for email
        String emailText = email.getText();
        if(emailText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter your Email!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!emailText.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(this, "Invalid email!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(emailText.length() > 320) {
            JOptionPane.showMessageDialog(this, "Email can be maximum 320 characters long!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Form validation for phone number
        String phoneText = phone_no.getText();
        if(phoneText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter your Phone number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(phoneText.length() != 10) {
            JOptionPane.showMessageDialog(this, "Invalid phone number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // create statement for querying
        try {
            stmt = DatabaseConnectivity.getDatabase().createStatement();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        try {
            // Check if username already exists
            ResultSet rs = stmt.executeQuery("select username from customers");
            while(rs.next()) {
                String username = rs.getString("username");
                if(username.equals(userText)) {
                    JOptionPane.showMessageDialog(this, "This username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    clearForm();
                    return;
                }
            }

            // add new signup to database
            String sql = "insert into customers(name, username, password, email, phone) values (?, ?, ?, ?, ?)";
            pstmt = DatabaseConnectivity.getDatabase().prepareStatement(sql);
            pstmt.setString (1, nameText);
            pstmt.setString (2, userText);
            pstmt.setString   (3, Arrays.toString(passText));
            pstmt.setString(4, emailText);
            pstmt.setString    (5, phoneText);
            pstmt.execute();

            JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
            setVisible(false);
            DatabaseConnectivity.getDatabase().close();
        }
        catch (Exception ex) {
            System.out.print(ex);
            JOptionPane.showMessageDialog(this, "Registration Error!", "Error", JOptionPane.ERROR_MESSAGE);
            clearForm();
            return;
        }

        try {
            String sql2 = ("select * from customers where username = ?");
            pstmt2 = DatabaseConnectivity.getDatabase().prepareStatement(sql2);
            pstmt2.setString(1, userText);
            ResultSet rs2 = pstmt2.executeQuery();
            rs2.next();
            new userPage(rs2).userFrame();
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
    void clearForm() {
        // clear input fields
        Name.setText("");
        username.setText("");
        password.setText("");
        email.setText("");
        phone_no.setText("");
    }

    public static void main (String [] args)
    {
        new signupPage().signupFrame();
    }
}