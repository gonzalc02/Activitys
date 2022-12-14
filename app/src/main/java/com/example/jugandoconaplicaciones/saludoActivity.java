package com.example.jugandoconaplicaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class saludoActivity extends AppCompatActivity {


    public static final String NUM = "10";
    TextView saludo;
    Button btnVolver;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);
        saludo = findViewById(R.id.texto1);
        btnVolver = findViewById(R.id.buttonVolver);
        editText = findViewById(R.id.editTextNumber);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra(MainActivity.NOMBRE);
        saludo.setText("Hola " + nombre);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = editText.getText().toString();

                Intent intento = new Intent();
                intento.putExtra(NUM, num);
                setResult(RESULT_OK,intento);
                finish();
            }
        });


    }
}