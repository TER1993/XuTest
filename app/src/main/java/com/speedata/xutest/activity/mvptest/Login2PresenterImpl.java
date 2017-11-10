package com.speedata.xutest.activity.mvptest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.spd.base.BasePresenter;

/**
 *
 * @author xu
 * @date 2017/11/8
 */

public class Login2PresenterImpl extends BasePresenter<Login2Activity, Login2Model> implements Login2Presenter{

    private ArrayAdapter<String> adapter;

    @Override
    protected Login2Model createModel() {

        return null;
    }

    public void loginSystem(Context context, EditText username, EditText password, AutoCompleteTextView autoCompleteTextView){

        String usernameString = username.getText().toString().trim();
        if (TextUtils.isEmpty(usernameString)) {
            Toast.makeText(context, "usernameString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String passwordString = password.getText().toString().trim();
        if (TextUtils.isEmpty(passwordString)) {
            Toast.makeText(context, "passwordString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if ("admin".equals(usernameString) && "0000".equals(passwordString)) {
            Toast.makeText(context, "成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "用户名密码错误", Toast.LENGTH_SHORT).show();
            return;
        }

        //传递输入的值
        String autoString = autoCompleteTextView.getText().toString().trim();

        autoMessage(context, autoString);

    }



    @Override
    public void presenterLogin(boolean isDefault) {
        if (isDefault){
            getView().viewLogin();
        }


    }

    @Override
    public void autoMessage(Context context, String add) {
        if (add != null){
            saveHistory(context, add);
            getView().autoString(add);
        }

    }

    /**
     * 初始化AutoCompleteTextView，最多显示5项提示，使
     * AutoCompleteTextView在一开始获得焦点时自动提示
     * @param autoCompleteTextView  要操作的AutoCompleteTextView
     */
    @Override
    public void autoInit(Context context, AutoCompleteTextView autoCompleteTextView) {

            SharedPreferences sp = context.getSharedPreferences("network_url", 0);
            String longhistory = sp.getString("history", "nothing");
            String[]  hisArrays = longhistory.split(",");
            adapter = new ArrayAdapter<>(context,
                    android.R.layout.simple_dropdown_item_1line, hisArrays);
            //只保留最近的50条的记录
            if(hisArrays.length > 50){
                String[] newArrays = new String[50];
                System.arraycopy(hisArrays, 0, newArrays, 0, 50);
                adapter = new ArrayAdapter<>(context,
                        android.R.layout.simple_dropdown_item_1line, newArrays);
            }
            autoCompleteTextView.setAdapter(adapter);
            autoCompleteTextView.setDropDownHeight(350);
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setCompletionHint("最近的5条记录");
            autoCompleteTextView.setOnFocusChangeListener((v, hasFocus) -> {
                AutoCompleteTextView view = (AutoCompleteTextView) v;
                if (hasFocus) {
                    view.showDropDown();
                }
            });

    }

    @SuppressLint("ApplySharedPref")
    @Override
    public void autoClear(Context context) {

        SharedPreferences sp = context.getSharedPreferences("history", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();

        adapter.notifyDataSetChanged();

        getView().autoClearfinish();

    }

    /**
     * 把指定AutoCompleteTextView中内容保存到sharedPreference中指定的字符段
     * @param auto   要操作的AutoCompleteTextView
     */

    private void saveHistory(Context context, String auto) {
        SharedPreferences sp = context.getSharedPreferences("network_url", 0);
        String longhistory = sp.getString("history", "nothing");
        if (!longhistory.contains(auto + ",")) {
            StringBuilder sb = new StringBuilder(longhistory);
            sb.insert(0, auto + ",");
            sp.edit().putString("history", sb.toString()).apply();

        }
    }
}
