package com.example.problemathics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EscUF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esc_uf);

        Button btnUf1 = findViewById(R.id.btn1EscUf);
        Button btnUf2 = findViewById(R.id.btn2EscUf);
        Button btnUf3 = findViewById(R.id.btn3EscUf);
        Button btnUf4 = findViewById(R.id.btn4EscUf);
        Button btnUf5 = findViewById(R.id.btn5EscUf);
        Button btnUf6 = findViewById(R.id.btn6EscUf);

        btnUf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscUF.this, NivDificultad.class);
                startActivity(intent);
            }
        });

        btnUf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscUF.this, NivDificultad.class);
                startActivity(intent);
            }
        });

        btnUf3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscUF.this, NivDificultad.class);
                startActivity(intent);
            }
        });

        btnUf4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscUF.this, NivDificultad.class);
                startActivity(intent);
            }
        });

        btnUf5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscUF.this, NivDificultad.class);
                startActivity(intent);
            }
        });

        btnUf6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscUF.this, NivDificultad.class);
                startActivity(intent);
            }
        });
    }


}