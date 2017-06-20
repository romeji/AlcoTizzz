package alcotizz.jlopes.com.alcotizz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class activity_run extends Activity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(

                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(activity_run.this, activity_mode.class);   // Passage à l'activité Vin
                        startActivity(intent);

                    }
                }
        );
    }
}
