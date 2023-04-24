package bills;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class prevBills {
    JFrame f;
    static int cust_id;
    Statement stmt, stmt2;
    ResultSet r, r1;
    prevBills(int cust_id){
        prevBills.cust_id = cust_id;
    }

    void createTable() throws SQLException {
        f = new JFrame();

        try {
            stmt = DatabaseConnectivity.getDatabase().createStatement();
            stmt2 = DatabaseConnectivity.getDatabase().createStatement();
        }
        catch(Exception e) {
            System.out.print(e);
        }

        try {
            r = stmt.executeQuery("select * from bills where cust = " + cust_id);
            r1 = stmt2.executeQuery("select count(*) from bills where cust = " + cust_id);
        }
//        catch(NullPointerException e) {
//            JOptionPane.showMessageDialog(null, "No transactions yet!", "Message", JOptionPane.INFORMATION_MESSAGE);
//            return;
//        }
        catch(Exception e) {
            System.out.println(e);
        }

        if(!r.next()) {
            JLabel l = new JLabel("No transactions yet.");
            l.setFont(new Font("Times New Roman", Font.BOLD, 18));
            l.setBounds(10, 10, 200, 100);
            f.setSize(800,600);
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            f.setVisible(true);
            f.add(l);
            return;
        }

        r1.next();
        int count = r1.getInt(1);
        System.out.print(count);
        String[][] data = new String[count][];

        System.out.print(r.getInt("quantity"));
        System.out.print(r.getString("items"));
        System.out.print(r.getTimestamp("timestamp"));
        System.out.print(r.getInt("cost"));

        int i = 0;
        try {
            for(; i < count; i++) {
                data[i] = new String[]{r.getString("items"), String.valueOf(r.getInt("quantity")), String.valueOf(r.getInt("cost")), String.valueOf(r.getTimestamp("timestamp"))};
                r.next();
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }

        String column[]={"ITEMS", "QUANTITY", "COST", "TIMESTAMP"};
        JTable jt=new JTable(data, column){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }};
        jt.setBounds(30,40,800,600);
        jt.setFont(new Font("Arial", Font.PLAIN, 16));
        jt.setRowHeight(20);
        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        f.setSize(800,600);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        new prevBills(cust_id).createTable();
    }
}  