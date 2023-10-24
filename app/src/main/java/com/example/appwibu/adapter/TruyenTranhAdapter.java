package com.example.appwibu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appwibu.R;
import com.example.appwibu.object.Truyen;

import java.util.ArrayList;
import java.util.List;

public class TruyenTranhAdapter extends ArrayAdapter<Truyen> {
    private Context ct;
    private ArrayList<Truyen> arr;
    public TruyenTranhAdapter(@NonNull Context context, int resource, @NonNull List<Truyen> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(R.layout.item_truyen,null );
        }
        if(arr.size()>0){
            Truyen truyentranh = this.arr.get(position);
            TextView tenTenTruyen = convertView.findViewById(R.id.txvTenTruyen);
            TextView tenSoChap = convertView.findViewById(R.id.txvSoChap);
            ImageView imgAnhTruyen = convertView.findViewById(R.id.imgAnhTruyen);

            // xem lai cach lay du lieu tu Firebase
            tenTenTruyen.setText(truyentranh.getTenTruyen());
            tenSoChap.setText(truyentranh.getSoChap());
            // xem lai cach lay du lieu tu Firebase
        }
        return convertView;
    }
}
