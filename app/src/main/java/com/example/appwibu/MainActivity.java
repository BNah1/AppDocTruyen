package com.example.appwibu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.appwibu.adapter.TruyenTranhAdapter;
import com.example.appwibu.object.Truyen;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
GridView gdvDSTruyen;
TruyenTranhAdapter adapter;
ArrayList<Truyen> truyenArrayList;

    TextView textView;
    FirebaseAuth auth;
    FirebaseUser user;
    Button buttonlogout, buttonedit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();
        textView = findViewById(R.id.user_ID);
        auth = FirebaseAuth.getInstance();
        buttonedit = findViewById(R.id.LLLLLL2);
        buttonlogout = findViewById(R.id.LLLLLL1);
        user = auth.getCurrentUser();
        if (user == null){
            Intent intent = new Intent(getApplicationContext(),screenDangNhap.class);
            startActivity(intent);
            finish();
        }
        else {
            textView.setText(user.getEmail());
        }

        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), screenDangNhap.class);
                startActivity(intent);
                finish();
            }
        });
        buttonedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), screenDoiPass.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init(){
        truyenArrayList = new ArrayList<>();
        truyenArrayList.add((new Truyen("22","22","https://st.nettruyenus.com/data/comics/22/be-thoc-dang-thuong-duoc-tam-nguoi-cau-t-9422.jpg")));
        truyenArrayList.add((new Truyen("22","22","https://st.nettruyenus.com/data/comics/32/chuc-nghiem-tham-dinh-khong-thuan-loi-nh-1761.jpg")));
        truyenArrayList.add((new Truyen("22","22","https://st.nettruyenus.com/data/comics/32/chuc-nghiem-tham-dinh-khong-thuan-loi-nh-1761.jpg")));
        truyenArrayList.add((new Truyen("22","22","https://st.nettruyenus.com/data/comics/32/chuc-nghiem-tham-dinh-khong-thuan-loi-nh-1761.jpg")));

        adapter = new TruyenTranhAdapter(this,0,truyenArrayList);
    }
    private void anhXa(){
        gdvDSTruyen = findViewById(R.id.gdvDSTruyen);
    }
    private void setUp(){
        gdvDSTruyen.setAdapter(adapter);
    }
    private void setClick(){}
}