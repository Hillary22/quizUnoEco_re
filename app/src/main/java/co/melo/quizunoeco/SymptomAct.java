package co.melo.quizunoeco;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SymptomAct extends AppCompatActivity {
    private CheckBox checkB6;
    private CheckBox checkB8;
    private CheckBox checkB9;
    private CheckBox checkB10;
    private CheckBox checkB11;
    private CheckBox checkB12;
    private CheckBox checkB7;

    private Button endBtn;
    private String nombre;
    private String identificacion;
    private int puntajeN;
    private int puntajeS;
    private int puntajeT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.symptom);
        checkB6=findViewById(R.id.checkB6);
        checkB8=findViewById(R.id.checkB8);
        checkB9=findViewById(R.id.checkB9);
        checkB10=findViewById(R.id.checkB10);
        checkB11=findViewById(R.id.checkB11);
        checkB12=findViewById(R.id.checkB12);
        checkB7=findViewById(R.id.checkB7);
        endBtn=findViewById(R.id.endBtn);

        nombre = getIntent().getExtras().getString("nombre");
        identificacion = getIntent().getExtras().getString("identificacion");
        puntajeN=getIntent().getExtras().getInt("puntajeN");
        puntajeS = 0;


        endBtn.setOnClickListener(
                (v)->{

                    if (checkB6.isChecked()){
                        puntajeS += 4;
                    }
                    if (checkB8.isChecked()){
                        puntajeS += 4;
                    }
                    if (checkB9.isChecked()){
                        puntajeS += 4;
                    }
                    if (checkB10.isChecked()){
                        puntajeS += 4;
                    }
                    if (checkB11.isChecked()){
                        puntajeS += 4;
                    }
                    if (checkB12.isChecked()){
                        puntajeS += 4;
                    }
                    if (checkB7.isChecked()){
                        puntajeS += 0;
                        checkB6.setChecked(false);// la esperanza de poner hilos se fue al caño XDD
                        checkB8.setChecked(false);
                        checkB9.setChecked(false);
                        checkB10.setChecked(false);
                        checkB11.setChecked(false);
                        checkB12.setChecked(false);

                    }



                    puntajeT = (puntajeN+puntajeS);
                    String puntaje=String.valueOf(puntajeT);
                    SharedPreferences preferences = getSharedPreferences("preferencias",MODE_PRIVATE);
                    String record = preferences.getString("info","");
                    String registro = record+":"+nombre+" "+identificacion+" "+puntaje;
                    preferences.edit().putString("info",registro).apply();

                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
        );
    }

}
