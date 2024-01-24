package stu.edu.vn.cuoiki.huynhquochuy_dh51901655;

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

import stu.edu.vn.cuoiki.huynhquochuy_dh51901655.adapter.adaptersanpham;
import stu.edu.vn.cuoiki.huynhquochuy_dh51901655.dao.DBHelper;
import stu.edu.vn.cuoiki.huynhquochuy_dh51901655.model.sanpham;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fa;
    ListView listView;
    DBHelper helper;
    Toolbar toolbar;
    List<sanpham> listsanpham = new ArrayList<>();

    adaptersanpham adapter;
    sanpham chon;

    int requestcode = 113, resultcode = 115;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DBHelper(MainActivity.this);
        helper.QueryData(DBHelper.SQL_Create_Table);


        addControls();
        addEvents();
        hienthisanpham();
    }


    private void addControls() {
        fa = findViewById(R.id.faThem);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.lvQlsanpham);
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
        if (v.getId() == R.id.lvQlsanpham) {
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
            intent.putExtra("chon", chon);
            startActivityForResult(intent, requestcode);
        } else if (item.getItemId() == R.id.btnXoa) {
            chon = adapter.getItem(index);
            helper.deletesanpham(chon.getMasp() + "");
            hienthisanpham();
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.requestcode) {

            if (data.hasExtra("TRA")) {
                sanpham s = (sanpham) data.getSerializableExtra("TRA");

                helper.insertsanpham(s);
                helper.updatesanpham(s);

            }
            hienthisanpham();
        }
    }



    private void hienthisanpham() {
        listsanpham = (ArrayList<sanpham>) helper.getAllsanpham();
        adapter = new adaptersanpham(
                MainActivity.this,
                R.layout.item_sanpham,
                listsanpham,
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