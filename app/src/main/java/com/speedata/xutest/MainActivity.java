package com.speedata.xutest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.speedata.xutest.activity.Activity20170426;
import com.speedata.xutest.activity.Activity20170614;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Button btn20170426 = (Button) findViewById(R.id.btn_20170426);
        btn20170426.setOnClickListener(this);
        Button btn20170614 = (Button) findViewById(R.id.btn_20170614);
        btn20170614.setOnClickListener(this);
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



            default:
                break;
        }
    }
}
