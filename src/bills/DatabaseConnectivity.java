package bills;
import java.sql.*;

public class DatabaseConnectivity {
    public Connection con;
    DatabaseConnectivity() {
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/billing","root","sharma00");
                Statement stmt = con.createStatement();
        }catch(Exception e){ System.out.println(e);}
    }
}
