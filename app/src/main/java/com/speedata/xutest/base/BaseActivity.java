package com.speedata.xutest.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.speedata.xutest.MainActivity;
import com.speedata.xutest.R;


/**
 * @author :Reginer in  2017/9/18 12:17.
 *         联系方式:QQ:282921012
 *         功能描述:Activity基类，所有Activity父类<p>
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    protected Toolbar mToolBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.base_layout);
        FrameLayout viewContent = findViewById(R.id.view_content);
        LayoutInflater.from(BaseActivity.this).inflate(getActLayoutId(), viewContent);
        initToolbar();
        initView(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mContext instanceof MainActivity) {
            mToolBar.setNavigationIcon(null);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     * 初始化ToolBar. <p>
     */
    private void initToolbar() {
        mToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationOnClickListener(view -> finish());
    }

    /**
     * 获取activity布局.
     *
     * @return layout
     */
    @LayoutRes
    protected abstract int getActLayoutId();

    /**
     * 在这个方法中初始化控件.
     *
     * @param savedInstanceState 保存的数据
     */
    protected abstract void initView(@Nullable Bundle savedInstanceState);
}
