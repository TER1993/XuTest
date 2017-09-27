package com.speedata.xutest.main.inventory;

/**
 * Created by xu on 2017/9/20.
 */

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.speedata.xutest.R;
import com.speedata.xutest.datebase.CheckListBeanEntity;

import java.util.List;

public class CheckAdapter extends BaseQuickAdapter<CheckListBeanEntity, BaseViewHolder>{

    public CheckAdapter(@Nullable List<CheckListBeanEntity> data) {
        super(R.layout.view_inventory_item_layout, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, CheckListBeanEntity item) {
        helper.setText(R.id.tv_check_name, item.getChkName());
        helper.setVisible(R.id.iv_dustbin,false);
        helper.setVisible(R.id.tv_done_state, false);
    }
}






