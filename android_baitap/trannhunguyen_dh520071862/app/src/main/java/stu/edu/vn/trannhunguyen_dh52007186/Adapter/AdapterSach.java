package stu.edu.vn.trannhunguyen_dh52007186.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import stu.edu.vn.trannhunguyen_dh52007186.R;
import stu.edu.vn.trannhunguyen_dh52007186.dao.DBHelper;
import stu.edu.vn.trannhunguyen_dh52007186.model.Sach;

import java.util.List;

public class AdapterSach extends ArrayAdapter<Sach> {
    Activity context;
    int res;
    List<Sach> obj;
    DBHelper helper;
    public AdapterSach(Activity context, int res, List<Sach> list, DBHelper helper)
    {
        super(context,res, list);
        this.context =context;
        this.res = res;
        this.obj = list;
        this.helper = helper;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater =this.context.getLayoutInflater();
        View item = inflater.inflate(this.res, null);

        TextView ma =item.findViewById(R.id.txtMa);
        TextView ten =item.findViewById(R.id.txtTen);
        TextView tacgia =item.findViewById(R.id.txtTacgia);
        TextView namxb =item.findViewById(R.id.txtthoiluong);
        final Sach sach = obj.get(position);
        ma.setText(sach.getMa());
        ten.setText(sach.getTen());
        tacgia.setText(sach.getTacgia());
        namxb.setText(sach.getNamxuatban()+"");

        return item;
    }
}
