package com.speedata.xutest.activity.mvptest;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.spd.base.BasePresenter;

/**
 *
 * @author xu
 * @date 2017/11/8
 */

public class Login2PresenterImpl extends BasePresenter<Login2Activity, Login2Model> implements Login2Presenter{


    @Override
    protected Login2Model createModel() {

        return null;
    }

    public void loginSystem(Context context, EditText username, EditText password){

        String usernameString = username.getText().toString().trim();
        if (TextUtils.isEmpty(usernameString)) {
            Toast.makeText(context, "usernameString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String passwordString = password.getText().toString().trim();
        if (TextUtils.isEmpty(passwordString)) {
            Toast.makeText(context, "passwordString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if ("admin".equals(usernameString) && "0000".equals(passwordString)) {
            Toast.makeText(context, "成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "用户名密码错误", Toast.LENGTH_SHORT).show();
        }



    }



    @Override
    public void presenterLogin(boolean isDefault) {
        if (isDefault){
            getView().viewLogin("admin", "0000");
        }


    }
}
