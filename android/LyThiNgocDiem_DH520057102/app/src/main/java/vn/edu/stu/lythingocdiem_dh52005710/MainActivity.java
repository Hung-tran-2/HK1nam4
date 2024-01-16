package vn.edu.stu.lythingocdiem_dh52005710;


import static vn.edu.stu.lythingocdiem_dh52005710.APIService.API_SERVICE;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.stu.lythingocdiem_dh52005710.Adapter.AdapterMonHoc;
import vn.edu.stu.lythingocdiem_dh52005710.Model.AddMonHoc;
import vn.edu.stu.lythingocdiem_dh52005710.Model.DeleteMonHoc;
import vn.edu.stu.lythingocdiem_dh52005710.Model.MonHoc;

public class MainActivity extends AppCompatActivity {
    EditText ed_ten;
    Button button_them;
    AdapterMonHoc adapterMonHoc;
    List<MonHoc> dsmh = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontrol();
        getallMonHoc();
        addevent();
    }
    private void addcontrol(){
        ed_ten = findViewById(R.id.editText_tenmonhoc);
        button_them = findViewById(R.id.button);
        listView = findViewById(R.id.lv);

    }
    private void hienthi(){
        adapterMonHoc = new AdapterMonHoc(MainActivity.this,R.layout.item ,dsmh);
        listView.setAdapter(adapterMonHoc);
        adapterMonHoc.notifyDataSetChanged();
    }
    public void getallMonHoc() {
        Call<List<MonHoc>> call = API_SERVICE.getallMonHoc();
        call.enqueue(new Callback<List<MonHoc>>() {
            @Override
            public void onResponse(Call<List<MonHoc>> call, Response<List<MonHoc>> response) {
                if (response.isSuccessful()) {
                    List<MonHoc> apiResponse = response.body();
                    if (apiResponse != null) {
                        dsmh = apiResponse;
                        hienthi();
                    }else {
                        Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<MonHoc>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void themmonhoc(String ten) {
        Call<AddMonHoc> call = API_SERVICE.ThemMonHoc(ten);
        call.enqueue(new Callback<AddMonHoc>() {
            @Override
            public void onResponse(Call<AddMonHoc> call, Response<AddMonHoc> response) {
                if (response.isSuccessful()) {
                    AddMonHoc apiResponse = response.body();
                    if (apiResponse != null) {
                        Toast.makeText(MainActivity.this, apiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        getallMonHoc();
                    }else {
                        Toast.makeText(MainActivity.this, apiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<AddMonHoc> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void xoamonhoc(int id) {
        Call<DeleteMonHoc> call = API_SERVICE.XoaMonHoc(id);
        call.enqueue(new Callback<DeleteMonHoc>() {
            @Override
            public void onResponse(Call<DeleteMonHoc> call, Response<DeleteMonHoc> response) {
                if (response.isSuccessful()) {
                    DeleteMonHoc apiResponse = response.body();
                    if (apiResponse != null) {
                        Toast.makeText(MainActivity.this, apiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, apiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<DeleteMonHoc> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void addevent(){
        button_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenmh = String.valueOf(ed_ten.getText());
                themmonhoc(tenmh);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int ma = dsmh.get(position).getMa();
                xoamonhoc(ma);
                dsmh.remove(position);
                adapterMonHoc.notifyDataSetChanged();
                return true;
            }
        });
    }
}