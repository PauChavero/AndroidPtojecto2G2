package com.example.problemathics;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nomPersona = findViewById(R.id.nomId);
        EditText contraPersona = findViewById(R.id.nomPassw);

        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = nomPersona.getText().toString();
                String password = contraPersona.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, ingrese el usuario y contraseña ", Toast.LENGTH_SHORT).show();
                } else {
                    DatosEnviar datosEnviar = new DatosEnviar(username, password);

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://10.0.2.2:3001")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    ApiService apiService = retrofit.create(ApiService.class);

                    Call<RespuestaAutenticacion> call = apiService.autenticarUsuario(datosEnviar);
                    call.enqueue((new Callback<RespuestaAutenticacion>() {
                        @Override
                        public void onResponse(Call<RespuestaAutenticacion> call, Response<RespuestaAutenticacion> response) {

                            if (response.isSuccessful()) {
                                RespuestaAutenticacion respuesta = response.body();
                                String mensaje = respuesta.getMensaje();

                                if ("Inicio de sesión exitoso".equals(mensaje)) {
                                    Intent intent = new Intent(MainActivity.this, NivDificultad.class);
                                    startActivity(intent);
                                } else {
                                    Log.d("Respuesta del servidor: ", mensaje);
                                    Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Log.e("Error en la respuesta", "Código de respuesta:" + response.code());
                                try {
                                    Log.e("Cuerpo de la respuesta", response.errorBody().string());
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                Toast.makeText(MainActivity.this, "Usuario no auténticado, prueba a registrarte", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<RespuestaAutenticacion> call, Throwable t) {
                            Log.e("Error en la solicitud", "Mensaje de error:" + t.getMessage());

                            Toast.makeText(MainActivity.this, "Error en la solicitud: " + t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }));
                }
            }
        });
    }
};