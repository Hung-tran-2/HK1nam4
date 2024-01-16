package com.example.sqlite;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlite.Adapter.AdapterSach;
import com.example.sqlite.dao.DBHelper;
import com.example.sqlite.model.Sach;
import com.example.sqlite.util.DBConfigUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    FloatingActionButton fa;
    ListView listView;
    DBHelper helper;
    Toolbar toolbar;
    List<Sach> listsach =new ArrayList<>();

    AdapterSach adapter;
    Sach chon;

    int requestcode = 113, resultcode =115;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        helper = new DBHelper(MainActivity.this);
//
//        helper.QueryData(DBHelper.Drop_table);
//        helper.QueryData(DBHelper.SQL_Create_Table);
//        Sach s = new Sach("A","An",1994);
//        helper.insertSach(s);
//        Sach s1 = new Sach("B","An",1994);
//        helper.insertSach(s1);


//        List<Sach> list = new ArrayList<>();
//        list = helper.getAllSach();
//        for (int i=0; i<list.size();i++)
//        {
//            Toast.makeText(this, list.get(i).getTen(),Toast.LENGTH_SHORT).show();
//        }
        addEvents();
        hienthisach();

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
    private void addControls()
    {
        fa = findViewById(R.id.faThem);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.lvQlsach);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.lvQlsach)
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
            helper.deleteSach(chon.getMa()+"");
            hienthisach();
       }

        return super.onContextItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == this.requestcode)
        {
            if(data.hasExtra("TRA")) {
                Sach s = (Sach) data.getSerializableExtra("TRA");
                if (s.getMa() == 0) {
                    helper.insertSach(s);
                } else {
                    helper.updateSach(s);
                }
                hienthisach();
            }
        }

    }

    private void hienthisach() {
        listsach = (ArrayList<Sach>) helper.getAllSach();
        adapter = new AdapterSach(
                MainActivity.this,
                R.layout.item_sach,
                listsach,
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