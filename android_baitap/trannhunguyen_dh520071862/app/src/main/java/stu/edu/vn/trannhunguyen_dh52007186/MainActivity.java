package stu.edu.vn.trannhunguyen_dh52007186;

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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import stu.edu.vn.trannhunguyen_dh52007186.Adapter.AdapterSach;
import stu.edu.vn.trannhunguyen_dh52007186.dao.DBHelper;
import stu.edu.vn.trannhunguyen_dh52007186.model.Sach;

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
        helper.QueryData(DBHelper.SQL_Create_Table);
        addEvents();
        hienthisach();
    }

    private void addControls() {
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


    private void addEvents() {
        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent,requestcode);
            }
        });
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
    protected void onDestroy() {
        helper.close();
        super.onDestroy();
    }
}