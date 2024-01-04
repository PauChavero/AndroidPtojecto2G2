package com.example.problemathics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilBueno extends AppCompatActivity {

    TextView nomUsuari;
    TextView email;
    TextView puntuacioSingle;
    TextView eloMulti;
    TextView partidesGuanyades;
    TextView partidesPerdudes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_bueno);

        nomUsuari = findViewById(R.id.nomUsuari);
        email = findViewById(R.id.email);
        puntuacioSingle = findViewById(R.id.puntuacioSingle);
        eloMulti = findViewById(R.id.eloMulti);
        partidesGuanyades = findViewById(R.id.partidesGuanyades);
        partidesPerdudes = findViewById(R.id.partidesPerdudes);

        Usuari usuarioActual = ((variableGlobalUsuari) getApplication()).getUsuari();

        nomUsuari.setText(usuarioActual.getUsuari());
        email.setText(usuarioActual.getEmail());
        puntuacioSingle.setText(String.valueOf(usuarioActual.getPuntuacioSingle()));
        eloMulti.setText(String.valueOf(usuarioActual.getEloMulti()));
        partidesGuanyades.setText(String.valueOf(usuarioActual.getPartidesGuanyades()));
        partidesPerdudes.setText(String.valueOf(usuarioActual.getPartidesPerdudes()));

    }

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
            Intent intent = new Intent(PerfilBueno.this, PerfilBueno.class);
            startActivity(intent);


        }else if(id == R.id.OpMenu2){
            Intent intent = new Intent(PerfilBueno.this,NivDificultad.class);
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