package com.e.miformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etFecha, etTelefono, etEmail, etDescripcion;
    DatePickerDialog picker;
    Button siguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etFecha = (EditText) findViewById(R.id.etFecha);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        siguiente = (Button) findViewById(R.id.siguiente);

        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                //date picker dialog
                picker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        etFecha.setText(i2 + "/" + (i1 + 1) + "/" + i);
                    }
                }, year, month, day);
                picker.show();
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etNombre.getText().toString();
                String date = etFecha.getText().toString();
                String phone = etTelefono.getText().toString();
                String email = etEmail.getText().toString();
                String descr = etDescripcion.getText().toString();
                Intent i = new Intent(MainActivity.this, MostrarDatos.class);
                i.putExtra("name", name);
                i.putExtra("date", date);
                i.putExtra("phone", phone);
                i.putExtra("email", email);
                i.putExtra("descr", descr);
                startActivity(i);
            }
        });
    }
}