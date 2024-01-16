package stu.edu.vn.thicuoiki.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import stu.edu.vn.thicuoiki.R;
import stu.edu.vn.thicuoiki.module.Sach;

public class SachAdapter extends ArrayAdapter<Sach> {
    Activity context;
    List<Sach> dsnv;
    int resource;
    public SachAdapter(Activity context, int resource, List<Sach> dsnv) {
        super(context, resource,dsnv);
        this.context = context;
        this.dsnv = dsnv;
        this.resource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item = inflater.inflate(this.resource,null);
        TextView id = item.findViewById(R.id.textView_id);
        TextView ten = item.findViewById(R.id.textView_ten);
        final Sach nv = dsnv.get(position);
        id.setText(nv.getMa()+"");
        ten.setText(nv.getTen());
        return item;
    }
}
