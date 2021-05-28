package co.melo.quizunoeco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView registerSpace;
    private Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerSpace =findViewById(R.id.registerSpace);
        regBtn =findViewById(R.id.regBtn);


        regBtn.setOnClickListener(
                (v)->{//para que pase a la otra pantalla
                    onClick(v);
                }


        );

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("preferencias",MODE_PRIVATE);
        String record = preferences.getString("info","");
        String[]aver=record.split(":");
        for (int i=0 ; i<aver.length ; i++){
            registerSpace.append(aver[i] + "\n");
        }
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, RegisterAct.class);
        startActivity(i);
    }
}