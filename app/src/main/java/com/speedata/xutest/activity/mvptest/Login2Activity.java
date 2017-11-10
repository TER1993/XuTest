package com.speedata.xutest.activity.mvptest;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.AutoCompleteTextView;
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
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login2);
        initView(savedInstanceState);
        mPresenter.autoInit(this, autoCompleteTextView);
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
        Button login = findViewById(R.id.login);
        login.setOnClickListener(this);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setOnClickListener(this);

        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:

                mPresenter.loginSystem(this, username, password, autoCompleteTextView);

                break;

            default:
                break;
            case R.id.clear:

                mPresenter.autoClear(this);

                SharedPreferences sp = getSharedPreferences("history", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.commit();

                break;
        }
    }

    @Override
    public void viewLogin() {
        username.setText("admin");
        password.setText("0000");

        //将光标移动到最后显示最下面的信息.
        password.setFocusableInTouchMode(true);
        password.requestFocus();
        Editable text = password.getText();
        Selection.setSelection(text, text.length());

        Toast.makeText(this, "view方法触发成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void autoString(String auto) {
        // 这里可以设定：当搜索成功时，才执行保存操作

        Toast.makeText(this, "获取到自动提示栏输入的值：" + auto, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void autoClearfinish() {

        Toast.makeText(this, "已清空自动提示历史记录", Toast.LENGTH_SHORT).show();
    }

}
