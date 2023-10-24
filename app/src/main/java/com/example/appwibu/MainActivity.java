package com.example.appwibu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.appwibu.adapter.TruyenTranhAdapter;
import com.example.appwibu.object.Truyen;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
GridView gdvDSTruyen;
TruyenTranhAdapter adapter;
ArrayList<Truyen> truyenArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();
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