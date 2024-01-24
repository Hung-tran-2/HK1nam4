package com.example.DoAn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.doan.R;
import com.example.DoAn.activity.insertdata;
import com.example.DoAn.adapter.AdapterThongTin;
import com.example.DoAn.dao.DatabaseHelper;
import com.example.DoAn.model.ThongTinBanBe;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView lvBanbe;
    ArrayList<ThongTinBanBe> dsBanbe = new ArrayList<>();
    AdapterThongTin adapter;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        hienThi();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 999 && resultCode == 99){
            ThongTinBanBe ttbb = (ThongTinBanBe) data.getSerializableExtra("ttbb");
            dbHelper.insertData(ttbb);
            hienThi();
        } else if (requestCode == 66 && resultCode == 888) {
            ThongTinBanBe ttbb = (ThongTinBanBe) data.getSerializableExtra("ttbb");
            dbHelper.updateData(ttbb.getId() ,ttbb);
            hienThi();
        }
    }

    private void addControls(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvBanbe = findViewById(R.id.listView);
        dbHelper = new DatabaseHelper(MainActivity.this);
    }

    private void hienThi(){
        dsBanbe = (ArrayList<ThongTinBanBe>) dbHelper.getAll();
        adapter = new AdapterThongTin(
                MainActivity.this,
                R.layout.item,
                dsBanbe
        );
        lvBanbe.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.menu, m);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.search){
        } else if (id == R.id.about) {
        } else if (id == R.id.infor) {
        } else if (id == R.id.exit) {
            finish();
        } else if(id == R.id.add){
            Intent intent = new Intent(MainActivity.this, insertdata.class);
            startActivityForResult(intent, 999);
        }
        return true;
    }

}