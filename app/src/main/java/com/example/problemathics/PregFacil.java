package com.example.problemathics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PregFacil extends AppCompatActivity {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3001")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    PreguntesAppApi preguntesAppApi = retrofit.create(PreguntesAppApi.class);

    PregFacil preguntes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preg_facil);
/*
        Call<PregFacil> call = preguntesAppApi.getPreguntes();
        call.enqueue(new Callback<PregFacil>() {
            @Override
            public void onResponse(Call<PregFacil> call, Response<PregFacil> response) {
                Log.d("msg", "Carregant les preguntes");
                if(response.isSuccessful()){
                    PregFacil dades = response.body();

                    String titol= dades.getTitle();
                }

            }

            @Override
            public void onFailure(Call<PregFacil> call, Throwable t) {

            }
        });*/

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
            Intent intent = new Intent(PregFacil.this, NivDificultad.class);
            startActivity(intent);


        }else if(id == R.id.OpMenu2){
            Intent intent = new Intent(PregFacil.this,NivDificultad.class);
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
