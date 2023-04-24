package bills;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// work in progress
public class homePage extends JFrame implements ActionListener {
    JButton signup, login, exit;
    void createFrame() {
        JPanel header = new JPanel();
        header.setBounds(0, 0, 1370, 100);
        header.setBackground(new Color(0, 0, 0, 100));
        JLabel heading = new JLabel("General Store Billing");
        heading.setFont(new Font("Times New Roman", Font.BOLD, 50));
        heading.setForeground(Color.WHITE);
        heading.setBounds(450,25,600,50);
        add(heading);

        Font f = new Font("Times New Roman", Font.BOLD, 30);

        signup = new JButton("Signup");
        signup.setForeground(Color.WHITE);
        signup.setFont(f);
        signup.setBounds(490, 200, 400, 100);
        signup.setBackground(new Color(145, 127, 179));
        add(signup);
        signup.addActionListener(this);

        login = new JButton("Login");
        login.setFont(f);
        login.setForeground(Color.WHITE);
        login.setBounds(490, 350, 400, 100);
        login.setBackground(new Color(145, 127, 179));
        add(login);
        login.addActionListener(this);

        exit = new JButton("Exit");
        exit.setFont(f);
        exit.setForeground(Color.WHITE);
        exit.setBounds(490, 500, 400, 100);
        exit.setBackground(new Color(145, 127, 179));
        add(exit);
        exit.addActionListener(this);

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
        add(background);

        setVisible(true);
    };

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signup) {
            this.dispose();
            new signupPage().signupFrame();
            return;
        }

        if (e.getSource() == login) {
            this.dispose();
            new loginPage().loginFrame();
            return;
        }

        if (e.getSource() == exit) {
            this.dispose();
        }
    }
    public static void main(String args[]) {
        new homePage().createFrame();
    }
}