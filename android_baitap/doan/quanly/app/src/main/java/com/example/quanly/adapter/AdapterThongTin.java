package com.example.DoAn.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.DoAn.R;
import com.example.DoAn.activity.updatedata;
import com.example.DoAn.dao.DatabaseHelper;
import com.example.DoAn.model.ThongTinBanBe;

import java.util.List;

public class AdapterThongTin extends ArrayAdapter<ThongTinBanBe> {
    Activity context;
    int resource;
    List<ThongTinBanBe> objects;

    public AdapterThongTin(Activity context, int resource, List<ThongTinBanBe> objects){
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item = inflater.inflate(this.resource, null);
        ImageView image = (ImageView) item.findViewById(R.id.image);
        TextView name = item.findViewById(R.id.name);
        TextView nickname = item.findViewById(R.id.nickname);
        TextView birthday = item.findViewById(R.id.birthday);

        final ThongTinBanBe ttbb = objects.get(position);
        int id = ttbb.getId();

        if(ttbb.getImage() != null && ttbb.getImage().length > -1){
            Bitmap bm = BitmapFactory.decodeByteArray(ttbb.getImage(), 0,
                    ttbb.getImage().length);
            image.setImageBitmap(bm);
        }else{
            image.setImageBitmap(null);
        }
        name.setText(ttbb.getName());
        nickname.setText(ttbb.getNickname());
        birthday.setText(ttbb.getBirthday());

        Button btnXoa = item.findViewById(R.id.btnXoa);
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông báo !");
                builder.setMessage("Bạn có muốn xóa ?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, String.valueOf(id), Toast.LENGTH_SHORT).show();
                        DatabaseHelper dbHelper = new DatabaseHelper(context);
                        dbHelper.deleteData(id);
                        objects.remove(ttbb);
                        notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        Button btnSua = item.findViewById(R.id.btnSua);
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper dbHelper = new DatabaseHelper(context);
                ThongTinBanBe ttbb = dbHelper.findOne(id);
                Intent intent = new Intent(getContext(), updatedata.class);
                intent.putExtra("ttbb", ttbb);
                context.startActivityForResult(intent, 66);
            }
        });

        return item;
    }
}
