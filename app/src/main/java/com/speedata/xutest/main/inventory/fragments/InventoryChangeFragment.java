package com.speedata.xutest.main.inventory.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.speedata.xutest.R;
import com.speedata.xutest.base.BaseFragment;
import com.speedata.xutest.main.inventory.InventoryFragment;
import com.speedata.xutest.main.inventory.checked.InventoryDoneFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xu on 2017/9/21.
 */

public class InventoryChangeFragment extends BaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_inventory_change;
    }

    @Override
    protected void initView(View view, @Nullable Bundle savedInstanceState) {

        List<Fragment> mFragmentList = new ArrayList<>();

        mFragmentList.add(new InventoryFragment());
        mFragmentList.add(new InventoryDoneFragment());

        InventoryMenuAdapter mAdapter = new InventoryMenuAdapter(getChildFragmentManager(), mFragmentList);
        ViewPager mViewPager = view.findViewById(R.id.vp_container);
        TabLayout mTabMain = view.findViewById(R.id.tab_main);
        mTabMain.setupWithViewPager(mViewPager);
        LinearLayout linearLayout = (LinearLayout) mTabMain.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(this.getContext(),
                R.drawable.layout_divider_horizontal));
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(2);
    }

}
