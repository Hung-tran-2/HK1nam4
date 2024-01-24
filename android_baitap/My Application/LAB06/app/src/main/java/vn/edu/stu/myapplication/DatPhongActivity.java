package vn.edu.stu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Random;


import vn.edu.stu.myapplication.model.DatPhong;
import vn.edu.stu.myapplication.util.FormatUtil;
import vn.edu.stu.myapplication.util.RandomUtil;

public class    DatPhongActivity extends AppCompatActivity {
    TextView txtMa, txtNgayDat;
    EditText txtTenNguoiDat, txtSoDem;
    ImageButton btnDatePicker;
    Button btnLuu;
    Calendar calendar;
    DatPhong chon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_phong);
        addControls();
        getIntentDate();
        addEvents();
    }
    private void addControls(){
        txtMa = findViewById(R.id.txtMa);
        txtNgayDat = findViewById(R.id.txtNgayDat);
        txtTenNguoiDat = findViewById(R.id.txtTenNguoiDat);
        txtSoDem = findViewById(R.id.txtSoDem);
        btnDatePicker = findViewById(R.id.btnDatePicker);
        btnLuu = findViewById(R.id.btnLuu);
        calendar = Calendar.getInstance();
        chon = null;

    }
    private void getIntentDate(){
        Intent intent = getIntent();
        if(intent.hasExtra("INDEX")){
            int index = intent.getIntExtra("INDEX",-1);
            chon = DuLieu.layDatPhong(index);
        }
        if (chon != null){
            txtMa.setText(chon.getMa());
            txtTenNguoiDat.setText(chon.getTenNguoiDat());
            calendar.setTime(chon.getNgayDat());
            txtNgayDat.setText(FormatUtil.formatDate(chon.getNgayDat()));
            txtSoDem.setText(chon.getSoDem() + "");
        }else {
            txtMa.setText(RandomUtil.getAlphaNumericString(8));
            txtTenNguoiDat.requestFocus();
            calendar.add(Calendar.DATE,2);
        }
    }
    private void addEvents(){
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyChonNgay();
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyLuu();
            }
        });
    }
    private void xuLyChonNgay(){
        DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DATE,dayOfMonth);
                txtNgayDat.setText(FormatUtil.formatDate(calendar.getTime()));
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                DatPhongActivity.this,listener,calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE)
        );
        long oneDay = 24*60*60*1000L;
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()+2*oneDay);
        datePickerDialog.show();
    }
    private void xuLyLuu(){
        if(chon != null){
            chon.setTenNguoiDat(txtTenNguoiDat.getText().toString());
            chon.setNgayDat(calendar.getTime());
            chon.setSoDem(Integer.parseInt(txtSoDem.getText().toString()));

        }else {
            chon = new DatPhong();
            chon.setMa(txtMa.getText().toString());
            chon.setTenNguoiDat(txtTenNguoiDat.getText().toString());
            chon.setNgayDat(calendar.getTime());
            chon.setSoDem(Integer.parseInt(txtSoDem.getText().toString()));
            DuLieu.themDatPhong(chon);
        }
        finish();

    }
}