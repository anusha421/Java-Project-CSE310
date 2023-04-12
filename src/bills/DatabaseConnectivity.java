package bills;
import java.sql.*;

public class DatabaseConnectivity {
    private static Connection con;
    private DatabaseConnectivity() {}
    public static Connection getDatabase() {
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/billing","root","sharma00");
                Statement stmt = con.createStatement();
        }
        catch(Exception e) {
            System.out.println(e);
        }

        return con;
    }
}
