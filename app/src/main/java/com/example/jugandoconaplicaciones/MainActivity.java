package com.example.jugandoconaplicaciones;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String NOMBRE = "Nombre";
    private static final int CODIGO_IDENFICICACION_SALUDO = 10;
    private  static  final  int CODIGO_IDENTIFICACION_COLOR = 12;
    Button ButtonLanzar, btnColor;
    EditText editTextNombre;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODIGO_IDENFICICACION_SALUDO && resultCode == RESULT_OK){
            String num = data.getStringExtra(saludoActivity.NUM);
            editTextNombre.setText(editTextNombre.getText()+ " "+ num);
        }
        if(requestCode == CODIGO_IDENTIFICACION_COLOR && resultCode == RESULT_OK){
            String num = data.getStringExtra(Color.NUM);
            editTextNombre.setText(editTextNombre.getText().toString()+" "+ num);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonLanzar = findViewById(R.id.buttonLanzar);
        editTextNombre = findViewById(R.id.editTextNombre);
        btnColor = findViewById(R.id.buttonColor);

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, Color.class);
                intento.putExtra(NOMBRE,editTextNombre.getText().toString());
                startActivityForResult(intento, CODIGO_IDENTIFICACION_COLOR);
            }
        });

        ButtonLanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, saludoActivity.class);
                intento.putExtra(NOMBRE, editTextNombre.getText().toString());
                //startActivity(intento);
                startActivityForResult(intento,CODIGO_IDENFICICACION_SALUDO);
            }
        });

    }
}