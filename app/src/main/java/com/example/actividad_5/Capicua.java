package com.example.actividad_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;

public class Capicua extends AppCompatActivity {

    TextView num, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capicua);

        num = (TextView) findViewById(R.id.txtNumero);
        res = (TextView) findViewById(R.id.txtResultado);


    }

    public void Anterior(View view) {
        Intent anterior = new Intent(this, Menu.class);
        startActivity(anterior);

    }

    public void Evaluar(View view) {
        negro();
        String valor = num.getText().toString();
        if (valor.isEmpty()) {
            num.setError("llenar este campo");//NO PONER MAYUSCULAS
        }
        if (!valor.isEmpty()) {
            int valorInt = Integer.parseInt(valor);
            String nume = String.valueOf(valorInt);
            String resul;
            if (valor.length() == 1) {
                verde();
                resul = ("El numero " + nume + " si es capicua ya que todos los numeros de un digito son numeros capicua");
                res.setText(resul);
            } else if (valor.length() == 2) {
                if (valor.charAt(0) == valor.charAt(1)) {
                    verde();
                    resul = ("El numero " + nume + " si es capicua ya que el primer digito es igual al segundo");
                    res.setText(resul);
                } else if (valor.charAt(0) != valor.charAt(1)) {
                    rojo();
                    resul = ("El numero " + nume + " no es capicua ya que el primer digito NO es igual al segundo");
                    res.setText(resul);
                }
            }
        }

    }

    public void negro() {
        res.setTextColor(Color.BLACK);
        //res.setShadowLayer(1, 0, 0, Color.BLACK);
    }

    public void verde() {
        res.setTextColor(Color.BLUE);
        //res.setShadowLayer(1, 0, 0, Color.BLACK);
    }

    public void rojo() {
        res.setTextColor(Color.RED);
        //res.setShadowLayer(1, 0, 0, Color.BLACK);
    }


}