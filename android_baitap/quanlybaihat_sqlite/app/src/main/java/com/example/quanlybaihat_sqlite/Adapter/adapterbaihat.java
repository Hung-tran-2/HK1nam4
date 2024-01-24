package com.example.quanlybaihat_sqlite.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.quanlybaihat_sqlite.R;
import com.example.quanlybaihat_sqlite.dao.DBHelper;
import com.example.quanlybaihat_sqlite.model.baihat;

import java.util.List;

public class adapterbaihat extends ArrayAdapter<baihat> {
    Activity context;
    int res;
    List<baihat> obj;
    DBHelper helper;


    public adapterbaihat(Activity context, int res, List<baihat> list, DBHelper helper)
    {
        super(context,res, list);
        this.context =context;
        this.res = res;
        this.obj = list;
        this.helper = helper;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =this.context.getLayoutInflater();
        View item = inflater.inflate(this.res, null);

        TextView ma =item.findViewById(R.id.txtMa);
        TextView ten =item.findViewById(R.id.txtTen);
        TextView tacgia =item.findViewById(R.id.txtTacgia);
        TextView thoiluong =item.findViewById(R.id.txtThoiluong);
        final baihat baihat = obj.get(position);
        ma.setText(baihat.getMa());
        ten.setText(baihat.getTen());
        tacgia.setText(baihat.getTacgia());
        thoiluong.setText(baihat.getThoiluong() +"");

        return item;
    }
}
