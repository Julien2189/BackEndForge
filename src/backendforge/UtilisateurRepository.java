package backendforge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilisateurRepository {

    public static void ajouterUtilisateur(Utilisateur utilisateur)
            throws SQLException {

        String sql =
            "INSERT INTO utilisateur "
            + "(pseudo, email, mot_de_passe, age, sexe) "
            + "VALUES (?, ?, ?, ?, ?)";

        Connection connexion = ConnexionBDD.getConnection();

        PreparedStatement statement =
                connexion.prepareStatement(sql);

        statement.setString(1, utilisateur.getPseudo());
        statement.setString(2, utilisateur.getEmail());
        statement.setString(3, utilisateur.getMotDePasseHash());
        statement.setInt(4, utilisateur.getAge());
        statement.setString(5, utilisateur.getSexe());

        statement.executeUpdate();

        statement.close();
        connexion.close();
    }
}