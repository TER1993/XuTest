package com.speedata.xutest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.speedata.xutest.net.Constant;
import com.speedata.xutest.utils.SPUtils;


/**
 * @author :Reginer in  2017/9/19 16:12.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String token = (String) SPUtils.get(this, Constant.TOKEN,"");
        if (TextUtils.isEmpty(token)){
            //startActivity(new Intent(this, LoginActivity.class));
            startActivity(new Intent(this, MainActivity.class));

        }else {
            startActivity(new Intent(this, com.speedata.xutest.main.MainActivity.class));
        }
        finish();
    }
}
