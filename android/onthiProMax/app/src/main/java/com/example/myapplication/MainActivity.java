package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.myapplication.API.ApiSevice;
import com.example.myapplication.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText Username;
    EditText Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddControl();
        AddEvent();
    }
    private void loginUser(String username, String password) {
        Call<LoginResponse> call = ApiSevice.API_SEVICE.login(username, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse != null && loginResponse.isResult()) {
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        goToHangHoaActivity();
                    } else {
                        Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Đã ccccccc ra lỗi", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String errorMessage = "Đã xảy ra lỗi: " + t.getMessage();
                Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                t.printStackTrace(); // In chi tiết lỗi vào LogCat để kiểm tra
            }
        });
    }
    public  void AddControl(){
        btnLogin=findViewById(R.id.buttonLogin);
        Username=findViewById(R.id.editTextUsername);
        Password=findViewById(R.id.editTextPassword);
    }
    public void AddEvent(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = String.valueOf(Username.getText());
                String pass = String.valueOf(Password.getText());
                // Thực hiện đăng nhập khi nút đăng nhập được nhấn
                loginUser(login, pass);
            }
        });
    }
    private void goToHangHoaActivity() {
        Intent intent = new Intent(MainActivity.this, HangHoaActivity.class);
        startActivity(intent);
    }
}
