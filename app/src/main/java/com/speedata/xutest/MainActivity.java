package com.speedata.xutest;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lyf.yflibrary.Permission;
import com.example.lyf.yflibrary.PermissionResult;
import com.speedata.xutest.activity.Activity20170426;
import com.speedata.xutest.activity.Activity20170614;
import com.speedata.xutest.activity.Activity20170907;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //将要获取的权限全放到一个字符串数组中用来动态申请
    private String[] REQUEST_PERMISSIONS = new String[]{
            Manifest.permission.READ_CALENDAR, Manifest.permission.CAMERA,
            Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.RECORD_AUDIO, Manifest.permission.SEND_SMS,
            Manifest.permission.READ_EXTERNAL_STORAGE};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_old);
        initP();
    }
    //权限获取，全success则开始初始化view进入软件，否则就退出程序在下一次启动时重新检测权限并提示获取
    private void initP() {

        Permission.checkPermisson(this, REQUEST_PERMISSIONS, new PermissionResult() {

            @Override
            public void success() {
                //成功
                initView();
            }

            @Override
            public void fail() {
                //失败
                finish();
            }
        });


    }

    private void initView() {
        Button btn20170426 = findViewById(R.id.btn_20170426);
        btn20170426.setOnClickListener(this);
        Button btn20170614 = findViewById(R.id.btn_20170614);
        btn20170614.setOnClickListener(this);
        Button btn20170907 = findViewById(R.id.btn_20170907);
        btn20170907.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_20170426:
                Intent intent20170426 = new Intent(MainActivity.this, Activity20170426.class);
                startActivity(intent20170426);
                break;

            case R.id.btn_20170614:
                Intent intent20170614 = new Intent(MainActivity.this, Activity20170614.class);
                startActivity(intent20170614);
                break;

            case R.id.btn_20170907:
                Intent intent20170907 = new Intent(MainActivity.this, Activity20170907.class);
                startActivity(intent20170907);
                break;


            default:
                break;
        }
    }
}
