package com.speedata.xutest.activity.mvptest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spd.base.BaseMvpActivity;
import com.speedata.xutest.R;

/**
 * @author xu
 */
public class Login2Activity extends BaseMvpActivity<Login2PresenterImpl> implements Login2View, View.OnClickListener {

    private EditText username;
    private EditText password;
    private Button login;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login2);
        initView(savedInstanceState);

        mPresenter.presenterLogin(true);
    }



    @Override
    protected Login2PresenterImpl createPresenter() {
        return new Login2PresenterImpl();
    }

    @Override
    protected int getActLayoutId() {
        return R.layout.activity_login2;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

        username = findViewById(R.id.username);
        username.setOnClickListener(this);
        password = findViewById(R.id.password);
        password.setOnClickListener(this);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:

                mPresenter.loginSystem(this, username, password);

                break;

                default:
                    break;
        }
    }

    @Override
    public void viewLogin(String name, String pswd) {
        username.setText(name);
        password.setText(pswd);

        //将光标移动到最后显示最下面的信息.
        password.setFocusableInTouchMode(true);
        password.requestFocus();
        Editable text = password.getText();
        Selection.setSelection(text, text.length());

        Toast.makeText(this, "view方法触发成功",Toast.LENGTH_SHORT).show();
    }
}
