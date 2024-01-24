package com.example.quanlymaytinh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.quanlymaytinh.adapter.adapterMaytinh;
import com.example.quanlymaytinh.dao.DBHelper;
import com.example.quanlymaytinh.model.MayTinh;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fa;
    ListView listView;
    DBHelper helper;
    Toolbar toolbar;
    List<MayTinh> listmaytinh =new ArrayList<>();

    adapterMaytinh adapter;
    MayTinh chon;

    int i=0;

    int requestcode = 113, resultcode =115;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        helper = new DBHelper(MainActivity.this);
        helper.QueryData(DBHelper.SQL_Create_Table);


//        MayTinh s = new MayTinh("aa","A",20,94);
//        helper.insertMaytinh(s);



        addControls();
        addEvents();
        hienthimaytinh();
    }
    private void addControls()
    {
        fa = findViewById(R.id.faThem);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.lvQLMaytinh);
        registerForContextMenu(listView);
    }


    private void addEvents()
    {
        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent,requestcode);
            }
        });
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.lvQLMaytinh)
        {
            getMenuInflater().inflate(R.menu.context_menu, menu);
        }

    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        if(item.getItemId() == R.id.btnSua)
        {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            chon =adapter.getItem(index);
            intent.putExtra("CHON",  chon);
            startActivityForResult(intent, requestcode );
        }
        else if (item.getItemId() == R.id.btnXoa)
        {
            chon = adapter.getItem(index);
            helper.deleteMaytinh(chon.getMaMay()+"");
            hienthimaytinh();
        }

        return super.onContextItemSelected(item);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        for (int i = 0; i < listmaytinh.size(); i++) {
            if (requestCode == this.requestcode) {
                if (data.hasExtra("TRA")) {
                    MayTinh s = (MayTinh) data.getSerializableExtra("TRA");
                    if (s.getMaMay() != 0) {
                        helper.insertMaytinh(s);
                    }
                    helper.updateMaytinh(s);




//                    if (s.getMaMay().equals(listmaytinh.get(i).getMaMay())) {
//                        helper.updateMaytinh(s);
//                    } else {
//                        helper.insertMaytinh(s);
//                    }
                }
                hienthimaytinh();
            }
        }
//    }


    private void hienthimaytinh() {
        listmaytinh = (ArrayList<MayTinh>) helper.getAllMaytinh();
        adapter = new adapterMaytinh(
                MainActivity.this,
                R.layout.item_maytinh,
                listmaytinh,
                helper
        );
        listView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        helper.close();
        super.onDestroy();
    }

}