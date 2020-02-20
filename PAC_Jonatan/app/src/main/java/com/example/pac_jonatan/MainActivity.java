package com.example.pac_jonatan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnActivity2, btnActivity3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActivity2 = (Button) findViewById(R.id.btnActivity2);
        btnActivity2.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                                            }
                                        }
        );

        btnActivity3 = (Button) findViewById(R.id.btnActivity3);
        btnActivity3.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                startActivity(new Intent(MainActivity.this, Main3Activity.class));
                                            }
                                        }
        );
    }
}
