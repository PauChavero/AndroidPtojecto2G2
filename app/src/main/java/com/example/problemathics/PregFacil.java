package com.example.problemathics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

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

        Call<Preguntes> call = preguntesAppApi.getPreguntes();

        call.enqueue(new Callback<Preguntes>() {
            @Override
            public void onResponse(Call<Preguntes> call, Response<Preguntes> response) {
                if(response.isSuccessful()){
                    Preguntes preguntes = response.body();
                    Log.d("Preguntes","recuperem les preguntes");

                    if (preguntes != null && preguntes.getPreguntes() != null) {
                        List<Pregunta> listaPreguntas = preguntes.getPreguntes();

                        for (Pregunta pregunta : listaPreguntas) {
                            Log.d("Preguntes", "ID: " + pregunta.getId());
                            Log.d("Preguntes", "Pregunta: " + pregunta.getPregunta());
                            Log.d("Preguntes", "Imagen: " + pregunta.getImatge());
                            Log.d("Preguntes", "Categoria: " + pregunta.getCategoria());
                            Log.d("Preguntes", "Dificultad: " + pregunta.getDificultat());
                            Log.d("Preguntes", "UF: " + pregunta.getUF());

                            List<Resposta> listaRespuestas = pregunta.getRespostes();
                            for (Resposta resposta : listaRespuestas) {
                                Log.d("Preguntes", "Respuesta: " + resposta.getResposta());
                                Log.d("Preguntes", "Correcta: " + resposta.isCorrecta());
                            }
                        }
                    } else {
                        Log.d("Preguntes", "La lista de preguntas está vacía o nula");
                    }

                }
            }

            @Override
            public void onFailure(Call<Preguntes> call, Throwable t) {
                Log.d("Preguntes","no recuperem les preguntes");
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
