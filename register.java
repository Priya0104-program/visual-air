package com.example.visual_air;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;


public class register extends AppCompatActivity implements TextToSpeech.OnInitListener {
    EditText  name,phoneno;
    Toast toast;
    TextView reg, log, ink, fname, phone, password, dummy1, dummy2,ai,du;
    Button  regi;
    Intent tolog;
    private TextToSpeech tts;
    String s = "", p="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regi = (Button) findViewById(R.id.btnLogin);
        name = (EditText) findViewById(R.id.txtName);
        phoneno = (EditText) findViewById(R.id.ph);
        phone = (TextView) findViewById(R.id.secTxt);
        fname = (TextView) findViewById(R.id.ftxt);
        log = (TextView) findViewById(R.id.loginscrn);

        phone.setMovementMethod(LinkMovementMethod.getInstance());
        phone.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="ENTER PHONE NUMBER HERE ";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        fname.setMovementMethod(LinkMovementMethod.getInstance());
        fname.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="ENTER YOUR NAME HERE";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        log.setMovementMethod(LinkMovementMethod.getInstance());
        log.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="THIS IS REGISTRATION PAGE FILL ALL THE DETAILS GIVEN BELOW";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });




        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = "";
                s = name.getText().toString();
                p = phoneno.getText().toString();
                boolean val = true;


                if (s.equals("")) {
                    String st="please enter your name";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(), "enter the name", Toast.LENGTH_SHORT).show();
                    val = false;
                }
                else if (s.equals(user))
                {
                    String st="User name already exists enter another user name";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(), "user name already exists", Toast.LENGTH_SHORT).show();
                    val = false;
                }
                 else if (p.equals("")) {
                    String st="please enter  phone number";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(), "enter phone number", Toast.LENGTH_SHORT).show();
                    val = false;
                }

                else if (p.length() != 10) {
                    String st="enter correct phone number";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(), "enter correct phone number", Toast.LENGTH_SHORT).show();
                    val = false;

                } else  {
                    String nms, pp;
                    nms = name.getText().toString();
                    pp = phoneno.getText().toString();
                    String str="REGISTRATION SUCCESSFUL";
                    Intent in=new Intent(register.this,bpage.class);
                    startActivity(in);
                    Toast.makeText(getApplicationContext(), " registration successful ", Toast.LENGTH_SHORT).show();
                }


            }
        });
        Intent i = new Intent();
        i.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                tts = new TextToSpeech(this, this);
            } else {
                Intent i = new Intent();
                i.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(i);
            }
        }
    }

    public void tts(String text) {

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);

    }

    @SuppressWarnings("deprecation")
    public void ttsUnder20(String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void ttsGreater21(String text) {
        String utteranceId = this.hashCode() + "";
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }


    @Override
    public void onInit(int status) {
        // TODO Auto-generated method stub
        if (status == TextToSpeech.SUCCESS) {
            int f = 1;
        }
        if (status == TextToSpeech.ERROR) {
            int f = 0;
        }
    }

}



