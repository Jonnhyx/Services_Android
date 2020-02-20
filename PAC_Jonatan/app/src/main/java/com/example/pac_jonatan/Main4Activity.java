package com.example.pac_jonatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    ArrayList<String> names;
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ListView lista = (ListView) findViewById(R.id.vista);
        ArrayList listadatos = getIntent().getStringArrayListExtra("Lista");
        names = new ArrayList<String>();
        names.add("nombre" + " - " + "apellido" + " - " + "correo" );
        names.add("Tabasco");
        names.add("Chiapas");
        names.add("Campeche");
        names.add("Quintana Roo");
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listadatos);
        lista.setAdapter(adaptador);


    }
}
