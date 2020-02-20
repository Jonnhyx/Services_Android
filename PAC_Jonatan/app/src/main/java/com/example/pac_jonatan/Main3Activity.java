package com.example.pac_jonatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class Main3Activity extends AppCompatActivity {

    private Button servicio, volver;
    private Spinner listBox;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        servicio = (Button) findViewById(R.id.btnServicioNuevo);
        volver = (Button) findViewById(R.id.btnVolver);
        listBox = (Spinner) findViewById(R.id.spinner);

        servicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(listBox.getSelectedItem().toString());
                switch (listBox.getSelectedItem().toString()){
                    case "Iniciar Música":
                        iniciarMusica("1");
                        break;
                    case "Detener Música":
                        pararMusica("2");
                        break;
                    case "Pausar Música":
                        pausarMusica("3");
                        break;
                }
                //iniciarMusica();
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main3Activity.this, MainActivity.class));
            }
        });

    }

    public void iniciarMusica(String dato){
        Intent mp = new Intent(this,MyService.class);
        mp.putExtra("valor", dato);
        //startService(new Intent(this, MyService.class));
        this.startService(mp);
    }

    public void pararMusica(String dato){
        Intent mp = new Intent(this,MyService.class);
        mp.putExtra("valor", dato);
        //startService(new Intent(this, MyService.class));
        this.stopService(mp);
    }

    public void pausarMusica(String dato){
        Intent mp = new Intent(this,MyService.class);
        mp.putExtra("valor", dato);
        this.startService(mp);
    }

}
