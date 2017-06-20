package alcotizz.jlopes.com.alcotizz;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jérome on 14/06/2017.
 */

public class Joueur {

    private String nom ;



    public Joueur(String pnom){
        this.nom = pnom;
    }

    public Joueur Tirer1Joueur(ArrayList<Joueur> joueurs){
        Random randGen = new Random();
        return joueurs.get(randGen.nextInt(joueurs.size()-1));
    }




    public String getNom(){
        return this.nom;
    }
}
