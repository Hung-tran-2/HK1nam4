package stu.edu.quanlythongtinlienlac.activity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import stu.edu.quanlythongtinlienlac.R;
import stu.edu.quanlythongtinlienlac.model.ThongTinBanBe;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class updatedata extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton btnImg;
    EditText birthday, name, nickname, gmail, zalo, facebook, xspace, instagram;
    Button btnCapnhat;
    DatePickerDialog picker;
    int id = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedata);

        addControls();
        showData();
        addListener();
        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyCapNhat();
            }
        });
    }

    private void addControls(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnImg = findViewById(R.id.btnImg);
        birthday = findViewById(R.id.edtBirthday);
        name = findViewById(R.id.edtName);
        nickname = findViewById(R.id.edtNickname);
        gmail = findViewById(R.id.edtGmail);
        zalo = findViewById(R.id.edtZalo);
        facebook = findViewById(R.id.edtFb);
        xspace = findViewById(R.id.edtXspace);
        instagram = findViewById(R.id.edtInstagram);
        btnCapnhat = findViewById(R.id.btnCapnhat);
    }

    private void addListener(){
        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCamera();
            }
        });

        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                picker = new DatePickerDialog(updatedata.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        String formatDay = String.format("%02d", day);
                        String formatMonth = String.format("%02d", month + 1);
                        birthday.setText(formatDay + "/" + formatMonth + "/" +year);
                    }
                }, year, month, day);
                picker.show();
            }
        });
    }

    private void startCamera(){
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(ActivityCompat.checkSelfPermission(updatedata.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(updatedata.this, new String[]{Manifest.permission.CAMERA}, 1);
            return;
        }
        startActivityForResult(camera, 88);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 88 && resultCode == updatedata.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            btnImg.setImageBitmap(photo);
        }
    }

    private void showData(){
        Intent intent = getIntent();
        ThongTinBanBe ttbb = (ThongTinBanBe) intent.getSerializableExtra("ttbb");
        id = ttbb.getId();
        if(ttbb.getImage() != null && ttbb.getImage().length > -1){
            Bitmap bm = BitmapFactory.decodeByteArray(ttbb.getImage(), 0, ttbb.getImage().length);
            btnImg.setImageBitmap(bm);
        }else{
            btnImg.setImageBitmap(null);
        }
        name.setText(ttbb.getName());
        nickname.setText(ttbb.getNickname());
        birthday.setText(ttbb.getBirthday());
        gmail.setText(ttbb.getGmail());
        zalo.setText(ttbb.getZalo());
        facebook.setText(ttbb.getFb());
        xspace.setText(ttbb.getXspace());
        instagram.setText(ttbb.getIns());
    }

    private void xuLyCapNhat(){
        ThongTinBanBe ttbb = new ThongTinBanBe();
        ttbb.setId(id);
        BitmapDrawable bmDraw = (BitmapDrawable) btnImg.getDrawable();
        Bitmap bm = bmDraw.getBitmap();
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
        byte[] imgByte = byteArray.toByteArray();
        ttbb.setImage(imgByte);
        ttbb.setName(name.getText()+"");
        ttbb.setNickname(nickname.getText()+"");
        ttbb.setBirthday(birthday.getText()+"");
        ttbb.setGmail(gmail.getText()+"");
        ttbb.setZalo(zalo.getText()+"");
        ttbb.setFb(facebook.getText()+"");
        ttbb.setXspace(xspace.getText()+"");
        ttbb.setIns(instagram.getText()+"");
        Intent returnIntent = new Intent();
        returnIntent.putExtra("ttbb", ttbb);
        setResult(888, returnIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.insert_menu, m);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.search){
        } else if (id == R.id.about) {
        } else if (id == R.id.infor) {
        } else if (id == R.id.exit) {
            finish();
        }
        return true;
    }
}