

package backendforge;
import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.SQLException ;

/**
 *
 * @author julien
 */
public class ConnexionBDD {
private static final String URL = "jdbc:mysql://localhost:3306/forge";
private static final String USER = "root" ; 
private static final String PASSWORD = "" ;


public static Connection getConnection() throws SQLException{ 
    
    return DriverManager.getConnection( URL,USER,PASSWORD);
}

}