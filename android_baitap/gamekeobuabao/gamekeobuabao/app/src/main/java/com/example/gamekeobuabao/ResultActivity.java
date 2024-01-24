package com.example.gamekeobuabao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    TextView textbanra, textmayra, textKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textbanra = findViewById(R.id.textbanra);
        textmayra = findViewById(R.id.textmayra);
        textKQ = findViewById(R.id.textKQ);

        Intent intent = getIntent();
        if (intent != null) {
            String user = intent.getStringExtra("BANRA");
            String may = MayRandom();
            textmayra.setText("máy ra: "+may);
            textbanra.setText("bạn ra: "+user);
            tinhKQ(user,may);
        }


    }


    public Void tinhKQ(String user, String may) {
        if (user.equals(may)) {
            textKQ.setText("HÒA");
        } else if (user.equals("bua")) {
            if (may.equals("giay")) {
                textKQ.setText("BẠN THUA");
            } else {
                textKQ.setText("BẠN THẮNG");
            }
        } else if (user.equals("giay")) {
            if (may.equals("keo")) {
                textKQ.setText("BẠN THUA");
            } else {
                textKQ.setText("BẠN THẮNG");
            }
        } else if (user.equals("keo")) {
            if (may.equals("bua")) {
                textKQ.setText("BẠN THUA");
            } else {
                textKQ.setText("BẠN THẮNG");
            }
        }
        return null;
    }



    public String MayRandom() {
        String[] imay = {"keo", "bua", "giay"};
        Random rand = new Random();
        int i = rand.nextInt(imay.length);
        return imay[i];
    }


}