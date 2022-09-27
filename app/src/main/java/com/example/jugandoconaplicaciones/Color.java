package com.example.jugandoconaplicaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Color extends AppCompatActivity {
    public static final String NUM = "12";
    EditText editText;
    TextView textView;
    Button btnVolver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        textView = findViewById(R.id.textView2);
        editText = findViewById(R.id.editTextNumber2);
        btnVolver2 = findViewById(R.id.buttonVolver2);

        Intent intent2 = getIntent();

        String nombre = intent2.getStringExtra(MainActivity.NOMBRE);
        textView.setText("Hola " + nombre);

        btnVolver2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = editText.getText().toString();

                Intent intento = new Intent();
                intento.putExtra(NUM,num);
                setResult(RESULT_OK,intento);
                finish();

            }
        });

    }
}