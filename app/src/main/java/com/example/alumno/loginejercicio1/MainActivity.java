package com.example.alumno.loginejercicio1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText usuario;
    EditText mail;
    EditText pass;
    Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.et_usuario);
        mail = (EditText) findViewById(R.id.et_mail);
        pass = (EditText) findViewById(R.id.et_pass);
        ingresar = (Button) findViewById(R.id.bt_ingresar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pass.getText().toString().trim().equals("1234")) {
                    Intent intent = new Intent(MainActivity.this, BienvenidaActivity.class);
                    intent.putExtra("usuario", usuario.getText().toString().trim());
                    intent.putExtra("mail" , mail.getText().toString().trim());
                    startActivity(intent);
                }

            }
        });

    }
}
