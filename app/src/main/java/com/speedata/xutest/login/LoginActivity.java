package com.speedata.xutest.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.speedata.xutest.R;
import com.speedata.xutest.base.BaseMvpActivity;
import com.speedata.xutest.main.MainActivity;
import com.speedata.xutest.net.Constant;
import com.speedata.xutest.utils.SPUtils;
import com.speedata.xutest.utils.ToastUtils;


/**
 * @author :Reginer in  2017/9/18 18:47.
 *         联系方式:QQ:282921012
 *         功能描述:登录
 */
public class LoginActivity extends BaseMvpActivity<LoginActivity, LoginPresenterImpl> implements View.OnClickListener, ILoginView {

    private EditText mEtUsername;
    private EditText mEtPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
        mToolBar.setNavigationIcon(null);
    }

    @Override
    protected LoginPresenterImpl createPresenter() {
        return new LoginPresenterImpl();
    }

    @Override
    protected int getActLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

        mEtUsername = findViewById(R.id.et_username);
        mEtPwd = findViewById(R.id.et_pwd);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                mPresenter.doLogin(mEtUsername.getText().toString().trim(), mEtPwd.getText().toString().trim());
                break;
        }
    }


    @Override
    public void completeLogin(LoginEntity entity) {
        if ("1".equals(entity.getErrCode())) {
            SPUtils.put(this, Constant.TOKEN, entity.getUserToken());
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            ToastUtils.showShortToastSafe(entity.getErrMsg());
        }
    }
}
