package alcotizz.jlopes.com.alcotizz;

/**
 * Created by Jérome on 14/06/2017.
 */

public class Gage extends Question {

    private int timer;
    private String texte2;
    private String fin ;

    public Gage() {
        super();
        timer = 0;
        texte2 = "";
        fin="";
    }

    public Gage(int timer,String Ptexte) {
        super(Ptexte);
        this.timer = 0;
        this.texte2 = Ptexte;
        fin="";

    }

    public void TireJoueur(Joueur joueur1, Joueur joueur2){

        if(texte.contains("<joueur1>")){
             texte = texte.replace("<joueur1>", joueur1.getNom());
            if(texte.contains("<joueur2>")){
                texte = texte.replace("<joueur2>", joueur2.getNom());
            }
        }
        if(this.texte2.contains("<joueur1>")){
            this.texte2 = this.texte2.replace("<joueur1>", joueur1.getNom());
            if(this.texte2.contains("<joueur2>")){
                this.texte2 = this.texte2.replace("<joueur2>", joueur2.getNom());
            }
        }


    }
}
