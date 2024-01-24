package com.example.quanlybaihat_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlybaihat_sqlite.dao.DBHelper;
import com.example.quanlybaihat_sqlite.model.baihat;

public class MainActivity2 extends AppCompatActivity {

    DBHelper helper;
    EditText txtma, txtten, txttacgia, txtthoiluong;
    Button btnLuu;
    baihat chon;


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
        txtma   =  findViewById(R.id.edit_ma);
        txtten = findViewById(R.id.edit_ten);
        txttacgia = findViewById(R.id.edit_tacgia);
        txtthoiluong = findViewById(R.id.edit_thoiluong);

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
            chon = (baihat) intent.getSerializableExtra("CHON");

            if(chon !=null)
            {
                txtma.setText(chon.getMa().toString());
                txtten.setText(chon.getTen().toString());
                txttacgia.setText(chon.getTacgia().toString());
                txtthoiluong.setText(chon.getThoiluong()+"");
            }
        }
    }

    private void xulyluu()
    {
        if(chon == null)
        {
            chon = new baihat();
        }
        chon.setMa((txtma.getText().toString()));
        chon.setTen(txtten.getText().toString());
        chon.setTacgia(txttacgia.getText().toString());
        chon.setThoiluong(Integer.parseInt(txtthoiluong.getText().toString()));



        Intent intent = getIntent();
        intent.putExtra("TRA", chon);
        setResult(requestcode, intent);
        finish();
    }
}