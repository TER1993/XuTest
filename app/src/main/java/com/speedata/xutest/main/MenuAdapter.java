package com.speedata.xutest.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.speedata.xutest.R;
import com.speedata.xutest.base.AppFid;

import java.util.Arrays;
import java.util.List;

/**
 * @author :Reginer in  2017/9/18 18:55.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class MenuAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;

    MenuAdapter(FragmentManager fm, List<Fragment> mFragmentList) {
        super(fm);
        this.mFragmentList = mFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Arrays.asList(AppFid.getInstance().getResources().getStringArray(R.array.main_tabs)).get(position);
    }
}
