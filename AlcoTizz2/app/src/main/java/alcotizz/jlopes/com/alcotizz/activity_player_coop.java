package alcotizz.jlopes.com.alcotizz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class activity_player_coop extends Activity {

    String ListeJoueursEquipe1;
    String ListeJoueursEquipe2;
    private Button button_commence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_coop);

        button_commence = (Button) findViewById(R.id.bt_coop_run);
        button_commence.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                        Intent intent = new Intent(activity_player_coop.this, activity_partie_coop.class);   // Passage à l'activité
                        startActivity(intent);
                    }
                }
        );

    }

    public String RecuperePlayerEquipe1(){


        EditText EditEquipe1 = (EditText)findViewById(R.id.NomEquipe1);
        String txtequipe1 = EditEquipe1.getText().toString();

        ArrayList<EditText> listWidgetsEquipe1 = new ArrayList<>();

        listWidgetsEquipe1.add((EditText) findViewById(R.id.Player00));
        listWidgetsEquipe1.add((EditText) findViewById(R.id.Player01));
        listWidgetsEquipe1.add((EditText) findViewById(R.id.Player02));
        listWidgetsEquipe1.add((EditText) findViewById(R.id.Player03));
        listWidgetsEquipe1.add((EditText) findViewById(R.id.Player04));
        listWidgetsEquipe1.add((EditText) findViewById(R.id.Player05));
        listWidgetsEquipe1.add((EditText) findViewById(R.id.Player06));

        for(EditText currenWidgetEquipe1 : listWidgetsEquipe1){
            if(!currenWidgetEquipe1.getText().toString().equals("Joueur")){
                ListeJoueursEquipe1 += currenWidgetEquipe1.getText().toString()+"%";
            }
        }
        return ListeJoueursEquipe1;
    }


    public String RecuperePlayerEquipe2() {

        EditText EditEquipe2 = (EditText)findViewById(R.id.NomEquipe2);
        String txtequipe2 = EditEquipe2.getText().toString();

        Equipe Equipe2 = new Equipe(txtequipe2);
        ArrayList<EditText> listWidgetsEquipe2 = new ArrayList<>();

        listWidgetsEquipe2.add((EditText) findViewById(R.id.Player10));
        listWidgetsEquipe2.add((EditText) findViewById(R.id.Player11));
        listWidgetsEquipe2.add((EditText) findViewById(R.id.Player12));
        listWidgetsEquipe2.add((EditText) findViewById(R.id.Player13));
        listWidgetsEquipe2.add((EditText) findViewById(R.id.Player14));
        listWidgetsEquipe2.add((EditText) findViewById(R.id.Player15));
        listWidgetsEquipe2.add((EditText) findViewById(R.id.Player16));

        for(EditText currenWidgetEquipe2 : listWidgetsEquipe2){
            if(!currenWidgetEquipe2.getText().toString().equals("Joueur")){
                ListeJoueursEquipe2 += currenWidgetEquipe2.getText().toString()+"%";
                System.out.println(ListeJoueursEquipe1);
            }
        }
        return ListeJoueursEquipe2;
    }


}
