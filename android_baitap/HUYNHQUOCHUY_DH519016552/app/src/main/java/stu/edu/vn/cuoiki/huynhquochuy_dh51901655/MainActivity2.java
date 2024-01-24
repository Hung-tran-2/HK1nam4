package stu.edu.vn.cuoiki.huynhquochuy_dh51901655;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import stu.edu.vn.cuoiki.huynhquochuy_dh51901655.dao.DBHelper;
import stu.edu.vn.cuoiki.huynhquochuy_dh51901655.model.sanpham;

public class MainActivity2 extends AppCompatActivity {



    DBHelper helper;
    EditText txtma, txtten, txtgia, txtnam;
    Button btnLuu;
    sanpham chon;

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
        txtgia = findViewById(R.id.edit_gia);
        txtnam = findViewById(R.id.edit_nambaohanh);

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
            chon = (sanpham) intent.getSerializableExtra("CHON");

            if(chon !=null)
            {
                txtma.setText(chon.getMasp().toString());
                txtten.setText(chon.getTensp().toString());
                txtgia.setText(chon.getGia()+"");
                txtnam.setText(chon.getNam()+"");
            }
        }
    }

    private void xulyluu()
    {
        if(chon == null)
        {
            chon = new sanpham();
        }
        chon.setMasp((txtma.getText().toString()));
        chon.setTensp(txtten.getText().toString());
        chon.setGia(Float.parseFloat(txtgia.getText().toString()));
        chon.setNam(Integer.parseInt(txtnam.getText().toString()));



        Intent intent = getIntent();
        intent.putExtra("TRA", chon);
        setResult(requestcode, intent);
        finish();
    }



}