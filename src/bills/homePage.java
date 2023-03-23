package bills;
import javax.swing.*;
import java.awt.*;

public class homePage {
    public static void main(String args[]) {
        GUI frame = new GUI();
    }
}

class GUI extends JFrame {
    public GUI() {
        JLabel heading = new JLabel("General Store Billing");
        JButton signup = new JButton("Signup");
        JButton login = new JButton("Login");
        add(heading);
        add(signup);
        add(login);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(700, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}