package co.melo.quizunoeco;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NexoAct extends AppCompatActivity {

    private Button sigBtn;
    private CheckBox checkB1;
    private CheckBox checkB2;
    private CheckBox checkB3;
    private CheckBox checkB4;
    private CheckBox checkB5;
    private String nombre;
    private String identificacion;
    private int puntajeN;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nexo);

        sigBtn = findViewById(R.id.sigBtn); //botón

        checkB1 = findViewById(R.id.checkB1);
        checkB2 = findViewById(R.id.checkB2);
        checkB3 = findViewById(R.id.checkB3);
        checkB4 = findViewById(R.id.checkB4);
        checkB5 = findViewById(R.id.checkB5);

        nombre = getIntent().getExtras().getString("nombre");
        identificacion = getIntent().getExtras().getString("identificacion");
        puntajeN=0;

        sigBtn.setOnClickListener(

                (v)->{
                    if (checkB1.isChecked()){
                        puntajeN += 3;
                    }
                    if (checkB2.isChecked()){
                        puntajeN += 3;
                    }
                    if (checkB3.isChecked()){
                        puntajeN += 3;
                    }
                    if (checkB4.isChecked()){
                        puntajeN += 3;
                    }
                    if (checkB5.isChecked()){
                        puntajeN += 0;
                        checkB1.setChecked(false);
                        checkB2.setChecked(false);
                        checkB3.setChecked(false);
                        checkB4.setChecked(false);

                    }

                    Intent i = new Intent(this, SymptomAct.class);
                    i.putExtra("puntajeNexo", puntajeN);
                    i.putExtra("nombre", nombre);
                    i.putExtra("identificacion", identificacion);
                    startActivity(i);


                }





        );

    }


}
