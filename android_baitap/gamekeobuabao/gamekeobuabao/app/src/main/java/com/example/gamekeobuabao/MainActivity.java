package com.example.gamekeobuabao;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class  MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btkeo,btbua,btgiay,bthoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btkeo = findViewById(R.id.btkeo);
        btbua = findViewById(R.id.btbua);
        btgiay = findViewById(R.id.btgiay);
        bthoat = findViewById(R.id.btthoat);

        btkeo.setOnClickListener(this);
        btbua.setOnClickListener(this);
        btgiay.setOnClickListener(this);
        bthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }



    @Override
    public void onClick(View v) {
        String user = "";
        if (v.getId() == R.id.btkeo){
            user = "keo";
        }else if(v.getId() == R.id.btbua){
            user = "bua";
        } else if (v.getId()==R.id.btgiay) {
            user = "giay";
        }
        Intent myint = new Intent(MainActivity.this,ResultActivity.class);
        myint.putExtra("BANRA",user);
        startActivity(myint);
    }
}