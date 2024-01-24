 package com.example.ontap;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ontap.Adapter.AdapterSinhVien;
import com.example.ontap.DAO.DBHelper;
import com.example.ontap.Model.baihat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {
     FloatingActionButton fabThem;
     ArrayAdapter<baihat> adapter;
     ListView lvSv;
     baihat sv;
     ArrayList<baihat> dsSbaihat;
     DBHelper helper;
     int requestcode=113;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();

        addEvents();
        helper = new DBHelper(MainActivity.this);
        hienthiSV();
    }

     private void addControls() {
         fabThem = findViewById(R.id.fabThem);
         //toolbar = (Toolbar) findViewById(R.id.toolbar);
         //setSupportActionBar(toolbar);
         lvSv = findViewById(R.id.lvsinhvien);
         registerForContextMenu(lvSv);
     }

     private void addEvents() {

     }

     private void hienthiSV() {

     }


 }