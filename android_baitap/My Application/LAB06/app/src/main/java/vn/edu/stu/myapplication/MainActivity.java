package vn.edu.stu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import vn.edu.stu.myapplication.model.DatPhong;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<DatPhong> adapter;
    ListView lvDatPhong;
    FloatingActionButton fabThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();

    }
    @Override
    protected void onResume(){
        super.onResume();
        if(adapter != null){
            adapter.notifyDataSetChanged();
        }
    }
    public void  addControls(){
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, DuLieu.dsDatPhong);
        lvDatPhong = findViewById(R.id.lvDatPhong);
        lvDatPhong.setAdapter(adapter);
        fabThem = findViewById(R.id.fabThem);
        registerForContextMenu(lvDatPhong);
    }
    public void addEvents() {
        fabThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, DatPhongActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mnu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnuThem) {
            Intent intent = new Intent(MainActivity.this, DatPhongActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.mnuThoat) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId()== R.id.lvDatPhong) {
            getMenuInflater().inflate(R.menu.mnu_datphong, menu);
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;

        if (item.getItemId() == R.id.mnuSua) {
            Intent intent = new Intent(MainActivity.this, DatPhongActivity.class);
            intent.putExtra("INDEX", index);
            startActivity(intent);
        } else if (item.getItemId() == R.id.mnuXoa) {
            DuLieu.xoaDatPhong(index);
            adapter.notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);
    }
}