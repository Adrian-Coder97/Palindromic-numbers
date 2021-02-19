package com.example.actividad_5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;

public class Posiciones extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posiciones);

        et1 = (EditText) findViewById(R.id.txtNum1);
        et2 = (EditText) findViewById(R.id.txtNum2);
        tv1 = (TextView) findViewById(R.id.txtRes1);
        tv2 = (TextView) findViewById(R.id.txtRes2);

    }

    public void VolverDePosiciones(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void Evaluar(View view) {
        String numero1 = et1.getText().toString();
        String numero2 = et2.getText().toString();

        if (numero1.isEmpty()) {
            et1.setError("Ingresa un numero");
        }
        if (numero2.isEmpty()) {
            et2.setError("Ingresa un numero");
        }
        if (!numero1.isEmpty() && !numero2.isEmpty()) {
            if (numero1.length() == numero2.length()) {
               /* System.out.println("cad1: " + numero1);
                System.out.println("cad2: " + numero2);*/

                char[] ch = new char[numero1.length()];//convertir cadena a array de caracteres
                for (int i = 0; i < numero1.length(); i++) {
                    ch[i] = numero1.charAt(i);
                }
                char[] ch2 = new char[numero2.length()];//convertir cadena a array de caracteres
                for (int i = 0; i < numero2.length(); i++) {
                    ch2[i] = numero2.charAt(i);
                }

                for (int i = 0; i < ch.length; i++) {
                    if ((i - 1) % 2 == 0) {//obtener los valores del arreglo 1 que sean pares
                        for (int j = 0; j < ch2.length; j++) {
                            if ((j - 1) % 2 == 0) {//reemplazar los valores en posiciones pares del arreglo 2 en el arreglo 1
                                ch2[j]=ch[j];
                            }
                        }
                    }
                }

                for (int i = 0; i < ch2.length; i++) {
                    if ((i - 1) % 2 == 0) {}else{//obtener los valores del arreglo 1 que sean impares
                        for (int j = 0; j < ch.length; j++) {
                            if ((j - 1) % 2 == 0) {}else{//reemplazar los valores impares del arreglo 2 en las posiciones impares del arreglo 1
                                ch[j]=ch2[j];
                            }
                        }
                    }
                }
                String cadena1Final = new String(ch);//convertir arreglo a una nueva cadena
                tv1.setText(cadena1Final);
                String cadena2Final = new String(ch2);//convertir arreglo a una nueva cadena
                tv2.setText(cadena2Final);

            } else {
                diferenteLargo();
            }
        }


    }

    public void diferenteLargo() {
        AlertDialog alertDialog = new AlertDialog.Builder(Posiciones.this).create();
        alertDialog.setTitle("Error!");
        alertDialog.setMessage("Ambos numeros tener la misma cantidad de digitos");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}