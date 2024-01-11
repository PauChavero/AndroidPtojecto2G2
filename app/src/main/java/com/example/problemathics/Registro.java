package com.example.problemathics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        EditText nomRegis= findViewById(R.id.nomRegistre);
        EditText mailRegis= findViewById(R.id.mailRegistre);
        EditText contraRegis1 = findViewById(R.id.passw1Registre);
        EditText contraRegis2 = findViewById(R.id.passw2Registre);


        Button btnRegistro= findViewById(R.id.btnAñaRegis);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nomUsuari = nomRegis.getText().toString();
                String email = mailRegis.getText().toString();
                String contrasenya = contraRegis1.getText().toString();
                String contrasenya2 = contraRegis2.getText().toString();

                if (nomUsuari.isEmpty() || email.isEmpty() || contrasenya.isEmpty() || contrasenya2.isEmpty()) {
                    Toast.makeText(Registro.this, "Alguno de los campos esta incompleto", Toast.LENGTH_SHORT).show();
                }else{
                    RegistroEnviar registroEnviar = new RegistroEnviar(nomUsuari,email,contrasenya, 0 ,500,0,0, false );

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://10.0.2.2:3001")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    RegistroApi registroApi = retrofit.create(RegistroApi.class);

                    Call<RespuestaAutenticacion> call = registroApi.autenticarRegistrto(registroEnviar);
                    call.enqueue((new Callback<RespuestaAutenticacion>() {
                        @Override
                        public void onResponse(Call<RespuestaAutenticacion> call, Response<RespuestaAutenticacion> response) {
                            Log.d("Respuesta del servidor: ", "Response");

                        }

                        @Override
                        public void onFailure(Call<RespuestaAutenticacion> call, Throwable t) {
                            Log.d("Respuesta del servidor: ", "Feilure");
                            Intent intent = new Intent(Registro.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }));
                }
            }
        });
    }
}