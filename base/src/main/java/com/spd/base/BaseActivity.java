package com.spd.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

/**
 * @author :Reginer in  2017/9/18 12:17.
 *         联系方式:QQ:282921012
 *         功能描述:Activity基类，所有Activity父类<p>
 *         Activity的生命周期除了{@link #onRestart()}是两两对应的，其中有super，在每个生命周期中执行任务需要注意:</p>
 *         在onCreate、onStart、onResume、onRestart方法中执行，把要执行的方法放到super下一行写，其他的放到super上一行写
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
    }

    /**
     * 在这个方法执行之前，Activity的界面都是不可见的.<p>
     * 建议在这个方法之前不要进行在主线程的耗时操作.<p>
     */
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
     * 这个方法无论会不会执行到{@link #onStop()},{@link #onDestroy()}都会执行,<p>
     * 可以用来保存数据,同时在 super.onSaveInstanceState(outState);上一行操作.
     *
     * @param outState 待操作数据.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * 初始化ToolBar. <p>
     *     因为ToolBar的变化很小，所以这里就在这里初始化一下，如果有其他Activity有变化，可以使用{@link #mToolBar}的对应方法来设置<p>
     *         当然，也可以参照{@link #initView(Bundle)}方法来写.
     */
    private void initToolbar() {
        mToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationOnClickListener(view -> finish());
    }

    /**
     * 获取activity布局.
     * @return layout
     */
    @LayoutRes
    protected abstract int getActLayoutId();

    /**
     * 在这个方法中初始化控件.
     * @param savedInstanceState 保存的数据,就是{@link #onSaveInstanceState(Bundle)}中的outState.
     */
    protected abstract void initView(@Nullable Bundle savedInstanceState);
}
