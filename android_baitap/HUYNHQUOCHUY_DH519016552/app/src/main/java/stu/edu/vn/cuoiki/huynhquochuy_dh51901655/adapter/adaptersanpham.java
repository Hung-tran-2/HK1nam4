package stu.edu.vn.cuoiki.huynhquochuy_dh51901655.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import stu.edu.vn.cuoiki.huynhquochuy_dh51901655.R;
import stu.edu.vn.cuoiki.huynhquochuy_dh51901655.dao.DBHelper;
import stu.edu.vn.cuoiki.huynhquochuy_dh51901655.model.sanpham;

public class adaptersanpham extends ArrayAdapter<sanpham> {
    Activity context;
    int res;
    List<sanpham> obj;
    DBHelper helper;


    public adaptersanpham(Activity context, int res, List<sanpham> list, DBHelper helper)
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
        TextView gia =item.findViewById(R.id.txtGia);
        TextView nam =item.findViewById(R.id.txtnambaohanh);
        final sanpham maytinh = obj.get(position);
        ma.setText(maytinh.getMasp());
        ten.setText(maytinh.getTensp());
        gia.setText(maytinh.getGia() +"");
        nam.setText(maytinh.getNam() +"");

        return item;
    }
}
