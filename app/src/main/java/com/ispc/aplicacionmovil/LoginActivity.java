package com.ispc.aplicacionmovil;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //Declaramos los componentes
    private EditText etUsuario;
    private EditText etPassword;
    private Button btnLoguin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Enlazar componente Java con su ID XML
        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        btnLoguin = findViewById(R.id.btnLogin);

        //Escuchar el evento de click del boton
        btnLoguin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = etUsuario.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                //Validar que los campos no esten vacíos

                if (!usuario.isEmpty() && !password.isEmpty()) {

                    //Crear Intent para ir a MainActivity

                    Intent intent = new Intent(
                            LoginActivity.this,
                            MainActivity.class
                    );

                    // Adjuntar un dato "extra" para llevarlo a la siguiente pantalla
                    intent.putExtra(
                            "EXTRA_USUARIO",
                            usuario
                    );

                    startActivity(intent);

                    //Cierra la pantalla de Login al ingresar
                    finish();

                }else {
                    //Mostrar mensaje de advertencia

                    Toast.makeText(
                            LoginActivity.this,
                            "Por favor complete todos los campos",
                            Toast.LENGTH_SHORT
                    ).show();
                }


            }
        });



    }
}