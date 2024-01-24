package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void xulymotpha(View view){
        Intent intent =new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }
    public void xuLytoanphan(View view){
        Intent intent =new Intent(MainActivity.this, MainActivity3.class);
        startActivity(intent);
    }
    public void xuLythoat(View view){
        finish();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(MainActivity.this,
                "onStart được gọi",
                Toast.LENGTH_SHORT).show();
    }
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(MainActivity.this,
                "onRestart được gọi",
                Toast.LENGTH_SHORT).show();
    }
    protected void onStop(){
        super.onStop();
        Toast.makeText(MainActivity.this,
                "onStop được gọi",
                Toast.LENGTH_SHORT).show();
    }
    protected void onPause(){
        super.onPause();
        Toast.makeText(MainActivity.this,
                "onPause được gọi",
                Toast.LENGTH_SHORT).show();
    }
    protected void onResume(){
        super.onResume();
        Toast.makeText(MainActivity.this,
                "onResume được gọi",
                Toast.LENGTH_SHORT).show();
    }
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(MainActivity.this,
                "onStart được gọi",
                Toast.LENGTH_SHORT).show();
    }
}