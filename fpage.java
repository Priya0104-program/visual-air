package com.example.visual_air;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class fpage extends AppCompatActivity {
    Button ulogin,uregister,loc;
    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpage);

        ulogin=(Button)findViewById(R.id.uslog);
        uregister=(Button)findViewById(R.id.usreg);
        loc=(Button)findViewById(R.id.l1);


        ulogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(fpage.this,register.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(),"information  page",Toast.LENGTH_SHORT).show();

            }
        });
        uregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(fpage.this,info.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(),"about air pollution",Toast.LENGTH_SHORT).show();

            }
        });
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(fpage.this,loco.class);
                startActivity(in);
            }
        });

        Intent i = new Intent();
        i.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(i, 1);
    }
}




