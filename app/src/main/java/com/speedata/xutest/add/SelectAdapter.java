package com.speedata.xutest.add;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.speedata.xutest.R;

import java.util.List;

/**
 * @author :Reginer in  2017/9/22 16:09.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class SelectAdapter extends BaseQuickAdapter<SelectEntity, BaseViewHolder> {
    SelectAdapter(@Nullable List<SelectEntity> data) {
        super(R.layout.view_select_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectEntity item) {
        helper.setText(R.id.tv_show, item.getShow());
    }
}
