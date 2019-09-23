package com.example.bai8_sanpham_slide2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ThemActi extends AppCompatActivity {
    private Button themsp;
    private EditText ma, ten, ncc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them2);
        themsp=findViewById(R.id.btnthem);

        themsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ma=findViewById(R.id.edt_masp);
                ten=findViewById(R.id.edt_tensp);
                ncc=findViewById(R.id.edt_ncc);
                String mid = ma.getText().toString();
                String t = ten.getText().toString();
                String n = ncc.getText().toString();
                SanPham sp = new SanPham(mid,t,n);

                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("sp",sp);
                intent.putExtra("obj",bundle);
                setResult(1000, intent);
                finish();




            }
        });


    }
}
