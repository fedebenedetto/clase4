package com.example.alumno.loginejercicio1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BienvenidaActivity extends AppCompatActivity {
    TextView mensaje;
    Button enviar;
    private static final int MAIL_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        mensaje = (TextView) findViewById(R.id.tv_mensaje);
        mensaje.setText(String.format(getString(R.string.msj), getIntent().getStringExtra("usuario"), getIntent().getStringExtra("mail")));
        enviar = (Button) findViewById(R.id.bt_ingresar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                composeEmail();
            }
        });
    }

    public void composeEmail() {
        String[] mail = new String[]{getIntent().getStringExtra("mail")};
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, mail);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hola");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, MAIL_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MAIL_REQUEST) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Correo Enviado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No se ha enviado el correo", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
