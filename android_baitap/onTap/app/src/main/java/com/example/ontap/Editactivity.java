package com.example.ontap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.ontap.Model.baihat;

public class Editactivity extends AppCompatActivity {
    EditText txtMa, txtTen;
    RadioButton rdbNam, rdbNu;
    Button btnLuu;
    int resultCode=115;
    baihat sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        onControllers();
        onEvents();
        getIntentData();
    }




    private void onControllers() {
        txtMa=findViewById(R.id.txtMaEdit);
        txtTen=findViewById(R.id.txtTen);
        rdbNam=findViewById(R.id.rdbNam);
        rdbNu=findViewById(R.id.rdbNu);
        btnLuu=findViewById(R.id.btnLuu);
        sv=null;
    }

    private void onEvents() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (sv == null) {
                    sv = new baihat();
                }
                sv.setMa(Integer.parseInt(txtMa.getText().toString()));
                sv.setTen(txtTen.getText().toString());
                if (rdbNam.isChecked()) {
                    sv.setGioiTinh(true);
                } else if (rdbNu.isChecked()) {
                    sv.setGioiTinh(false);
                }
                Log.d("******SinhVienTra", "Mã: " + sv.getMa() + ", Tên: " + sv.getTen() + ", Giới tính: " + (sv.isGioiTinh() ? "Nam" : "Nữ"));
                Intent intent = new Intent();
                intent.putExtra("TRA", sv);
                setResult(115, intent);
                finish();
            }
        });
    }
    private void getIntentData() {
        Intent intent=getIntent();
        if(intent.hasExtra("CHON")){
            sv=(SinhVien)intent.getSerializableExtra("CHON");
            if(sv != null){
                txtMa.setText(String.valueOf(sv.getMa()));
                txtTen.setText(sv.getTen());
                Boolean phai = sv.isGioiTinh();
                if (phai){
                    rdbNam.setChecked(true);
                } else {
                    rdbNu.setChecked(true);
                }
                Log.d("******SinhVienNhan", "Mã: " + sv.getMa() + ", Tên: " + sv.getTen() + ", Giới tính: " + (sv.isGioiTinh() ? "Nam" : "Nữ"));
            } else {
                resetView();
            }
        } else {
            resetView();
        }
    }

    private void resetView() {
        txtTen.setText("");
        txtMa.setText("");
        rdbNam.isFocusedByDefault();
        sv=null;
    }
}