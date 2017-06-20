package alcotizz.jlopes.com.alcotizz;

import java.util.Random;

/**
 * Created by Jérome on 14/06/2017.
 */

public class Question {

    public void setTexte(String texte) {
        this.texte = texte;
    }

    protected String texte;

    public Question(){
        this.texte = "";
    }

    //Constructeur avec parametre


    // Methode qui regarde si la ligne du texte contient "joueur1" et le remplace par le nom du joueur
    public void TireJoueur(Joueur joueur1, Joueur joueur2){
        if (this.texte.contains("<joueur1>")){
            this.texte = this.texte.replace("<joueur1>", joueur1.getNom());
            if(this.texte.contains("<joueur2>")){
                this.texte = this.texte.replace("<joueur2>", joueur2.getNom());
            }
        }
    }


    public Question(String Ptexte){
        this.texte = Ptexte;
    }

    public String getTexte(){
        return this.texte ;
    }
}

