package alcotizz.jlopes.com.alcotizz;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class activity_player extends Activity {

    private EditText Player0;
    private EditText Player1;
    private EditText Player2;
    private EditText Player3;

    private Button button_commence;
    private Button Ajouter;
    private LinearLayout Layout;
    public int i = 5;
    String ListeJoueurs = "";

    ArrayList<EditText> listWidgets = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);



        button_commence = (Button) findViewById(R.id.bt_commencer);
        final LinearLayout Layout = (LinearLayout) this.findViewById(R.id.LayoutPlayer);

        button_commence.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        ListeJoueurs = RecuperePlayer();
                        Intent intent = new Intent(activity_player.this, activity_partie.class);   // Passage à l'activité
                        intent.putExtra("ListeJoueurs", ListeJoueurs);
                        startActivity(intent);
                    }
                }
        );

        Ajouter = (Button) findViewById(R.id.btAddPlayer);

        Ajouter.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        EditText edit = new EditText(activity_player.this);
                        edit.setText("Joueur " + i);
                        edit.setTextSize(24);
                        edit.setBackgroundColor(Color.parseColor("#FF135581"));
                        Layout.addView(edit,i-1);
                        edit.setId(0+i);
                    }
                }
        );


    }

    public String RecuperePlayer() {


        listWidgets.add((EditText) findViewById(R.id.Player0));
        listWidgets.add((EditText) findViewById(R.id.Player1));
        listWidgets.add((EditText) findViewById(R.id.Player2));
        listWidgets.add((EditText) findViewById(R.id.Player3));



        for(EditText currenWidget : listWidgets){
            if(!currenWidget.getText().toString().equals("Joueur")&&!currenWidget.getText().toString().equals("")){
                ListeJoueurs += currenWidget.getText().toString()+"%";
                System.out.println("IciLa"+ListeJoueurs);
            }
        }
        return ListeJoueurs;
    }





}
