package stu.edu.vn.webservice_qlnv.adapterNhanVien;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import stu.edu.vn.webservice_qlnv.R;
import stu.edu.vn.webservice_qlnv.modal.SinhVien;

public class adapter extends ArrayAdapter<SinhVien> {
    private ArrayList<SinhVien> ds;
    private int lastpos =-1;
    Activity context;

    public adapter(ArrayList<SinhVien> ds, Activity context) {
        super(context, R.layout.item, ds);
        this.ds = ds;
        this.context = context;
    }
    private class  ViewHolder{
        TextView masv;
        TextView tensv;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SinhVien sv =getItem(position);
        ViewHolder viewHolder;
        final View result;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView= inflater.inflate(R.layout.item, parent, false);
            viewHolder.masv =convertView.findViewById(R.id.viewMa);
            viewHolder.tensv = convertView.findViewById(R.id.viewTen);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        lastpos = position;
        int ma = sv.getMa();
        String ten = sv.getTen();
        viewHolder.masv.setText(ma+"");
        viewHolder.tensv.setText(ten);
        return convertView;
    }
}
