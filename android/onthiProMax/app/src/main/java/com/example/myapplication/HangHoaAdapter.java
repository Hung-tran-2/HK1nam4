package com.example.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.model.HangHoa;
import com.example.myapplication.R;

import java.util.List;

public class HangHoaAdapter extends ArrayAdapter<HangHoa> {

    public HangHoaAdapter(Context context, List<HangHoa> hangHoaList) {
        super(context, 0, hangHoaList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Kiểm tra xem convertView đã được tái sử dụng chưa, nếu không, inflate lại
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_hanghoa, parent, false);
        }

        // Lấy đối tượng HangHoa ở vị trí hiện tại
        HangHoa hangHoa = getItem(position);

        // Ánh xạ các thành phần trong layout item_hanghoa
        TextView txtMa = convertView.findViewById(R.id.txtMa);
        TextView txtTen = convertView.findViewById(R.id.txtTen);
        TextView txtGia = convertView.findViewById(R.id.txtGia);

        // Gán dữ liệu vào các thành phần
        txtMa.setText("Mã: " + hangHoa.getMa());
        txtTen.setText("Tên: " + hangHoa.getTen());
        txtGia.setText("Giá: " + hangHoa.getGia());

        return convertView;
    }
}
