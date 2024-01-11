package com.example.problemathics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NivDificultad extends AppCompatActivity {

    private RadioGroup radioGroup;

    private RadioGroup radioUf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niv_dificultad);

        Button Jungla = findViewById(R.id.Jungla);

        radioGroup = findViewById(R.id.radioGroup);

        radioUf = findViewById(R.id.radioGruopUfs);

        Button Jugar = findViewById(R.id.Jugar);

        Jungla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NivDificultad.this, Jungla.class);
                startActivity(intent);
            }
        });

        Jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioButtonId = radioGroup.getCheckedRadioButtonId();
                int radioButtonUfId = radioUf.getCheckedRadioButtonId();

                if (radioButtonId != -1 && radioButtonUfId != -1) {

                    RadioButton radioButton = findViewById(radioButtonId);
                    RadioButton radioButtonUf = findViewById(radioButtonUfId);
                    String dificultadSeleccionada = radioButton.getText().toString();
                    String ufSeleccionada = radioButtonUf.getText().toString();

                    // Según la opción seleccionada, inicia la actividad correspondiente
                    Log.d("Seleccionada",dificultadSeleccionada);
                    if (dificultadSeleccionada.equals("Facil") || dificultadSeleccionada.equals("Easy") || dificultadSeleccionada.equals("Fácil")) {
                        Intent intent = new Intent(NivDificultad.this, PregFacil.class);
                        Log.d("Uf",ufSeleccionada);
                        intent.putExtra("ufSeleccionada", ufSeleccionada);
                        startActivity(intent);
                    } else if (dificultadSeleccionada.equals("Intermedi") || dificultadSeleccionada.equals("Intermediate") || dificultadSeleccionada.equals("Intermedio")) {
                        Intent intent = new Intent(NivDificultad.this, PregInter.class);
                        intent.putExtra("ufSeleccionada", ufSeleccionada);
                        startActivity(intent);
                    } else if (dificultadSeleccionada.equals("Dificil") || dificultadSeleccionada.equals("Difficult") || dificultadSeleccionada.equals("Difícil")) {
                        Intent intent = new Intent(NivDificultad.this, PregDific.class);
                        intent.putExtra("ufSeleccionada", ufSeleccionada);
                        startActivity(intent);
                    }

                } else {
                    // Muestra un Toast si no se ha seleccionado ninguna opción
                    Toast.makeText(NivDificultad.this, "Selecciona una dificultad i UF", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    //Overflow options menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Administrador de el directorio
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        if(id == R.id.OpMenu1) {
            Intent intent = new Intent(NivDificultad.this, PerfilBueno.class);
            startActivity(intent);


        }else if(id == R.id.OpMenu2){
            Intent intent = new Intent(NivDificultad.this,NivDificultad.class);
            startActivity(intent);

        }else if (id == R.id.OpMenuRanquing){
            Intent intent = new Intent(NivDificultad.this, Ranquing.class);
            startActivity(intent);
        }
        else if (id == R.id.OpMenuSalir){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}