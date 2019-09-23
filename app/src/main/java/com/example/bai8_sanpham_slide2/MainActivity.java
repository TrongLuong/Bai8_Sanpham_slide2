package com.example.bai8_sanpham_slide2;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewSP;

    CustomAdapter customAdapter;
    ArrayList<SanPham> arrList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewSP = findViewById(R.id.livSP);
        arrList = new ArrayList<>();
        arrList.add(new SanPham("111", "Lua", "chu 2"));
        arrList.add(new SanPham("111", "Lua", "chu 2"));
        arrList.add(new SanPham("111", "Lua", "chu 2"));
        customAdapter = new CustomAdapter(this, R.layout.activity_items, arrList);
        listViewSP.setAdapter(customAdapter);
        //dd context menu
        registerForContextMenu(listViewSP);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
        menu.setHeaderTitle("Chon tac vu");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.xemct:
                setContentView(R.layout.activity_main);

                break;
            case R.id.themsp:
                Intent intent = new Intent(MainActivity.this, ThemActi.class);
                startActivityForResult(intent, 1000);
                break;


            case R.id.suasp:
                setContentView(R.layout.activity_sua);
                break;
            case R.id.xoasp:


                dialog();



                break;
        }
        return super.onContextItemSelected(item);
    }
    private void dialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1000) {
            Bundle bundle = data.getBundleExtra("obj");
            SanPham sp = (SanPham) bundle.getSerializable("sp");
            arrList.add(sp);
            listViewSP.setAdapter(customAdapter);

        }



    }
}
