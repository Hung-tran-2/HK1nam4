package vn.edu.stu.myapplication.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

import vn.edu.stu.myapplication.DatabaseHelper;
import vn.edu.stu.myapplication.R;
import vn.edu.stu.myapplication.model.NhanVien;

public class NhanVienAdapter extends ArrayAdapter<NhanVien> {


    private Context context;
    private ArrayList<NhanVien> nhanVienList;

    public NhanVienAdapter(Context context, ArrayList<NhanVien> nhanVienList) {
        super(context, 0, nhanVienList);
        this.context = context;
        this.nhanVienList = nhanVienList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.nhanvien_item, parent, false);
        }

        NhanVien currentNhanVien = nhanVienList.get(position);

        TextView tvMaNV = listItem.findViewById(R.id.tvMaNV);
        TextView tvTenNV = listItem.findViewById(R.id.tvTenNV);
        TextView tvGioiTinh = listItem.findViewById(R.id.tvGioiTinh);

        tvMaNV.setText(String.valueOf(currentNhanVien.getMaNV()));
        tvTenNV.setText(currentNhanVien.getTenNV());

        String gioiTinh = currentNhanVien.isGioiTinh() ? "Nam" : "Nữ";
        tvGioiTinh.setText(gioiTinh);

        return listItem;
    }

}
