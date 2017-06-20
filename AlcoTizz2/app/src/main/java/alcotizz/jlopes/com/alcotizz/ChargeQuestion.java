package alcotizz.jlopes.com.alcotizz;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jérome on 16/06/2017.
 */

public class ChargeQuestion {



    public static Joueur[] TirerDeuxJoueur(ArrayList<Joueur> joueurs){

        Random randGen = new Random();
        Joueur[] result = new Joueur[2];

        result[0] = joueurs.get(randGen.nextInt(joueurs.size()-1));
        result[1]  = joueurs.get(randGen.nextInt(joueurs.size()-1));



        while (result[0] == result[1]){
            result[1] = joueurs.get(randGen.nextInt(joueurs.size()-1));
        }


        return result;
    }

}
