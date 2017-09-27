package com.speedata.xutest.login;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.speedata.xutest.base.AppFid;
import com.speedata.xutest.base.BaseMvpPresenter;
import com.speedata.xutest.net.NetApi;
import com.speedata.xutest.utils.DeviceUtils;
import com.speedata.xutest.utils.EncodeUtils;
import com.speedata.xutest.utils.ToastUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author :Reginer in  2017/9/18 19:29.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class LoginPresenterImpl extends BaseMvpPresenter<LoginActivity> implements ILoginPresenter {
    @Override
    public void doLogin(String username, String pwd) {
        if (TextUtils.isEmpty(username)) {
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            return;
        }
        LoginParams params = new LoginParams();
        params.setUserAccount(username);
        params.setUserPwd(EncodeUtils.base64Encode2String(pwd.getBytes()));
        params.setDeviceId(DeviceUtils.getAndroidID(AppFid.getInstance()));
        NetApi.getInstance().doLogin(new Gson().toJson(params)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(LoginEntity s) {
                        getView().completeLogin(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtils.showShortToastSafe(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
