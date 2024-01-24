package stu.edu.vntrannhunguyen_dh52007186_ca4;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class AdapterDSN {

        private ArrayList<DSV> dsvs;
        public AdapterDSN(Context context, ArrayList<DSV>dsvs) {

            this.dsvs = dsvs;
        }


    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout, parent, false);
        }

        DSV dsv = dsvs.get(position);

        TextView txtMsnv = itemView.findViewById(R.id.edtMasinhVien);
        TextView txtTen = itemView.findViewById(R.id.edtTensingvien);
        TextView txtLop = itemView.findViewById(R.id.edtLop); //
        TextView txtGioitinh = itemView.findViewById(R.id.);

        txtMsnv.setText(dsv.getMsnv());
            txtTen.setText(dsv.getTen());
        txtHesoluong.setText(String.valueOf(dsv.getHesoluong()));
            txtGioitinh.setText(dsv.isGioitinh() ? "Nam" : "Nữ");

        return itemView;
    }
}
