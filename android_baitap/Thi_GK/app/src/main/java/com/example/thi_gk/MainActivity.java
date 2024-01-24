package com.example.thi_gk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

class AdapterNhanVien extends ArrayAdapter<Nhanvien>{
        private ArrayList<Nhanvien> nhanViens;
        public  AdapterNhanVien(Context context, ArrayList<Nhanvien> nhanViens){
            super(context, 0,nhanViens);
            this.nhanViens=nhanViens;
        }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
           // itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_nhanvien, parent, false);
            itemView =LayoutInflater.from(getContext()).inflate(R.layout.activity_main,parent,false);
        }
        Nhanvien nhanVien = nhanViens.get(position);

        TextView txtMsnv = itemView.findViewById(R.id.txtMsnv);
        TextView txtTen = itemView.findViewById(R.id.txtTen);
        TextView txtHesoluong = itemView.findViewById(R.id.txtHesoluong);
        TextView txtGioitinh = itemView.findViewById(R.id.txtGioitinh);

        txtMsnv.setText(nhanVien.getMsnv());
        txtTen.setText(nhanVien.getTen());
        txtHesoluong.setText(nhanVien.getHesoluong());
        txtGioitinh.setText(nhanVien.isGioitinh()?"nam":"Nữ");

        return itemView;
    }
}

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private AdapterNhanVien adapterNhanVien;
    private ArrayList<Nhanvien> nhanViens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        nhanViens = new ArrayList<>();

        // Thêm dữ liệu vào danh sách nhân viên
        nhanViens.add(new Nhanvien("NV001", "Nguyen Van A", 1, true));
        nhanViens.add(new Nhanvien("NV002", "Tran Thi B", 2, false));
        // Thêm các nhân viên khác vào danh sách

        adapterNhanVien = new AdapterNhanVien(this,nhanViens);
        listView.setAdapter(adapterNhanVien);
    }
}

