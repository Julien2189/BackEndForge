package backendforge;

import org.mindrot.jbcrypt.BCrypt;

public class Utilisateur {

    private int id;
    private String pseudo;
    private String email;
    private String motDePasseHash;
    private int age;
    private String sexe;
   
    public Utilisateur(
            String pseudo,
            String email,
            String motDePasse,
            String confirmationDePasse,
            int age,
            String sexe) {

        if (pseudo.isBlank() || email.isBlank()) {
            throw new IllegalArgumentException("Pseudo ou email non valide");
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Adresse mail non valide");
        }

        if (motDePasse.length() < 6) {
            throw new IllegalArgumentException(
                    "Mot de passe inférieur à 6 caractères"
            );
        }

        if (!motDePasse.equals(confirmationDePasse)) {
            throw new IllegalArgumentException(
                    "Les mots de passe ne correspondent pas"
            );
        }

        if (age <= 0) {
            throw new IllegalArgumentException(
                    "L'âge doit être supérieur à 0"
            );
        }

        if (!sexe.equalsIgnoreCase("homme")
                && !sexe.equalsIgnoreCase("h")
                && !sexe.equalsIgnoreCase("femme")
                && !sexe.equalsIgnoreCase("f")) {

            throw new IllegalArgumentException("Genre non valide");
        }

        this.pseudo = pseudo;
        this.email = email;

        this.motDePasseHash =
                BCrypt.hashpw(motDePasse, BCrypt.gensalt());

        this.age = age;
        this.sexe = sexe;
     
    }

    public int getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasseHash() {
        return motDePasseHash;
    }

    public int getAge() {
        return age;
    }

    public String getSexe() {
        return sexe;
    }
    
}