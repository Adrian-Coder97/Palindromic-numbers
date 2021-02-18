package com.example.actividad_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Posiciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posiciones);
    }

    public void VolverDePosiciones(View view){
        Intent intent = new Intent(this,Menu.class);
        startActivity(intent);
    }
}