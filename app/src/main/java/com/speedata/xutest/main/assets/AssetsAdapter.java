package com.speedata.xutest.main.assets;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.speedata.xutest.R;
import com.speedata.xutest.datebase.EquipmentListEntity;
import com.speedata.xutest.datebase.GreenDaoManager;
import com.speedata.xutest.utils.ViewSetUtils;

import java.util.List;

/**
 * @author :Reginer in  2017/9/20 13:48.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class AssetsAdapter extends BaseQuickAdapter<EquipmentListEntity, BaseViewHolder> {
    AssetsAdapter(@Nullable List<EquipmentListEntity> data) {
        super(R.layout.view_assets_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EquipmentListEntity item) {
        helper.setText(R.id.tv_name, String.format(mContext.getString(R.string.rfid_title), item.getEquipmentTitle()));
        helper.setText(R.id.tv_number, String.format(mContext.getString(R.string.rfid_number), item.getRfid()));
        helper.setText(R.id.tv_status, GreenDaoManager.getNameByStatus(item.getEqStatus()));
        ViewSetUtils.setStatusText(helper.getView(R.id.tv_status), item.getEqStatus());
    }
}
