package com.example.pac_jonatan;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;

import static android.content.Intent.getIntent;

public class MyService extends Service {

    MediaPlayer mp;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    public void onCreate(){
        super.onCreate();
        mp = mp.create(this,R.raw.beherenow);
        mp.setLooping(true);
        mp.setVolume(100,100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle extra = intent.getExtras();
        String dato = extra.getString("valor");
        if(Integer.parseInt(dato)==1){
            System.out.println("Iniciando la música");
            mp.start();

        }
        else if(Integer.parseInt(dato)==3){
            if(mp.isPlaying()){
                mp.pause();
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    System.out.println("Error iniciando pause de 15 segundos");
                }
                mp.start();
                System.out.println("Iniciando pause de 15 segundos");
            }
        }
        return  START_STICKY;
    }

    public void onDestroy(){
        super.onDestroy();
        if(mp.isPlaying()){
            mp.stop();
        }
        mp.release();
        mp=null;
        System.out.println("El servicio a Terminado");
    }
}
