package com.example.problemathics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Ranquing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranquing);

        RecyclerView recyclerView = findViewById(R.id.ranquingRecycler);


        List<Usuari> usuarisListFinal = new ArrayList<Usuari>();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3001")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsuarisApi UsuarisApi = retrofit.create(UsuarisApi.class);

        Call<Usuaris> callUsuari = UsuarisApi.usuaris();

        callUsuari.enqueue(new Callback<Usuaris>() {
            @Override
            public void onResponse(Call<Usuaris> call, Response<Usuaris> response) {
                if (response.isSuccessful()) {
                    Log.e("Recycler", "Usuaris recuperats");
                    Usuaris usuaris;
                    usuaris = response.body();

                    List<Usuari> usuariList = new ArrayList<Usuari>();
                    usuariList = usuaris.getUsuaris();

                    for (Usuari usuari : usuariList) {
                        Log.e("Recycler", "Volta Bucle");
                        usuarisListFinal.add(new Usuari(usuari.getUsuari(), usuari.getEmail(), usuari.getPuntuacioSingle(), usuari.getEloMulti(), usuari.getPartidesGuanyades(), usuari.getPartidesPerdudes()));
                        Log.e("Recycler", "Usuari afegit: "+usuari.getUsuari());
                    }

                    usuarisListFinal.sort(Comparator.comparingInt(Usuari::getEloMulti).reversed());

                    for (Usuari usuari : usuarisListFinal) {
                        Log.e("Recycler", "Usuaris final: "+usuari.getUsuari());
                    }

                    recyclerView.setLayoutManager(new LinearLayoutManager(Ranquing.this));
                    recyclerView.setAdapter(new MyAdapter(getApplicationContext(), usuarisListFinal));

                } else {
                    Log.e("usuari", "Unsuccessful response. Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Usuaris> call, Throwable t) {
                Log.e("usuari", "Error recuperant usuari", t);
            }
        });




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
            Intent intent = new Intent(Ranquing.this, PerfilBueno.class);
            startActivity(intent);


        }else if(id == R.id.OpMenu2){
            Intent intent = new Intent(Ranquing.this,NivDificultad.class);
            startActivity(intent);

        }
        else if (id == R.id.OpMenuSalir){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        }
        else if (id == R.id.OpMenuRanquing){
            Intent intent = new Intent(Ranquing.this, Ranquing.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}