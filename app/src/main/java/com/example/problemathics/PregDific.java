package com.example.problemathics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class PregDific extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preg_dific);
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
            Intent intent = new Intent(PregDific.this, NivDificultad.class);
            startActivity(intent);


        }else if(id == R.id.OpMenu2){
            Intent intent = new Intent(PregDific.this,NivDificultad.class);
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