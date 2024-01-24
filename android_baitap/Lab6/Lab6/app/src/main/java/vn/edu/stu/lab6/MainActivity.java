package vn.edu.stu.lab6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import vn.edu.stu.lab6.model.DatPhong;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<DatPhong> adapter;
    ListView lvDatPhong;
    FloatingActionButton fabThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabThem = (FloatingActionButton) findViewById(R.id.fabThem);
        addControls();
        addEvents();
    }

    protected void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    private void addControls() {
        adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                DuLieu.dsDatPhong);
        lvDatPhong = findViewById(R.id.lvDatPhong);
        lvDatPhong.setAdapter(adapter);
        fabThem = findViewById(R.id.fabThem);
        registerForContextMenu(lvDatPhong);
    }


    private void addEvents() {
        fabThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this,
                        DatPhongActivity.class
                );
                startActivity(intent);
            }
        });
    }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mnu_main, menu);
        return super.onCreateOptionsMenu(menu);

   }

    public boolean onOptionsItemSelected(MenuItem item ) {
        if (item.getItemId() == R.id.mnuThem) {
            Intent intent = new Intent(
                    MainActivity.this,
                    DatPhongActivity.class
            );
            startActivity(intent);

        }
        else{
                finish();
               System.exit(0);
 }
        return super.onOptionsItemSelected(item);
    }
    public void onCreateContextMenu(ContextMenu menu, View v ,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if ((v.getId() == R.id.lvDatPhong)) {
            getMenuInflater().inflate(R.menu.mnu_datphong, menu);
        }
    }
    public boolean onConTextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        if(item.getItemId() ==R.id.mnuSua) {
            Intent intent = new Intent(
                    MainActivity.this,
                    DatPhongActivity.class
            );
            intent.putExtra("INDEX", index);
            startActivity(intent);
            Log.d("MainActivity", "Context menu item Sua selected");
        }
        else{

                DuLieu.xoaDatPhong(index);
                adapter.notifyDataSetChanged();
                Log.d("MainActivity", "Context menu item Xoa selected");

        }
        return super.onContextItemSelected(item);
    }
}