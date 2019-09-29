package com.example.bai8_sanpham_slide2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SuaSP extends AppCompatActivity {
    private Button btnluu;

    private EditText edtid, edtten, edtncc;
     Intent intent = new Intent();
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_sp);
        btnluu = findViewById(R.id.btnluu);
        edtid = findViewById(R.id.edt_masps);
        edtten = findViewById(R.id.edt_tensps);
        edtncc = findViewById(R.id.edt_nccs);

        //lấy đối tượng từ items đã chọn trên lv

        intent = getIntent();
         bundle = intent.getBundleExtra("objs");
        SanPham sp = (SanPham) bundle.getSerializable("sps");
        //gán data lấy đc lên editText
        edtid.setText(sp.getMaSp());
        edtten.setText(sp.getTenSP());
        edtncc.setText(sp.getNccSP());

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = getIntent();
                //gửi
                String i = edtid.getText().toString();
                String t = edtten.getText().toString();
                String n = edtncc.getText().toString();

                SanPham sps = new SanPham(i, t, n);
                bundle.putSerializable("spss", sps);
                intent.putExtra("objss", bundle);
                setResult(1001, intent);
                Toast.makeText(SuaSP.this,"Cập nhật thành công!", Toast.LENGTH_SHORT).show();
                    finish();

            }
        });


    }


}
