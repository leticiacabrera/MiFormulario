package com.e.miformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {

    TextView tvNombre, tvFecha, tvTelefono, tvEmail, tvDescripcion;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        btnEditar = (Button) findViewById(R.id.btnEditar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mostrarDato();
    }

    private void mostrarDato() {
        Bundle datos = this.getIntent().getExtras();
        String nombre = datos.getString("name");
        String fecha = datos.getString("date");
        String tel = datos.getString("phone");
        String mail = datos.getString("email");
        String descripcion = datos.getString("descr");

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(tel);
        tvEmail.setText(mail);
        tvDescripcion.setText(descripcion);
    }
}