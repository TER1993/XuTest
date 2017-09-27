package com.speedata.xutest.main.settings;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.speedata.xutest.R;
import com.speedata.xutest.base.BaseFragment;
import com.speedata.xutest.net.Constant;
import com.speedata.xutest.utils.SPUtils;


/**
 * @author :Reginer in  2017/9/18 18:59.
 *         联系方式:QQ:282921012
 *         功能描述:设置
 */
public class SettingsFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {

    private RadioButton rbtnOnline;
    private RadioButton getRbtnOffline;
    private Context mContext;


    public SettingsFragment() {
        // Required empty public constructor
    }



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_settings;
    }

    @Override
    protected void initView(View view, @Nullable Bundle savedInstanceState) {
        mContext = SettingsFragment.this.getContext();
        RadioGroup group = view.findViewById(R.id.radiogroup);
        rbtnOnline = view.findViewById(R.id.radioButton_online);
        getRbtnOffline = view.findViewById(R.id.radioButton_offline);
        boolean rbtn =(boolean) SPUtils.get(mContext, Constant.ONLINE, true);
        if (rbtn){
            rbtnOnline.performClick();
        } else {
            getRbtnOffline.performClick();
        }

        group.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == rbtnOnline.getId()){
            SPUtils.put(mContext, Constant.ONLINE, true);
        }else if (checkedId == getRbtnOffline.getId()){
            SPUtils.put(mContext, Constant.ONLINE, false);
        }

    }
}
