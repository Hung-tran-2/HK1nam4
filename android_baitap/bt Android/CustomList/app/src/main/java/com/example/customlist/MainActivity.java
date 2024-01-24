package com.example.customlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView lv;
ModelAdapter mda;
ArrayList<Model> am;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.dathang);
        am = new ArrayList<>();
        am.add(new Model("mon hang 0", "1000", "10"));
        am.add(new Model("mon hang 0", "1000", "10"));
        am.add(new Model("mon hang 0", "1000", "10"));
        am.add(new Model("mon hang 0", "1000", "10"));
        am.add(new Model("mon hang 0", "1000", "10"));
        am.add(new Model("mon hang 0", "1000", "10"));
        am.add(new Model("mon hang 0", "1000", "10"));
        am.add(new Model("mon hang 0", "1000", "10"));
        am.add(new Model("mon hang 0", "1000", "10"));
        am.add(new Model("mon hang 0", "1000", "10"));
        am.add(new Model("mon hang 0", "1000", "10"));
        mda = new ModelAdapter(this,0, am);
        lv.setAdapter(mda);
    }
}