package com.speedata.xutest.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * @author :Reginer in  2017/9/7 9:30.
 *         联系方式:QQ:282921012
 *         功能描述:Presenter基类
 */
public class BaseMvpPresenter<V> {
    private Reference<V> mViewRef;
    private CompositeDisposable disposables;

    void attachView(V view) {
        mViewRef = new WeakReference<>(view);
        disposables = new CompositeDisposable();
    }

    public V getView() {
        if (mViewRef == null) {
            return null;
        }
        return mViewRef.get();
    }

    private boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    void detachView() {
        if (isViewAttached()) {
            mViewRef.clear();
            mViewRef = null;
        }
        if (disposables != null) {
            disposables.clear();
        }
    }

}