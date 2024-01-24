package com.example.quanlymaytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quanlymaytinh.dao.DBHelper;
import com.example.quanlymaytinh.model.MayTinh;

public class MainActivity2 extends AppCompatActivity {


    DBHelper helper;
    EditText txtmamay, txttenmay, txtsoluong, txtngiatien;
    Button btnLuu;
    MayTinh chon;
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
        txtmamay = findViewById(R.id.edit_ma);
        txttenmay = findViewById(R.id.edit_ten);
        txtsoluong = findViewById(R.id.edit_soluong);
        txtngiatien = findViewById(R.id.edit_giatien);


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
            chon = (MayTinh) intent.getSerializableExtra("CHON");

            if(chon !=null)
            {
                txtmamay.setText(chon.getTenMay()+"");
                txttenmay.setText(chon.getTenMay().toString());
                txtsoluong.setText(chon.getSoLuong()+"");
                txtngiatien.setText(chon.getGiaTien()+"");
            }
        }
    }



    private void xulyluu()
    {
        if(chon == null)
        {
            chon = new MayTinh();
        }

        chon.setMaMay(Integer.parseInt(txtmamay.getText().toString()));
        chon.setTenMay(txttenmay.getText().toString());
        chon.setSoLuong(Integer.parseInt(txtsoluong.getText().toString()));
        chon.setGiaTien(Float.parseFloat(txtngiatien.getText().toString()));


        Intent intent = getIntent();
        intent.putExtra("TRA", chon);
        setResult(requestcode, intent);
        finish();
    }
}