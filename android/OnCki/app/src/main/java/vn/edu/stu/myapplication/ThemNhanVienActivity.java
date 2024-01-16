package vn.edu.stu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import vn.edu.stu.myapplication.model.NhanVien;

public class ThemNhanVienActivity extends AppCompatActivity {
    private EditText etTenNV;
    private RadioGroup radioGroup;
    private Button btnLuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhan_vien);

        etTenNV = findViewById(R.id.etTenNV);
        radioGroup = findViewById(R.id.radioGroup);
        btnLuu = findViewById(R.id.btnLuu);

        Intent intent = getIntent();
        if (intent.hasExtra("nhanVien")) {
            NhanVien nhanVien = (NhanVien) intent.getSerializableExtra("nhanVien");
            etTenNV.setText(nhanVien.getTenNV());
            if (nhanVien.isGioiTinh()) {
                radioGroup.check(R.id.rbNam);
            } else {
                radioGroup.check(R.id.rbNu);
            }
        }

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenNV = etTenNV.getText().toString();
                boolean gioiTinh = radioGroup.getCheckedRadioButtonId() == R.id.rbNam;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("tenNV", tenNV);
                resultIntent.putExtra("gioiTinh", gioiTinh);

                // Truyền vị trí của nhân viên trong danh sách để cập nhật thông tin
                if (intent.hasExtra("nhanVien")) {
                    int position = intent.getIntExtra("position", -1);
                    if (position != -1) {
                        resultIntent.putExtra("position", position);
                    }
                }

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}