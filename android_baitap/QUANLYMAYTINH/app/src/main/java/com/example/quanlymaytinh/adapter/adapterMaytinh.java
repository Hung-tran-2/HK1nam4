package com.example.quanlymaytinh.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.quanlymaytinh.R;
import com.example.quanlymaytinh.dao.DBHelper;
import com.example.quanlymaytinh.model.MayTinh;

import java.util.List;

public class adapterMaytinh extends ArrayAdapter<MayTinh>  {

    Activity context;
    int res;
    List<MayTinh> obj;
    DBHelper helper;

    public adapterMaytinh(Activity context, int res, List<MayTinh> list, DBHelper helper)
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

        TextView mamay =item.findViewById(R.id.txtMa);
        TextView tenmay =item.findViewById(R.id.txtTen);
        TextView soluong =item.findViewById(R.id.txtSoluong);
        TextView giatien =item.findViewById(R.id.txtGiatien);
        final MayTinh mayTinh = obj.get(position);
        mamay.setText(mayTinh.getMaMay() + "");
        tenmay.setText(mayTinh.getTenMay());
        soluong.setText(mayTinh.getSoLuong()+"");
        giatien.setText(mayTinh.getGiaTien()+"");

        return item;
    }
}
