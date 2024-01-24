package com.example.quanlybaihat_sqlite;

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

import com.example.quanlybaihat_sqlite.Adapter.adapterbaihat;
import com.example.quanlybaihat_sqlite.dao.DBHelper;
import com.example.quanlybaihat_sqlite.model.baihat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton fa;
    ListView listView;
    DBHelper helper;
    Toolbar toolbar;
    List<baihat> listbaihat = new ArrayList<>();

    adapterbaihat adapter;
    baihat chon;

    int requestcode = 113, resultcode = 115;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        helper = new DBHelper(MainActivity.this);
//
//        helper.QueryData(DBHelper.Drop_table);
        helper.QueryData(DBHelper.SQL_Create_Table);


//        baihat s = new baihat("sad","A","An",1994);
//        helper.insertbaihat(s);
//        baihat s1 = new baihat("dsa","B","An",1994);
//        helper.insertbaihat(s1);


//        List<Sach> list = new ArrayList<>();
//        list = helper.getAllSach();
//        for (int i=0; i<list.size();i++)
//        {
//            Toast.makeText(this, list.get(i).getTen(),Toast.LENGTH_SHORT).show();
//        }
        addEvents();
        hienthibaihat();
    }

    private void addControls() {
        fa = findViewById(R.id.faThem);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.lvQlbaihat);
        registerForContextMenu(listView);
    }

    private void addEvents() {
        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent, requestcode);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.lvQlbaihat) {
            getMenuInflater().inflate(R.menu.context_menu, menu);
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        if (item.getItemId() == R.id.btnSua) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            chon = adapter.getItem(index);
            intent.putExtra("CHON", chon);
            startActivityForResult(intent, requestcode);
        } else if (item.getItemId() == R.id.btnXoa) {
            chon = adapter.getItem(index);
            helper.deletebaihat(chon.getMa() + "");
            hienthibaihat();
        }

        return super.onContextItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.requestcode) {

                if (data.hasExtra("TRA")) {
                    baihat s = (baihat) data.getSerializableExtra("TRA");

                    helper.insertbaihat(s);
                    helper.updatebaihat(s);

            }
            hienthibaihat();
        }
    }


    private void hienthibaihat() {
        listbaihat = (ArrayList<baihat>) helper.getAllbaihat();
        adapter = new adapterbaihat(
                MainActivity.this,
                R.layout.itembaihat,
                listbaihat,
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