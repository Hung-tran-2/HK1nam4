package stu.edu.vn.thicuoiki;

import static stu.edu.vn.thicuoiki.ApiService.API_SERVICE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import stu.edu.vn.thicuoiki.Adapter.SachAdapter;
import stu.edu.vn.thicuoiki.module.Sach;

public class MainActivity extends AppCompatActivity {
    EditText ed_ten;
    ListView listView;
    Button button;
    List<Sach> dsll = new ArrayList<>();
    SachAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontrol();
        getAllPhongban();
    }
    private void addcontrol(){
        button = findViewById(R.id.button_them);
        listView = findViewById(R.id.lvsach);
        ed_ten = findViewById(R.id.editText_Ten);
    }
    public void getAllPhongban (){
        Call<List<Sach>> call = API_SERVICE.getall();
        call.enqueue(new Callback<List<Sach>>() {
            @Override
            public void onResponse(Call<List<Sach>> call, Response<List<Sach>> response) {
                if (response.isSuccessful()) {
                    dsll = response.body();
                    hienthiDanhsach();
                } else {
                    Toast.makeText(MainActivity.this, "Không thể lấy danh sách", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Sach>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Không thể kết nối", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void hienthiDanhsach() {
        adapter = new SachAdapter(MainActivity.this, R.layout.item_sach, dsll);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}