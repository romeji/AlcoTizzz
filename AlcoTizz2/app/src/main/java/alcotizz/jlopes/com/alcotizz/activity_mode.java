package alcotizz.jlopes.com.alcotizz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_mode extends Activity {


    private Button button_classique;
    private Button button_coop;
    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        button_classique = (Button) findViewById(R.id.button_Classique);
        button_classique.setOnClickListener(

                new View.OnClickListener() {
                    public void onClick(View v) {

                        Intent intent = new Intent(activity_mode.this, activity_player.class);   // Passage à l'activité Vin
                        startActivity(intent);
                        mode = 1;
                    }
                }
        );

        button_coop = (Button) findViewById(R.id.button_coop);
        button_coop.setOnClickListener(

                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(activity_mode.this, activity_player_coop.class);   // Passage à l'activité Vin
                        startActivity(intent);
                        mode = 2;
                    }
                }



        );



    }
}
