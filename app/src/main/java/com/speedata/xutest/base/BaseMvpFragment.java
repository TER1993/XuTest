package com.speedata.xutest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author :Reginer in  2017/9/8 17:38.
 *         联系方式:QQ:282921012
 *         功能描述:mvp fragment基类
 */
public abstract class BaseMvpFragment<V, T extends BaseMvpPresenter<V>> extends BaseFragment {
    protected T mPresenter;

    @Override
    @SuppressWarnings("unchecked")
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }


    @Override
    public void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    protected abstract T createPresenter();
}
