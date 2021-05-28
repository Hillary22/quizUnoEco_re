package co.melo.quizunoeco;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterAct extends AppCompatActivity {
    private EditText nameR;
    private EditText idR;
    private Button regisBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        nameR=findViewById(R.id.nameR);
        idR=findViewById(R.id.idR);
        regisBtn=findViewById(R.id.regisBtn);




        regisBtn.setOnClickListener(
                (v)->{
                    SharedPreferences preferences = getSharedPreferences("preferencias",MODE_PRIVATE);
                    String record = preferences.getString("info","");
                    String nombre = nameR.getText().toString();
                    String identificacion = idR.getText().toString();

                    if(record.contains(identificacion)){
                        Toast.makeText(this, "Este usuario ya ha sido registrado", Toast.LENGTH_SHORT).show();
                    }else {
                        Intent i = new Intent(this, NexoAct.class);
                        i.putExtra("nombre", nombre);
                        i.putExtra("identificacion", identificacion);
                        startActivity(i);
                    }
                }
        );
    }
}
