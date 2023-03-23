package bills;

import javax.swing.* ;
import java.awt.*;    //container import krne ke liye
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener {

    Container c;
    JLabel label1,label2;
    JTextField user;
    JPasswordField pass;
    JButton btn;
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
        btn.setBounds(100,150,70,20);
        c.add(btn);
        btn.addActionListener(this); // to show user name and password in command prompt

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        System.out.println("Username: "+user.getText());         //cmd me user details show krne ke liye
        System.out.println("Password: "+pass.getPassword());
    }
}

class LoginForm {
    public static void main(String []args){
        MyFrame frame = new MyFrame();
    }
}