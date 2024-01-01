package com.example.problemathics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NivDificultad extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button Jugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niv_dificultad);


        Button btnFacil = findViewById(R.id.btnFacil);

        Button btnInter = findViewById(R.id.btnIntermedi);

        Button btnDific = findViewById(R.id.btnDificil);

        Button Jungla = findViewById(R.id.Jungla);

        radioGroup = findViewById(R.id.radioGroup);

        Jugar = findViewById(R.id.Jugar);

        btnFacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NivDificultad.this, PregFacil.class);
                startActivity(intent);
            }
        });

        btnInter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NivDificultad.this, PregInter.class);
                startActivity(intent);
            }
        });

        btnDific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NivDificultad.this, PregDific.class);
                startActivity(intent);
            }
        });

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
                if (radioButtonId != -1) {
                    RadioButton radioButton = findViewById(radioButtonId);
                    String dificultadSeleccionada = radioButton.getText().toString();

                    // Según la opción seleccionada, inicia la actividad correspondiente
                    if (dificultadSeleccionada.equals("Facil")) {
                        startActivity(new Intent(NivDificultad.this, PregFacil.class));
                    } else if (dificultadSeleccionada.equals("Intermedi")) {
                        startActivity(new Intent(NivDificultad.this, PregInter.class));
                    } else if (dificultadSeleccionada.equals("Dificil")) {
                        startActivity(new Intent(NivDificultad.this, PregDific.class));
                    }
                } else {
                    // Muestra un Toast si no se ha seleccionado ninguna opción
                    Toast.makeText(NivDificultad.this, "Selecciona una dificultad", Toast.LENGTH_SHORT).show();
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
            Intent intent = new Intent(NivDificultad.this, NivDificultad.class);
            startActivity(intent);


        }else if(id == R.id.OpMenu2){
            Intent intent = new Intent(NivDificultad.this,NivDificultad.class);
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