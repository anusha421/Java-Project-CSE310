package bills;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;

//public class signupPage {
//    public static void main(String args[]) throws SQLException {
//        signupGUI frame = new signupGUI();
//    }
//}
//
//class signupGUI extends JFrame implements ActionListener {
//    Container c;
//    JLabel label1, label2, label3, label4, label5;
//    JTextField name, user, email, phone;
//    JPasswordField pass;
//    JButton btn, btn1;
//
//    signupGUI() {
//        setTitle("\t\tSignUp Form");
//        setBounds(500,150,700,500);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);  //terminate the program when frame is closed
//        ImageIcon x = new ImageIcon("logo.jpg");
//        setIconImage(x.getImage());
//
//        c = getContentPane();
//        c.setLayout(null);
//        c.setBackground(Color.CYAN);
//
//        label1 = new JLabel("Name");
//        label2 = new JLabel("Username");
//        label3 = new JLabel("Password");
//        label4 = new JLabel("Email");
//        label5 = new JLabel("Phone Number");
//        label1.setBounds(10, 50, 100, 50);
//        label2.setBounds(10, 100, 100, 50);
//        label3.setBounds(10, 150, 100, 50);
//        label4.setBounds(10, 200, 100, 50);
//        label5.setBounds(10, 250, 100, 50);
//        c.add(label1);
//        c.add(label2);
//        c.add(label3);
//        c.add(label4);
//        c.add(label5);
//
//        name = new JTextField();
//        name.setBounds(120, 50, 120, 20);
//        c.add(name);
//        user = new JTextField();
//        user.setBounds(120, 100, 120, 20);
//        c.add(user);
//        pass = new JPasswordField();
//        pass.setBounds(120, 150, 120, 20);
//        c.add(pass);
//        email = new JTextField();
//        email.setBounds(120, 200, 120, 20);
//        c.add(email);
//        phone = new JTextField();
//        phone.setBounds(120, 250, 120, 20);
//        c.add(phone);
//
//        btn = new JButton("Sign Up");
//        btn.setBounds(50, 300, 80, 20);
//        c.add(btn);
//        btn.addActionListener(this); // to take inputs
//
//        btn1 = new JButton("Clear Form");
//        btn1.setBounds(150, 300, 100, 20);
//        c.add(btn1);
//        btn1.addActionListener(this); // to clear input fields
//
//        setVisible(true);
//    }
//
//
//}
class signupPage extends JFrame implements ActionListener  {
    JLabel label1, label2, label3, label4, label5;
    JTextField Name;
    JTextField username;
    JPasswordField password;
    JTextField email;
    JTextField phone_no;

    signupPage(){
        //header
        JPanel header;
        header=new JPanel();
        header.setBackground(new Color(0,0,0,25));// upper transparency
        header.setBounds(0,0,1370,100);
        JLabel name= new JLabel("Signup");
        name.setBounds(200,50,400,50);

        //font
        Font f= new Font("Algerian ",Font.BOLD, 50);
        name.setForeground(Color.BLACK);
        name.setFont(f);
        header.add(name);

        //Signup
        JPanel signup =new JPanel();
        signup.setLayout(null);
        setSize(1370,730);
        signup.setBounds(370,100,630,600);
        signup.setBackground(new Color(0,0,0,200));


        JLabel n= new JLabel("Name");
        n.setBounds(50,50,400,50);
        //font for labels
        Font F= new Font("Algerian ",Font.BOLD, 35);
        n.setForeground(Color.CYAN);
        n.setFont(F);
        signup.add(n);

        JLabel u= new JLabel("Username");
        u.setBounds(50,150,400,50);
        //font for labels
        Font F2= new Font("Algerian ",Font.BOLD, 35);
        u.setForeground(Color.CYAN);
        u.setFont(F2);
        signup.add(u);

        JLabel p= new JLabel("Password");
        p.setBounds(50,250,400,50);
        //font for labels
        Font F3= new Font("Algerian ",Font.BOLD, 35);
        p.setForeground(Color.CYAN);
        p.setFont(F3);
        signup.add(p);

        JLabel e= new JLabel("Email");
        e.setBounds(50,350,400,50);
        //font for labels
        Font F4= new Font("Algerian ",Font.BOLD, 35);
        e.setForeground(Color.CYAN);
        e.setFont(F4);
        signup.add(e);

        JLabel ph= new JLabel("Phone No.");
        ph.setBounds(50,450,400,50);
        //font for labels
        Font F5= new Font("Algerian ",Font.BOLD, 35);
        ph.setForeground(Color.CYAN);
        ph.setFont(F5);
        signup.add(ph);

        label1 = new JLabel("Enter Name");
        label2 = new JLabel("Enter Username");
        label3 = new JLabel("Enter Password");
        label4 = new JLabel("Enter Email ID");
        label5 = new JLabel("Enter Phone No");
        label1.setBounds(320, 50, 100, 50);
        label2.setBounds(320, 150, 100, 50);
        label3.setBounds(320, 250, 100, 50);
        label4.setBounds(320, 350, 100, 50);
        label5.setBounds(320, 450, 100, 50);
        signup.add(label1);
        signup.add(label2);
        signup.add(label3);
        signup.add(label4);
        signup.add(label5);


        Name=new JTextField();
        Name.setBounds(250,50,300,50);
        Font f1= new Font("Times New Roman",Font.BOLD, 20);
        Name.setForeground(Color.BLACK);
        Name.setFont(f1);
        Name.setBackground(new Color(210,180,140));
        signup.add(Name);

        username=new JTextField();
        username.setBounds(250,150,300,50);
        Font f2= new Font("Times New Roman",Font.BOLD, 20);
        username.setForeground(Color.BLACK);
        username.setFont(f2);
        username.setBackground(new Color(210,180,140));
        signup.add(username);

        password=new JPasswordField();
        password.setBackground(new Color(210,180,140));
        password.setForeground(Color.BLACK);
        password.setBounds(250,250,300,50);
        signup.add(password);

        email=new JTextField();
        email.setBounds(250,350,300,50);
        Font f3= new Font("Times New Roman",Font.BOLD, 20);
        email.setForeground(Color.BLACK);
        email.setFont(f3);
        email.setBackground(new Color(210,180,140));
        signup.add(email);

        phone_no=new JTextField();
        phone_no.setBounds(250,450,300,50);
        Font f4= new Font("Times New Roman",Font.BOLD, 20);
        phone_no.setForeground(Color.BLACK);
        phone_no.setFont(f4);
        phone_no.setBackground(new Color(210,180,140));
        signup.add(phone_no);

        //Button
        JButton signup_btn= new JButton("Signup");
        signup_btn.setBounds(270,530,100,50);
        signup_btn.setBackground(new Color(160,182,45));
        signup.add(signup_btn);
        signup_btn.addActionListener(this); // to show inputs in command prompt




        //frame
        setSize(1370,730);
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
        Object o = e.getSource();
//        if(o == btn1) {
//            clearForm();
//            return;
//        }

        DatabaseConnectivity obj;
        Statement stmt;
        PreparedStatement pstmt;


        // Form validation for name
        String nameText = Name.getText();
        if(nameText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter your Name!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!nameText.matches("^[a-zA-Z]*$")) {
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
                if(username.equals(username.toString())) {
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
//            homePage redirect = new homePage();
            DatabaseConnectivity.getDatabase().close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Registration Error!", "Error", JOptionPane.ERROR_MESSAGE);
            clearForm();
            return;
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





}

class Signup {
    public static void main (String [] args)
    {
        signupPage obj = new signupPage();
    }
}