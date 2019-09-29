package com.example.bai8_sanpham_slide2;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewSP;

    CustomAdapter customAdapter;
    ArrayList<SanPham> arrList;
    Dialog dialog;
    int selectedposition = 0;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewSP = findViewById(R.id.livSP);
        arrList = new ArrayList<>();
        arrList.add(new SanPham("111", "Lúa", "chu 1"));
        arrList.add(new SanPham("222", "Mì", "chu 2"));
        arrList.add(new SanPham("333", "Ổi", "chu 3"));
        arrList.add(new SanPham("444", "Mít", "chu 4"));
        arrList.add(new SanPham("555", "Chuối", "chu 5"));
        arrList.add(new SanPham("666", "Táo", "chu 6"));
        arrList.add(new SanPham("777", "Xoài", "chu 7"));
        customAdapter = new CustomAdapter(this, R.layout.activity_items, arrList);
        listViewSP.setAdapter(customAdapter);
        //dd context menu
        registerForContextMenu(listViewSP);

        listViewSP.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedposition = i;
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
        menu.setHeaderTitle("Chọn tác vụ!");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.xemct:
                xemCTSP();
                break;
            case R.id.themsp:
                Intent intent = new Intent(MainActivity.this, ThemActi.class);
                startActivityForResult(intent, 1000);
                break;

            case R.id.suasp:
                Intent intent1 = new Intent(MainActivity.this, SuaSP.class);
                String id = arrList.get(selectedposition).getMaSp();
                String ten = arrList.get(selectedposition).getTenSP();
                String ncc = arrList.get(selectedposition).getNccSP();
                SanPham sps = new SanPham(id, ten, ncc);
                Bundle bundle = new Bundle();
                bundle.putSerializable("sps", sps);
                intent1.putExtra("objs", bundle);
                startActivityForResult(intent1,1001);

                break;
            case R.id.xoasp:
                dialogg();

                break;
        }
        return super.onContextItemSelected(item);
    }

    private void dialogg() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.show();
        Button xoa = dialog.findViewById(R.id.btnxoa);
        Button dong = dialog.findViewById(R.id.btnclose);
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrList.remove(selectedposition);
                listViewSP.setAdapter(customAdapter);
                dialog.dismiss();

            }
        });
        dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void xemCTSP() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_xem_ctsp);
        dialog.show();
        TextView txtid = dialog.findViewById(R.id.txtIDc);
        TextView txtten = dialog.findViewById(R.id.txtTenc);
        TextView txtncc = dialog.findViewById(R.id.txtNCCc);
        String id = arrList.get(selectedposition).getMaSp();
        String ten = arrList.get(selectedposition).getTenSP();
        String ncc = arrList.get(selectedposition).getNccSP();
        txtid.setText(txtid.getText() + id);
        txtten.setText(txtten.getText() + ten);
        txtncc.setText(txtncc.getText() + ncc);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1000) {
            Bundle bundle = data.getBundleExtra("obj");
            SanPham sp = (SanPham) bundle.getSerializable("sp");
            arrList.add(sp);
            listViewSP.setAdapter(customAdapter);

        }if (resultCode == 1001) {
            Bundle bundle = data.getBundleExtra("objs");
            SanPham sp = (SanPham) bundle.getSerializable("sps");
            arrList.remove(selectedposition);
            arrList.add(sp);
            listViewSP.setAdapter(customAdapter);

        }


    }
}
