package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.API.ApiSevice;
import com.example.myapplication.model.HangHoa;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HangHoaActivity extends AppCompatActivity {
    private EditText edtLoaiHangHoa;
    private Button btnGetData;
    HangHoaAdapter adapter;
    private  List<HangHoa> hangHoaList;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hanghoa);
        AddControl();
        addEvent();
    }
    public void AddControl(){
        edtLoaiHangHoa = findViewById(R.id.edtLoaiHangHoa);
        btnGetData = findViewById(R.id.btnGetData);
        listView = findViewById(R.id.listView);
    }
    public void addEvent(){
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromWebService(edtLoaiHangHoa.getText().toString());
            }
        });
    }
    private void getDataFromWebService(String loaiHangHoa) {
        Call<List<HangHoa>> call = ApiSevice.API_SEVICE.getHangHoaList(loaiHangHoa);
        call.enqueue(new Callback<List<HangHoa>>() {
            @Override
            public void onResponse(Call<List<HangHoa>> call, Response<List<HangHoa>> response) {
                if (response.isSuccessful()) {
                    List<HangHoa> hangHoaList = response.body();
                    displayDataOnListView(hangHoaList);
                } else {
                    showToast("Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<HangHoa>> call, Throwable t) {
                showToast("Failure: " + t.getMessage());
            }
        });
    }
    private void displayDataOnListView(List<HangHoa> hangHoaList) {
        adapter = new HangHoaAdapter(this, hangHoaList);
        listView.setAdapter(adapter);
        showToast("JSON Response: " + new Gson().toJson(hangHoaList));
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
