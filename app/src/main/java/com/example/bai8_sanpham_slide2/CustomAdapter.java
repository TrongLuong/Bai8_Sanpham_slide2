package com.example.bai8_sanpham_slide2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<SanPham> {
    private Context context;
    private int resuorce;
    private ArrayList<SanPham> arrayListSP;
    SanPham sp;


    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<SanPham> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resuorce =resource;
        this.arrayListSP = (ArrayList<SanPham>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.activity_items,parent,false);
        TextView txtma = convertView.findViewById(R.id.txtmasp);
        TextView txtten = convertView.findViewById(R.id.txttensp);
        TextView txtncc = convertView.findViewById(R.id.txtnccsp);


        SanPham sp = arrayListSP.get(position);

        txtma.setText(sp.getMaSp());
        txtten.setText(sp.getTenSP());
        txtncc.setText(sp.getNccSP());
        return convertView;
    }
    //

}
