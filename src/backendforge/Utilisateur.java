
package backendforge;
    
/**
 *
 * @author julien
 */
public class Utilisateur {
   private  int id ; 
   private String pseudo ; 
   private String email ; 
  private String motDePasse ; 
  private int age ; 
  private String sexe ; 
  
  public Utilisateur(String pseudo , String email , String motDePasse , String confirmationDePasse , int age , String sexe ) {
      if(pseudo.isBlank() || email.isBlank()) {
          throw new IllegalArgumentException("non valide") ;
      }
      if(!email.contains("@")){
           throw new IllegalArgumentException("adresse mail non valide") ;
      }
       if(motDePasse.length() <6){
            throw new IllegalArgumentException("mot de passe inferieur a 6 caractere");
        }
        if (!motDePasse.equals(confirmationDePasse)) {         
        throw new IllegalArgumentException("mot de passe ne correspond pas ");
      }
       if(age <=  0){
         throw new IllegalArgumentException("l'age doit etre supperieur a 0");
       }
       if (!sexe.equalsIgnoreCase("homme")
        && !sexe.equalsIgnoreCase("h")
        && !sexe.equalsIgnoreCase("femme")
        && !sexe.equalsIgnoreCase("f")){
           throw new IllegalArgumentException("genre non valide ");
       }
      this.pseudo = pseudo ;
      this.email = email; 
      this.motDePasse = motDePasse; 
     
      this.age = age ; 
      this.sexe = sexe ;
      
      
  }
  public String getPseudo(){
          return pseudo ;
      }
   public String getEmail(){
          return email ;
      }
    public int getAge(){
          return age ;
      }
     public String getSexe(){
          return sexe ;
      }
     public int getId(){
         return id ;
     }
  
}
