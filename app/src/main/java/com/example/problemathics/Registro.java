package com.example.problemathics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
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

                String userName = nomRegis.getText().toString();
                String userMail = mailRegis.getText().toString();
                String userPassw1 = contraRegis1.getText().toString();
                String userPassw2 = contraRegis2.getText().toString();

                if (userName.isEmpty() || userMail.isEmpty() || userPassw1.isEmpty() || userPassw2.isEmpty()) {
                    Toast.makeText(Registro.this, "Alguno de los campos esta incompleto", Toast.LENGTH_SHORT).show();
                }else{
                    RegistroEnviar registroEnviar = new RegistroEnviar(userName,userMail,userPassw1);

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://10.0.2.2:3001")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    ApiService apiService = retrofit.create(ApiService.class);

                    
                }

            }
        });
    }
}