package alcotizz.jlopes.com.alcotizz;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jérome on 14/06/2017.
 */


public class Equipe {
    private String nom;
    private ArrayList<Joueur> joueurs;

            public Equipe(){
                nom = "";
                this.joueurs = new ArrayList<Joueur>();
            }

            public Equipe(String pnom){
                this.nom = pnom;
            }

            public String getNom(String nom){
                return this.nom;
            }

            public void ajouterPersonne(Joueur pnom){
                System.out.println("Ajout d'une personne dans l'equipe" + pnom);
                this.joueurs.add(pnom);
            }

            public  void supprimerJoueur(Joueur pnom){
                 this.joueurs.remove(pnom);
            }

            public Joueur TirerJoueur(){
                Random randGen = new Random();
                return this.joueurs.get(randGen.nextInt(this.joueurs.size()-1));
            }
}
