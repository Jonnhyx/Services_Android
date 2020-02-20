package com.example.pac_jonatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity {

    Button btnVolver, btnCrear, btnIngresar, btnConsultar;
    EditText txtNombre;
    EditText txtApellido;
    EditText txtCorreo;
    BBDD bbdd;
    ArrayList datos;
    ArrayAdapter<String> adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        datos=new ArrayList<String>();
        bbdd = new BBDD(this);

        btnCrear = (Button) findViewById(R.id.btnCrear);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Creando tabla", Toast.LENGTH_LONG).show();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, MainActivity.class));

                SQLiteDatabase db = bbdd.getWritableDatabase();
                db.execSQL("DELETE FROM Clientes");

                Toast.makeText(getBaseContext(), "Limpiando la tabla", Toast.LENGTH_LONG).show();
            }
        });


        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = bbdd.getWritableDatabase();
                Cursor c = db.rawQuery("SELECT Nombre, Apellido, Correo FROM Clientes", null);

                try{
                    if (c != null) {
                        c.moveToFirst();
                        do {
                            //Asignamos el valor en nuestras variables para usarlos en lo que necesitemos
                            String nombre = c.getString(c.getColumnIndex("Nombre"));
                            String apellido = c.getString(c.getColumnIndex("Apellido"));
                            String correo = c.getString(c.getColumnIndex("Correo"));
                            datos.add( nombre + " - " + apellido + " - " + correo);
                        } while (c.moveToNext());

                        Intent inten = new Intent(Main2Activity.this, Main4Activity.class);
                        inten.putExtra("Lista", datos);
                        startActivity(inten);
                    }
                }catch (Exception  e){
                    Toast.makeText(getBaseContext(), "Ningún dato que mostrar", Toast.LENGTH_LONG).show();
                }



                //Cerramos el cursor y la conexion con la base de datos
                c.close();
                db.close();



            }
        });


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtNombre = (EditText) findViewById(R.id.txtNombre);
                txtApellido = (EditText) findViewById(R.id.txtApellido);
                txtCorreo = (EditText) findViewById(R.id.txtCorreo);

                if(txtNombre.getText().toString().isEmpty() || txtApellido.getText().toString().isEmpty() || txtCorreo.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(), "Debes cubrir todos los campos ", Toast.LENGTH_LONG).show();
                }else{
                    SQLiteDatabase db = bbdd.getWritableDatabase();
                    db.execSQL("INSERT INTO Clientes (Nombre, Apellido, Correo) VALUES (" + "'" + txtNombre.getText().toString() + "'" + ",'"+ txtApellido.getText().toString() + "'" + ",'"+ txtCorreo.getText().toString() + "'" + ")");
                    Toast.makeText(getBaseContext(), "Insertando datos ", Toast.LENGTH_LONG).show();
                }

            }
        });

        adaptador = new ArrayAdapter(this, android.R.layout.activity_list_item,datos);
    }


}
