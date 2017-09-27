package com.speedata.xutest.main;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.speedata.xutest.R;
import com.speedata.xutest.add.AddAssetsActivity;
import com.speedata.xutest.base.BaseActivity;
import com.speedata.xutest.login.LoginActivity;
import com.speedata.xutest.main.assets.AssetsFragment;
import com.speedata.xutest.main.inventory.fragments.InventoryChangeFragment;
import com.speedata.xutest.main.settings.SettingsFragment;
import com.speedata.xutest.main.sync.SyncFragment;
import com.speedata.xutest.net.Constant;
import com.speedata.xutest.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :Reginer in  2017/9/18 18:47.
 *         联系方式:QQ:282921012
 *         功能描述:主页
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getActLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new AssetsFragment());
        mFragmentList.add(new InventoryChangeFragment());
        //mFragmentList.add(new InventoryFragment());
        mFragmentList.add(new SettingsFragment());
        mFragmentList.add(new SyncFragment());
        MenuAdapter mAdapter = new MenuAdapter(getSupportFragmentManager(), mFragmentList);
        ViewPager mViewPager = findViewById(R.id.vp_container);
        TabLayout mTabMain = findViewById(R.id.tab_main);
        mTabMain.setupWithViewPager(mViewPager);
        LinearLayout linearLayout = (LinearLayout) mTabMain.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(this,
                R.drawable.layout_divider_horizontal));
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(4);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                startActivity(new Intent(mContext, AddAssetsActivity.class));
                break;
            case R.id.action_logout:
                logout();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 退出登录.
     */
    private void logout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.sure_logout);
        builder.setPositiveButton(android.R.string.ok, (dialog, which) -> {
            dialog.dismiss();
            SPUtils.put(mContext, Constant.TOKEN, "");
            startActivity(new Intent(mContext, LoginActivity.class));
            finish();
        });
        builder.setNegativeButton(android.R.string.cancel, (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }
}
