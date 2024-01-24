package com.example.ontap.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.ontap.DAO.DBHelper;
import com.example.ontap.Model.baihat;
import com.example.ontap.R;

public class AdapterSinhVien extends ArrayAdapter<baihat> {
    Activity context;
    int resource;
    List<baihat> objects ;
    DBHelper helper;

    public AdapterSinhVien(Activity context, int resource, List<baihat> objects, DBHelper helper) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.helper = helper;

    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)this.context.getLayoutInflater();
        View view = inflater.inflate(this.resource, null);

        TextView ma =view.findViewById(R.id.txtMa);
        TextView ten =view.findViewById(R.id.txtTen);
        TextView tacgia =view.findViewById(R.id.txtTacgia);
        TextView thoiluong =view.findViewById(R.id.txtThoiLuong);
        final baihat baihat = objects.get(position);
        ma.setText(baihat.getMa()+"");
        ten.setText(baihat.getTen());
        tacgia.setText(baihat.getTacgia());
        thoiluong.setText(baihat.getThoiluong()+"");
        return view;
    }
}