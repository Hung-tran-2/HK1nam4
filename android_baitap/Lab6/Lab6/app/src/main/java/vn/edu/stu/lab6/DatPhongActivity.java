package vn.edu.stu.lab6;


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

import vn.edu.stu.lab6.model.DatPhong;
import vn.edu.stu.lab6.util.FormatUtil;
import vn.edu.stu.lab6.util.RandomUtil;

public class DatPhongActivity extends MainActivity {
    TextView txtMa, txtNgayDat;
    EditText txtTenNguoiDat, txtSoDem;
    ImageButton btnDatePicker;
    Button btnLuu;
    Calendar calendar;
    DatPhong chon;

    protected void onCreate(Bundle savedInstanceState, int oneDay) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_phong);
        addControls();
        addEvents(oneDay);
    }
    private void addControls() {
        txtMa = findViewById(R.id.txtMa);
        txtNgayDat = findViewById(R.id.txtNgayDat);
        txtTenNguoiDat =findViewById(R.id.txtTenNguoiDat);
        txtSoDem = findViewById(R.id.txtSoDem);
        btnDatePicker = findViewById(R.id.btnDatePicker);
        btnLuu = findViewById(R.id.btnLuu);
        calendar = Calendar.getInstance();
        chon = null;
    }
    private void getIntentData() {
        Intent intent = getIntent();
        if (intent.hasExtra("INDEX")) {
            int index = intent.getIntExtra("INDEX", -1);
            chon = DuLieu.layDatPhong(index);
        }
        if(chon!=null) {
            txtMa.setText(chon.getMa());
            txtTenNguoiDat.setText(chon.getTenNguoiDat());
            calendar.setTime(chon.getNgayDat ());
            txtNgayDat.setText(FormatUtil.formatDate(chon.getNgayDat()));
            txtSoDem.setText(chon.getSoDem() +"");
        } else {
            txtMa.setText(RandomUtil.getAphaNumericString(8));
            txtTenNguoiDat.requestFocus();
            calendar.add(Calendar.DATE, 2);
        }
    }
    private void addEvents (int oneDay) {
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyChonNgay(oneDay);
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyLuu();
            }
        });
    }
    private void xuLyChonNgay (int oneDay) {
        DatePickerDialog.OnDateSetListener listener =
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DATE, dayOfMonth);
                        txtNgayDat.setText(FormatUtil.formatDate(
                                calendar.getTime())
                        );
                    }
                };
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                DatPhongActivity.this,
                listener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE)
        );
        long onDay = 24 * 60 * 60 * 1000L;
        datePickerDialog.getDatePicker().setMinDate(
                System.currentTimeMillis() + 2 * oneDay);
        datePickerDialog.show();
    }
    private void xuLyLuu () {
        if (chon !=null) {
            chon.setTenNguoiDat(txtTenNguoiDat.getText().toString());
            chon.getNgayDat();
            chon.setSoDem(Integer.parseInt(txtSoDem.getText().toString()));
        } else {
            chon = new DatPhong();
            chon.setMa(txtMa.getText().toString());
            chon.getNgayDat();
            chon.setSoDem(Integer.parseInt(txtSoDem.getText().toString()));
            DuLieu.themDatPhong(chon);
        }
        finish();
    }
}

