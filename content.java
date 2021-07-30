package com.example.visual_air;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class content extends AppCompatActivity {
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        back = (Button) findViewById(R.id.cont);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(content.this, fpage.class);
                startActivity(in);
            }
        });
    }
    public void onBackPressed()
    {
        Intent in=new Intent(content.this,fpage.class);
        startActivity(in);
    }
}