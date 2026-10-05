package backendforge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet ;

public class UtilisateurRepository {

    public static void ajouterUtilisateur(Utilisateur utilisateur)
            throws SQLException {

        String sql =
            "INSERT INTO utilisateur "
            + "(pseudo, email, mot_de_passe, age, sexe) "
            + "VALUES (?, ?, ?, ?, ?)";

        Connection connexion = ConnexionBDD.getConnection();

        PreparedStatement statement =
                connexion.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS
                );

        statement.setString(1, utilisateur.getPseudo());
        statement.setString(2, utilisateur.getEmail());
        statement.setString(3, utilisateur.getMotDePasseHash());
        statement.setInt(4, utilisateur.getAge());
        statement.setString(5, utilisateur.getSexe());

        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys() ;
        if(generatedKeys.next()) {
            int idGenere = generatedKeys.getInt(1) ;
            utilisateur.setId(idGenere);
        }
        generatedKeys.close();
        statement.close();
        connexion.close();
    }
    
    public static void chercherParEmail(String email) throws SQLException{
        String sql = "SELECT * FROM utilisateur WHERE email = ?" ;
        
        Connection connexion = ConnexionBDD.getConnection();
        PreparedStatement statement = connexion.prepareStatement(sql) ;
        
        statement.setString(1, email);
        
        ResultSet resultat = statement.executeQuery()  ;
        
       
        if(resultat.next()) {
            System.out.println("Utilisateur trouver");
        }
    }
    
    
}