package com.speedata.xutest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;


/**
 * @author :Reginer in  2017/9/7 9:30.
 *         联系方式:QQ:282921012
 *         功能描述:mvp基类activity
 */
public abstract class BaseMvpActivity<V, T extends BaseMvpPresenter<V>> extends BaseActivity {
    protected T mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    protected abstract T createPresenter();
}