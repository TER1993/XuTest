package com.speedata.xutest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.speedata.r6lib.IMifareManager;
import com.speedata.r6lib.R6Manager;
import com.speedata.xutest.R;

import static com.speedata.r6lib.R6Manager.CardType.MIFARE;

public class Activity20170614 extends AppCompatActivity {
    private IMifareManager dev; //定义对象
    private TextView main_info;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_20170614);

        initView();
    }

    private void initView() {
        main_info = (TextView) findViewById(R.id.info);

        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {

        }
        dev = R6Manager.getMifareInstance(MIFARE); //选择卡类型：Mifare1
        if (dev.InitDev() != 0) {

            return;
        }

    }

    @Override
    public void onDestroy() {
        dev.ReleaseDev();
        super.onDestroy();
        Intent i = getIntent();
        setResult(RESULT_OK, i);
    }

    // 4. 拦截系统热键
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int key = event.getKeyCode(); //获取物理按键的key类型：比如音量键，power键等
        int key1 = event.getAction(); //获取某一物理按键的对应的事件类型；比如音量键的按下（down）事件，音量键的松开（up）事件
        if (key == KeyEvent.KEYCODE_F5) { //按下的是侧键

            if (key1 == KeyEvent.ACTION_DOWN) { //侧键按压事件

                getCode();


                return true;
            }
        }

        return super.dispatchKeyEvent(event);
    }

    private void getCode() {
        //search a valid card
        byte[] ID = dev.SearchCard();
        if (ID == null) {
            Toast.makeText(this, "没有寻到卡片", Toast.LENGTH_SHORT).show();
            return;
        }
        String IDString = "";
        for (byte a : ID) {
            IDString += String.format("%02X", a);
        }

        long card = Long.parseLong(IDString, 16);

        main_info.append(card + "\n");
        
    }



}
