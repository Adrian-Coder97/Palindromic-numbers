package com.example.actividad_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void Siguiente(View view){
        Intent intent = new Intent(this,Capicua.class);
        startActivity(intent);
    }
    public void Siguiente1(View view){
        Intent intent = new Intent(this,Posiciones.class);
        startActivity(intent);
    }
}