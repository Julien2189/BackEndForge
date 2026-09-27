
package backendforge;
import java.sql.Connection ;
import java.sql.PreparedStatement;
import java.sql.SQLException ;
/**
 *
 * @author julien
 */
public class UtilisateurRepository {
    public static void ajouterUtilisateur(Utilisateur utilisateur)throws SQLException {
    String sql =
    "INSERT INTO utilisateur (pseudo, email, mot_de_passe, age, sexe) VALUES (?, ?, ?, ?, ?)";
    
    Connection connexion = ConnexionBDD.getConnection();
    
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1,utilisateur.getPseudo());
        statement.setString(2,utilisateur.getEmail());
        statement.setInt(4,utilisateur.getAge() );
        statement.setString(5, utilisateur.getSexe());
    }
}
