package vn.edu.stu.lythingocdiem_dh52005710.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import vn.edu.stu.lythingocdiem_dh52005710.Model.MonHoc;
import vn.edu.stu.lythingocdiem_dh52005710.R;

public class AdapterMonHoc extends ArrayAdapter<MonHoc> {
    Activity context;
    List<MonHoc> dsmh;
    int resource;

    public AdapterMonHoc(Activity context, int resource, List<MonHoc> dsmh) {
        super(context, resource,dsmh);
        this.context = context;
        this.dsmh = dsmh;
        this.resource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item = inflater.inflate(this.resource,null);
        TextView ma = item.findViewById(R.id.text_mamh);
        TextView ten = item.findViewById(R.id.text_tenmh);

        final MonHoc mh = dsmh.get(position);
        ma.setText(mh.getMa()+"");
        ten.setText(mh.getTen());

        return item;
    }
}
