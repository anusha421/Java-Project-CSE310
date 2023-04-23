package bills;
import java.sql.*;

public class DatabaseConnectivity {
    private static DatabaseConnectivity db = null;
    private static Connection con;
    private DatabaseConnectivity() {}
    public static Connection getDatabase() {
        if(db == null) {
            db = new DatabaseConnectivity();
        }

        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/billing","root","sharma00");
        }
        catch(Exception e) {
            System.out.println(e);
        }

        return con;
    }
}
