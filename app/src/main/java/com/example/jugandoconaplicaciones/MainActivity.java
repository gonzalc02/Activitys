package com.example.jugandoconaplicaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String NOMBRE = "Nombre";
    Button ButtonLanzar;
    EditText editTextNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonLanzar = findViewById(R.id.buttonLanzar);
        editTextNombre = findViewById(R.id.editTextNombre);

        ButtonLanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, saludoActivity.class);
                intento.putExtra(NOMBRE, editTextNombre.getText().toString());
                startActivity(intento);
            }
        });

    }
}