package vn.edu.stu.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import vn.edu.stu.myapplication.adapter.NhanVienAdapter;
import vn.edu.stu.myapplication.model.NhanVien;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private ArrayList<NhanVien> nhanVienList;
    private NhanVienAdapter nhanVienAdapter;
    private ListView listView;
    private FloatingActionButton btnThem;

    private static final int REQUEST_CODE_THEM_NHANVIEN = 1;
    private static final int REQUEST_CODE_SUA_NHANVIEN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        nhanVienList = new ArrayList<>();
        listView = findViewById(R.id.listView);
        btnThem = findViewById(R.id.btnThem);

        registerForContextMenu(listView);



        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThemNhanVienActivity.class);
                startActivityForResult(intent, REQUEST_CODE_THEM_NHANVIEN);
            }
        });

        loadNhanVienList();
    }

    private void loadNhanVienList() {
        nhanVienList = databaseHelper.getNhanVienList();
        nhanVienAdapter = new NhanVienAdapter(this, nhanVienList);
        listView.setAdapter(nhanVienAdapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        int itemId = item.getItemId();

        if (itemId == R.id.menu_sua) {
            NhanVien selectedNhanVien = nhanVienList.get(position);
            openSuaNhanVienActivity(selectedNhanVien, position);
            return true;

        } else if (itemId == R.id.menu_xoa) {
            showDeleteConfirmationDialog(position);
            return true;

        } else {
            return super.onContextItemSelected(item);
        }
    }


    private void openSuaNhanVienActivity(NhanVien nhanVien, int position) {
        Intent intent = new Intent(MainActivity.this, ThemNhanVienActivity.class);
        intent.putExtra("nhanVien", nhanVien);
        intent.putExtra("position", position);
        startActivityForResult(intent, REQUEST_CODE_SUA_NHANVIEN);
    }

    private void showDeleteConfirmationDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận xoá");
        builder.setMessage("Bạn có chắc chắn muốn xoá nhân viên này?");

        builder.setPositiveButton("Xoá", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NhanVien deletedNhanVien = nhanVienList.get(position);
                deleteNhanVien(deletedNhanVien, position);
            }
        });

        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    private void deleteNhanVien(NhanVien nhanVien, int position) {
        long result = databaseHelper.deleteNhanVien(nhanVien.getMaNV());
        if (result != -1) {
            nhanVienList.remove(position);
            nhanVienAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Xoá nhân viên thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Xoá nhân viên thất bại", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_THEM_NHANVIEN && resultCode == RESULT_OK) {
            String tenNV = data.getStringExtra("tenNV");
            boolean gioiTinh = data.getBooleanExtra("gioiTinh", false);

            int maNV = nhanVienList.size() + 1;

            NhanVien newNhanVien = new NhanVien(maNV, tenNV, gioiTinh);
            long result = databaseHelper.addNhanVien(newNhanVien);

            if (result != -1) {
                nhanVienList.add(newNhanVien);
                nhanVienAdapter.notifyDataSetChanged();
                Toast.makeText(this, "Thêm nhân viên thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Thêm nhân viên thất bại", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_CODE_SUA_NHANVIEN && resultCode == RESULT_OK) {
            String tenNV = data.getStringExtra("tenNV");
            boolean gioiTinh = data.getBooleanExtra("gioiTinh", false);
            int position = data.getIntExtra("position", -1);

            if (position != -1) {
                NhanVien editedNhanVien = nhanVienList.get(position);
                editedNhanVien.setTenNV(tenNV);
                editedNhanVien.setGioiTinh(gioiTinh);

                long result = databaseHelper.updateNhanVien(editedNhanVien);
                if (result != -1) {
                    nhanVienAdapter.notifyDataSetChanged();
                    Toast.makeText(this, "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Cập nhật thông tin thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}