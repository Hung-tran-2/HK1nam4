package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlite.Adapter.AdapterSach;
import com.example.sqlite.dao.DBHelper;
import com.example.sqlite.model.Sach;
import com.example.sqlite.util.DBConfigUtil;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    DBHelper helper;
    Toolbar toolbar;
    List<Sach> listsach =new ArrayList<>();

    AdapterSach adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    DBConfigUtil.coppyDBfromAsset(MainActivity.this);
        helper = new DBHelper(MainActivity.this);
//
//        helper.QueryData(DBHelper.Drop_table);
        helper.QueryData(DBHelper.SQL_Create_Table);
        Sach s = new Sach("A","An",1994);
        helper.insertSach(s);
        Sach s1 = new Sach("B","An",1994);
        helper.insertSach(s1);


        List<Sach> list = new ArrayList<>();
        list = helper.getAllSach();
        for (int i=0; i<list.size();i++)
        {
            Toast.makeText(this, list.get(i).getTen(),Toast.LENGTH_SHORT).show();
        }

        hienthisach();

    }

    private void addControls()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.lvQlsach);

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
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        helper.close();
        super.onDestroy();
    }
    private void addEven(){

    }
}