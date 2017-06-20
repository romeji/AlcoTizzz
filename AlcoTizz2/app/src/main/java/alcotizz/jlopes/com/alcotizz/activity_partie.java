package alcotizz.jlopes.com.alcotizz;

import android.app.Activity;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class activity_partie extends Activity {

    String ListeJoueurs;
    public ArrayList<Joueur> TabJoueur ;
    ArrayList<Question> Questiondefis = new ArrayList<Question>();
    ArrayList<Question> QuestionGage = new ArrayList<Question>();
    ArrayList<Question> QuestionCulSec = new ArrayList<Question>();

    ArrayList<String> FinQuestionGage = new ArrayList<>();

    private String defis = "Defis.txt";
    private String culsec = "Culsec.txt";
    private String gages = "Gages.txt";



    private Button button_next;

    private int numQuestionGage = 0;
    private int numQuestionCulSec = 0;
    private int numQuestionDefis = 0;
    private int numQuestionFinGage = 0;

    private Random randquest = new Random();

    int timerFinGage = 0;
    int timerGlobal = 0;
    int timerGage = 0;
    int GageEncours = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie);

        final TextView TextQuestion = (TextView) findViewById(R.id.textQuestion);
        final ConstraintLayout Layoutpartie = (ConstraintLayout) findViewById(R.id.LayoutPartie);

        ListeJoueurs = (String) getIntent().getStringExtra("ListeJoueurs");


        TabJoueur = SlipJoueur();

        ChargeQuestions();

        ChargeQuestionDefis();
        ChargeQuestionGage();
        ChargeQuestionCulSec();


        button_next = (Button) findViewById(R.id.bt_next);
        button_next.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                        Random Nombre = new Random();
                        int NumAléatoire = Nombre.nextInt(14);
                        System.out.println("----------> Random " + NumAléatoire);
                        System.out.println("----------> TimerGage " + timerGage);

                        if(NumAléatoire > 2){
                            Layoutpartie.setBackgroundColor(Color.parseColor("#FF135581"));
                            Question QuestionDefis = TireDefis(numQuestionDefis);
                            TextQuestion.setText(QuestionDefis.getTexte());
                            numQuestionDefis +=1;

                            if(timerGage > 0){ timerGage +=1;}

                            if(timerGage >= 5){
                                Layoutpartie.setBackgroundColor(Color.parseColor("#FF8B50AF"));

                                System.out.println("----------->" + timerGage);
                                TextQuestion.setText(FinQuestionGage.get(numQuestionFinGage));
                                numQuestionFinGage += 1;

                                timerGage = 0; // pour passer au gage d'après

                                if(GageEncours >= 1){GageEncours -= 1;}
                                if(GageEncours != 0){ timerGage +=1;}
                            }
                        }

                        if(NumAléatoire == 2){
                            Layoutpartie.setBackgroundColor(Color.parseColor("#FF8B50AF"));
                            Question QuestionGage = TireGage(numQuestionGage);
                            TextQuestion.setText(QuestionGage.getTexte());
                            numQuestionGage +=1;

                            timerGage +=1;
                            GageEncours += 1;

                            if(timerGage > 0){ timerGage +=1;}

                            if(timerGage >= 5){
                                System.out.println("----------->" + timerGage);
                                TextQuestion.setText(FinQuestionGage.get(numQuestionFinGage));
                                timerGage = 0;
                                numQuestionFinGage+=1;

                                if(GageEncours >= 1){GageEncours -= 1;}
                                if(GageEncours != 0){timerGage +=1;}

                            }
                        }
                        if(NumAléatoire < 2){
                            Layoutpartie.setBackgroundColor(Color.parseColor("#FFCB0B00"));
                            if(numQuestionCulSec != QuestionCulSec.size()){
                                Question QuestionCulSec = TireCulsec(numQuestionCulSec);
                                TextQuestion.setText(QuestionCulSec.getTexte());
                                numQuestionCulSec +=1;
                            }

                        }

                    }
                }
        );

    }



    public ArrayList<Joueur> SlipJoueur() {
        ArrayList<Joueur> result = new ArrayList<Joueur>() ;
        String JoueurText = "";

        String values[] = ListeJoueurs.split("%");
        for (int i = 0; i < values.length; i++) {
            Joueur joueur = new Joueur(values[i]);
            result.add(joueur);
        }

        final TextView Joueurs = (TextView) findViewById(R.id.Players);
        for(int i =0; i<result.size(); i++){
            JoueurText +=  result.get(i).getNom() + " \n";
        }
        Joueurs.setText(JoueurText);

        return result;
    }


    public void ChargeQuestions() {

        try {
            InputStream File = getAssets().open(defis);
            InputStreamReader reader = new InputStreamReader(File);
            BufferedReader br = new BufferedReader(reader);
            String ligne = "";


            while ((ligne = br.readLine()) != null) {
                Question temp = new Question(ligne);
                Joueur[] Lejoueurs = new Joueur[2];
                Lejoueurs = ChargeQuestion.TirerDeuxJoueur(TabJoueur);
                temp.TireJoueur(Lejoueurs[0], Lejoueurs[1]);
                Questiondefis.add(temp);

            }
            br.close();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }

      try {
            InputStream File = getAssets().open(gages);
            InputStreamReader reader = new InputStreamReader(File);
            BufferedReader br = new BufferedReader(reader);
            String ligne = "";

            while((ligne=br.readLine())!=null){
                Gage temp = new Gage(5,ligne);
                Joueur[] Lejoueurs = ChargeQuestion.TirerDeuxJoueur(TabJoueur);
                temp.TireJoueur(Lejoueurs[0], Lejoueurs[1]);
                System.out.println("------------------ICI->" +  temp);
                QuestionGage.add(temp);

            }
            br.close();
        }
        catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("----------------LA---->");
        }

        try {
            InputStream File = getAssets().open(culsec);
            InputStreamReader reader = new InputStreamReader(File);
            BufferedReader br = new BufferedReader(reader);
            String ligne = "";
            while((ligne=br.readLine())!= null){
                Question temp = new Question(ligne);
                Joueur[] Lejoueurs = new Joueur[2];
                Lejoueurs = ChargeQuestion.TirerDeuxJoueur(TabJoueur);
                temp.TireJoueur(Lejoueurs[0], Lejoueurs[1]);
                QuestionCulSec.add(temp);
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }


            /*
                * pour toute les questions du tableau
                * On creer un nombre aleatoire compris entre ledebut du tableau et la fin
                * On choisie la question de l'arraylist qui a le numero aleatoire et on l'affecte a notre question temporaire
                * on la modifie dans le l'arraylist avec la question qui a été choisie
                * et on la re modifier avec le nombre aleatoire et la text
             */


    public void ChargeQuestionDefis() {
        try {
            Random randomGen = new Random();
            for(int i = 0 ; i< Questiondefis.size(); i++){
                int randNombre = randomGen.nextInt(Questiondefis.size() -1) +i;
                Question temp = Questiondefis.get(i); //stock la question  i dans temp
                Questiondefis.set(i,Questiondefis.get(randNombre)); // modifier la question i avec la question tiré aleatoirement
                Questiondefis.set(randNombre,temp); // Me la question i a la place de la question randNombre

            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }



    public void ChargeQuestionCulSec(){
        try{


            Random randGem = new Random();
            for(int i = 0; i<QuestionCulSec.size(); i++){
                int randNombre = randGem.nextInt(QuestionCulSec.size() -i) +i;
                Question temp = QuestionCulSec.get(i);
                QuestionCulSec.set(i,QuestionCulSec.get(randNombre));
                QuestionCulSec.set(randNombre,temp);
            }
        }
        catch (Exception e ){
            System.out.println(e.toString());
        }
    }



    public void ChargeQuestionGage(){
        try{

            Random randomGen = new Random();
            for(int i = 0; i < QuestionGage.size(); i++){
                System.out.println("---------------------->" + QuestionGage.size());
                if(QuestionGage.get(i).getClass() == (new Gage()).getClass()){
                    int randNombre = randomGen.nextInt(QuestionGage.size()-i) +i;
                    Question temp = QuestionGage.get(i);
                    QuestionGage.set(i,QuestionGage.get(randNombre));
                    QuestionGage.set(randNombre,temp);


                }
            }
        }
        catch (Exception e ){
            System.out.println(e.toString());
        }
    }



    public Question TireDefis(int i){
        return this.Questiondefis.get(i);
    }
    public Question TireCulsec(int i){
        return this.QuestionCulSec.get(i);
    }

    public Question TireGage(int i){

        String reponse = "";
        String[] tableauSplit = null;

        tableauSplit = QuestionGage.get(i).texte.split("<fin>");
        reponse = tableauSplit[1];
        System.out.print("------------>"+ reponse);
        if(reponse != null){
            FinQuestionGage.add(reponse);
        }
        QuestionGage.get(i).setTexte(tableauSplit[0]);
        System.out.print("Le SLIP de ouf -------------------= "+QuestionGage.get(i));



        return this.QuestionGage.get(i);

    }


}
