
package backendforge;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * @author julien
 */
public class BackEndForge {

  
    public static void main(String[] args) throws SQLException  {
        
        try {
            Connection connexion = ConnexionBDD.getConnection();   
            System.out.println("Connexion reussi");
        }
        catch(SQLException e) {
             System.out.println(e.getMessage());
        }
       Utilisateur utilisateur1 = new Utilisateur(
        "jul",
        "jul@live.fr",
        "123456",
        "123456",
        41,
        "H"
);
try {
    UtilisateurRepository.ajouterUtilisateur(utilisateur1);

    System.out.println("Utilisateur enregistré");

} catch (SQLException e) {
    System.out.println(e.getMessage());
}
       System.out.println(utilisateur1.getId()) ;
       System.out.println(utilisateur1.getPseudo()) ;
           System.out.println(utilisateur1.getEmail()) ;
       System.out.println(utilisateur1.getAge()) ;
       System.out.println(utilisateur1.getSexe()) ;

       UtilisateurRepository.chercherParEmail("jul@live.fr");

    }
    
}
