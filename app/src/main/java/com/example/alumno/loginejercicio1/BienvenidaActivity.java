package com.example.alumno.loginejercicio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BienvenidaActivity extends AppCompatActivity {
    TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        mensaje = (TextView) findViewById(R.id.tv_mensaje);
        mensaje.setText(String.format(getString(R.string.msj), getIntent().getStringExtra("usuario"), getIntent().getStringExtra("mail")));
    }
}
