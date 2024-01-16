package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sqlite.dao.DBHelper;
import com.example.sqlite.model.Sach;

public class MainActivity2 extends AppCompatActivity {

    DBHelper helper;
    EditText txtten, txttacgia, txtnamxb;
    Button btnLuu;
    Sach chon;


    int requestcode = 115;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addControls();
        addEvents();
        getIntentData();

    }


    private void addControls()
    {
        txtten = findViewById(R.id.edit_ten);
        txttacgia = findViewById(R.id.edit_tacgia);
        txtnamxb = findViewById(R.id.edit_namxb);
        btnLuu = findViewById(R.id.btnLuu);
        helper = new DBHelper(MainActivity2.this);
    }

    private void addEvents()
    {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyluu();
            }
        });
    }

    private void getIntentData()
    {
        Intent intent = getIntent();
        if(intent.hasExtra("CHON"))
        {
            chon = (Sach) intent.getSerializableExtra("CHON");

            if(chon !=null)
            {
                txtten.setText(chon.getTen().toString());
                txttacgia.setText(chon.getTacgia().toString());
                txtnamxb.setText(chon.getNamxuatban()+"");
            }
        }
    }

    private void xulyluu()
    {
        if(chon == null)
        {
            chon = new Sach();
        }
        chon.setTen(txtten.getText().toString());
        chon.setTacgia(txttacgia.getText().toString());
        chon.setNamxuatban(Integer.parseInt(txtnamxb.getText().toString()));
        Intent intent = getIntent();
        intent.putExtra("TRA", chon);
        setResult(requestcode, intent);
        finish();
    }
}