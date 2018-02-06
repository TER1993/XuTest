package com.speedata.xutest.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.speedata.xutest.R;

import static com.speedata.xutest.Utils.BaseConstant.RECE_DATA_ACTION;
import static com.speedata.xutest.Utils.BaseUtil.sendBroadcasts;

/**
 * @author :xu in  2018/2/6 10:30.
 *         联系方式:QQ:2419646399
 *         功能描述: 记录一些新的写法与功能
 */
public class X20180206Activity extends AppCompatActivity implements View.OnClickListener {

    //可能并不适用于新的框架与写法，很少被正确使用及修改
    private Button btnScan;
    private TextView tvShowMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x20180206);

        initView();
    }

    private void initView() {

        btnScan = findViewById(R.id.button);
        tvShowMessage = findViewById(R.id.textView2);
        intentFilter();
        btnScan.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:

                sendBroadcasts();

                break;

                default:
                    break;

        }
    }

    private void intentFilter() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(RECE_DATA_ACTION);
        registerReceiver(receiver, filter);
    }


    /**
     * 广播接收器
     */
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals(RECE_DATA_ACTION)) {
                String data = intent.getStringExtra("se4500");
                if (data != null) {
                    tvShowMessage.setText(data);
                }
            }
        }
    };

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }
}
