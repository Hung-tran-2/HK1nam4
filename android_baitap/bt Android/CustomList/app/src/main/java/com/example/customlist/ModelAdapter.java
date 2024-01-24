package com.example.customlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ModelAdapter extends ArrayAdapter<Model> {

    public ModelAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Model> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }
        Model m = getItem(position);
        TextView txt1 = (TextView) convertView.findViewById(R.id.name);
        TextView txt2 = (TextView) convertView.findViewById(R.id.gia);
        EditText edt = (EditText) convertView.findViewById(R.id.soluong);
        txt1.setText(m.getname());
        txt2.setText(m.getgia());
        edt.setText(m.getsoluong());
        return convertView;
    }

}
