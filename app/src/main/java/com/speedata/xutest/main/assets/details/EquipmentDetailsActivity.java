package com.speedata.xutest.main.assets.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.speedata.xutest.R;
import com.speedata.xutest.base.BaseActivity;
import com.speedata.xutest.datebase.EquipmentListEntity;
import com.speedata.xutest.datebase.GreenDaoManager;
import com.speedata.xutest.utils.ViewSetUtils;


/**
 * @author :Reginer in  2017/9/20 20:00.
 *         联系方式:QQ:282921012
 *         功能描述:资产详情
 */
public class EquipmentDetailsActivity extends BaseActivity {

    private static final String INTENT_NAME = "eid";
    private String eid;
    private EquipmentListEntity mEntity;
    private TextView mTvNumber;
    private TextView mTvName;
    private TextView mTvStatus;
    private TextView mTvModel;
    private TextView mTvYear;
    private TextView mTvConfirmNo;
    private TextView mTvPrice;
    private TextView mTvDate;
    private TextView mTvWarrantyPeriod;
    private TextView mTvEquipmentSn;
    private TextView mTvFreqRange;
    private TextView mTvSid;
    private TextView mTvArchNo;
    private TextView mTvProId;
    private TextView mTvTotalAmount;
    private TextView mTvUser;
    private TextView mTvManufacturer;
    private TextView mTvEqMemo;
    private TextView mTvEqStatus;

    public static void start(Context context, String eid) {
        Intent intent = new Intent(context, EquipmentDetailsActivity.class);
        intent.putExtra(INTENT_NAME, eid);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_equipment_details);
        eid = getIntent().getStringExtra(INTENT_NAME);
    }

    @Override
    protected int getActLayoutId() {
        return R.layout.activity_equipment_details;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mEntity = GreenDaoManager.getEquipmentByEid(eid);
        setView();
    }


    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mTvNumber = findViewById(R.id.tv_number);
        mTvName = findViewById(R.id.tv_name);
        mTvStatus = findViewById(R.id.tv_status);
        mTvModel = findViewById(R.id.tv_model);
        mTvYear = findViewById(R.id.tv_year);
        mTvConfirmNo = findViewById(R.id.tv_confirm_no);
        mTvPrice = findViewById(R.id.tv_price);
        mTvDate = findViewById(R.id.tv_date);
        mTvWarrantyPeriod = findViewById(R.id.tv_warranty_period);
        mTvEquipmentSn = findViewById(R.id.tv_equipment_sn);
        mTvFreqRange = findViewById(R.id.tv_freq_range);
        mTvSid = findViewById(R.id.tv_sid);
        mTvArchNo = findViewById(R.id.tv_arch_no);
        mTvProId = findViewById(R.id.tv_pro_id);
        mTvTotalAmount = findViewById(R.id.tv_total_amount);
        mTvUser = findViewById(R.id.tv_user);
        mTvManufacturer = findViewById(R.id.tv_manufacturer);
        mTvEqMemo = findViewById(R.id.tv_eq_memo);
        mTvEqStatus = findViewById(R.id.tv_eq_status);
    }

    private void setView() {
        if (mEntity != null) {
            mTvNumber.setText(String.format(mContext.getString(R.string.rfid_number), mEntity.getRfid()));
            mTvName.setText(String.format(mContext.getString(R.string.rfid_title), mEntity.getEquipmentTitle()));
            mTvStatus.setText(GreenDaoManager.getNameByStatus(mEntity.getEqStatus()));
            ViewSetUtils.setStatusText(mTvStatus,mEntity.getEqStatus());
            mTvModel.setText(String.format(getString(R.string.tv_model), mEntity.getModel()));
            mTvYear.setText(String.format(getString(R.string.tv_year), mEntity.getProjYear()));
            mTvConfirmNo.setText(String.format(getString(R.string.tv_confirm_no), mEntity.getConfirmNo()));
            mTvPrice.setText(String.format(getString(R.string.tv_price), mEntity.getUnitPrice()));
            mTvDate.setText(String.format(getString(R.string.tv_date), mEntity.getBuyDate()));
            mTvWarrantyPeriod.setText(String.format(getString(R.string.tv_warranty_period), mEntity.getWarrantyPeriod()));
            mTvEquipmentSn.setText(String.format(getString(R.string.tv_equipment_sn), mEntity.getEquipmentSn()));
            mTvFreqRange.setText(String.format(getString(R.string.tv_freq_range), mEntity.getFreqRange()));
            mTvSid.setText(String.format(getString(R.string.tv_sid), GreenDaoManager.getSupplierName(mEntity.getSid())));
            mTvArchNo.setText(String.format(getString(R.string.tv_arch_no), mEntity.getArchNo()));
            mTvProId.setText(String.format(getString(R.string.tv_pro_id), GreenDaoManager.getProjName(mEntity.getProjId())));
            mTvTotalAmount.setText(String.format(getString(R.string.tv_total_amount), mEntity.getTotolAmount()));
            mTvUser.setText(String.format(getString(R.string.tv_user), mEntity.getUser()));
            mTvManufacturer.setText(String.format(getString(R.string.tv_manufacturer), mEntity.getManufacturer()));
            mTvEqMemo.setText(String.format(getString(R.string.tv_eq_memo), mEntity.getEqMemo()));
            mTvEqStatus.setText(String.format(getString(R.string.tv_eq_status), GreenDaoManager.getNameByStatus(mEntity.getEqStatus())));
        }
    }
}
