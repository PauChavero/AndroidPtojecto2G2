package com.example.problemathics;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PregInter extends AppCompatActivity {

    int i = 0;

    int vidas = 3;
    int limitePreguntas = 10;


    Resposta respuestaCorrecta = null;
    List<Pregunta> listaPreguntas=new ArrayList<>();;

    String dificultadDeseada = "Mitja";

    TextView textVidas;

    String ufSeleccionadaInt = "";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3001")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    PreguntesAppApi preguntesAppApi = retrofit.create(PreguntesAppApi.class);

    PregFacil preguntes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String ufSeleccionada = intent.getStringExtra("ufSeleccionada");

        Log.d("uf",ufSeleccionada);
        if(ufSeleccionada.equals("Uf1")){
            ufSeleccionadaInt="1";
        }else if(ufSeleccionada=="Uf2"){
            ufSeleccionadaInt="2";
        }else if(ufSeleccionada=="Uf3"){
            ufSeleccionadaInt="3";
        }else if(ufSeleccionada=="Uf4"){
            ufSeleccionadaInt="4";
        }else if(ufSeleccionada=="Uf5"){
            ufSeleccionadaInt="5";
        }else if(ufSeleccionada=="Uf6"){
            ufSeleccionadaInt="6";
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preg_facil);
        textVidas = findViewById(R.id.textVidas);
        textVidas.setText(String.valueOf(getString(R.string.vidas)+vidas));
        Call<Preguntes> call = preguntesAppApi.getPreguntes();

        call.enqueue(new Callback<Preguntes>() {
            @Override
            public void onResponse(Call<Preguntes> call, Response<Preguntes> response) {
                if(response.isSuccessful()){
                    Preguntes preguntesOrdenades = response.body();
                    List<Pregunta> preguntes = preguntesOrdenades.getPreguntes();
                    Collections.shuffle(preguntes);
                    Log.d("Preguntes","recuperem les preguntes");

                    if (preguntes != null ) {
                        List<Pregunta> listaPreguntasSinFiltrar = preguntes;
                        List<Pregunta> listaPreguntasSinUf = new ArrayList<>();

                        for (Pregunta pregunta : listaPreguntasSinFiltrar) {
                            Log.d("Hola","Entro en bucle");
                            if (pregunta.getDificultat().equals(dificultadDeseada)) {
                                listaPreguntasSinUf.add(pregunta);
                                Log.d("Hola","Entro en if");
                            }
                        }

                        for (Pregunta pregunta : listaPreguntasSinUf) {
                            Log.d("Hola","Entro en bucle"+ pregunta.getUF());
                            Log.d("Hola",ufSeleccionadaInt);
                            if (pregunta.getUF().equals(ufSeleccionadaInt)) {
                                listaPreguntas.add(pregunta);
                                Log.d("Hola","Entro en if");
                            }
                        }
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
        if (i < listaPreguntas.size() && vidas > 0 && i < limitePreguntas) {
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
            vidas--;
            textVidas = findViewById(R.id.textVidas);
            textVidas.setText(String.valueOf(getString(R.string.vidas)+vidas));
            Log.d("Respuesta", "Respuesta incorrecta");

            if (vidas == 0) {
                // El jugador se quedó sin vidas, puedes realizar acciones adicionales aquí
                Log.d("Fin del juego", "Se quedó sin vidas");
                mostrarDialogoFinJuego();
            }
        }

        // Avanzar a la siguiente pregunta
        i++;
        mostrarPreguntaActual();
    }

    private void mostrarDialogoFinJuego() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.titFinJuego)
                .setMessage(R.string.VidasAcabadas)
                .setPositiveButton(R.string.RespuestaFinJuego, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        volverAlMenuPrincipal();
                    }
                })

                .show();
    }

    private void volverAlMenuPrincipal() {
        Intent intent = new Intent(this, NivDificultad.class); // Reemplaza "MenuPrincipal" con el nombre correcto de tu actividad principal
        startActivity(intent);
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
            Intent intent = new Intent(PregInter.this, PerfilBueno.class);
            startActivity(intent);


        }else if(id == R.id.OpMenu2){
            Intent intent = new Intent(PregInter.this,NivDificultad.class);
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
