package com.speedata.xutest.main.inventory.checked;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.speedata.xutest.R;
import com.speedata.xutest.datebase.UploadRptChkInfoListEntity;
import com.speedata.xutest.utils.ViewSetUtils;

import java.util.List;

/**
 * Created by xu on 2017/9/25.
 */

public class DoneAdapter extends BaseQuickAdapter<UploadRptChkInfoListEntity, BaseViewHolder> {

    public DoneAdapter(@Nullable List<UploadRptChkInfoListEntity> data) {
        super(R.layout.view_inventory_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UploadRptChkInfoListEntity item) {
        helper.setText(R.id.tv_check_name, item.getChechName());
        helper.addOnClickListener(R.id.tv_check_name);

        String uploadAlreadyText = "未传";
        if (item.getUploadAlready()) {
            uploadAlreadyText = "已传";
        } else if (!item.getUploadAlready()) {
            uploadAlreadyText = "未传";
        }

        helper.setText(R.id.tv_done_state, uploadAlreadyText);
        ViewSetUtils.setUploadAlreadyText(helper.getView(R.id.tv_done_state), item.getUploadAlready());

        helper.addOnClickListener(R.id.iv_dustbin);

    }
}
