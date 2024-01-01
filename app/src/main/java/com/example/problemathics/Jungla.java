package com.example.problemathics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Jungla extends AppCompatActivity {

    int i = 0;
    Resposta respuestaCorrecta = null;
    List<Pregunta> listaPreguntas=new ArrayList<>();;


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3001")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    PreguntesAppApi preguntesAppApi = retrofit.create(PreguntesAppApi.class);

    PregFacil preguntes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jungla);

        Call<Preguntes> call = preguntesAppApi.getPreguntes();

        call.enqueue(new Callback<Preguntes>() {
            @Override
            public void onResponse(Call<Preguntes> call, Response<Preguntes> response) {
                if(response.isSuccessful()){
                    Preguntes preguntes = response.body();
                    Log.d("Preguntes","recuperem les preguntes");

                    if (preguntes != null && preguntes.getPreguntes() != null) {
                        listaPreguntas = preguntes.getPreguntes();

                        mostrarPreguntaActual();
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


                    }

                }
            }

            @Override
            public void onFailure(Call<Preguntes> call, Throwable t) {
                Log.d("Preguntes","no recuperem les preguntes");
            }
        });

    }
    private void mostrarPreguntaActual() {
        if (i < listaPreguntas.size()) {
            List<Resposta> respuestas = listaPreguntas.get(i).getRespostes();
            for (Resposta respuesta : respuestas) {
                if (respuesta.isCorrecta()) {
                    respuestaCorrecta = respuesta;
                    break;
                }
            }

            TextView pregunta = findViewById(R.id.txtPreg);
            Button opcioA = findViewById(R.id.OpCioA);
            Button opcioB = findViewById(R.id.OpCioB);
            Button opcioC = findViewById(R.id.OpCioC);
            Button opcioD = findViewById(R.id.OpCioD);

            pregunta.setText(listaPreguntas.get(i).getPregunta());
            opcioA.setText(respuestas.get(0).getResposta());
            opcioB.setText(respuestas.get(1).getResposta());
            opcioC.setText(respuestas.get(2).getResposta());
            opcioD.setText(respuestas.get(3).getResposta());

            opcioA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comprobarRespuesta(opcioA.getText().toString());
                }
            });

            opcioB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comprobarRespuesta(opcioB.getText().toString());
                }
            });

            opcioC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comprobarRespuesta(opcioC.getText().toString());
                }
            });

            opcioD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comprobarRespuesta(opcioD.getText().toString());
                }
            });
        }
    }

    private void comprobarRespuesta(String respuestaSeleccionada) {
        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaCorrecta != null && respuestaSeleccionada.equals(respuestaCorrecta.getResposta())) {
            // La respuesta es correcta
            // Puedes realizar acciones adicionales aquí
            Log.d("Respuesta", "¡Respuesta correcta!");
        } else {
            // La respuesta es incorrecta
            // Puedes realizar acciones adicionales aquí
            Log.d("Respuesta", "Respuesta incorrecta");
        }

        // Avanzar a la siguiente pregunta
        i++;
        mostrarPreguntaActual();
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
            Intent intent = new Intent(Jungla.this, NivDificultad.class);
            startActivity(intent);


        }else if(id == R.id.OpMenu2){
            Intent intent = new Intent(Jungla.this,NivDificultad.class);
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

