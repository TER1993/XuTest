package com.speedata.xutest.add;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.speedata.libuhf.IUHFService;
import com.speedata.libuhf.UHFManager;
import com.speedata.libuhf.bean.Tag_Data;
import com.speedata.xutest.R;
import com.speedata.xutest.base.BaseMvpActivity;
import com.speedata.xutest.utils.ToastUtils;

import java.util.Calendar;

/**
 * @author :Reginer in  2017/9/21 15:37.
 *         联系方式:QQ:282921012
 *         功能描述:添加资产信息
 */
public class AddAssetsActivity extends BaseMvpActivity<AddAssetsActivity, AddPresenterImpl> implements IAddView,
        IUHFService.Listener, View.OnClickListener {
    private AddAssetsView mAvDzCode;
    private AddAssetsView mAvSbName;
    private AddAssetsView mAvSbModel;
    private TextView mAvLxYear;
    private AddAssetsView mAvQrNumber;
    private AddAssetsView mAvSbPrice;
    private TextView mAvHtDate;
    private AddAssetsView mAvZbDate;
    private AddAssetsView mAvChNumber;
    private AddAssetsView mAvPlArea;
    private TextView mAvGyName;
    private TextView mAvAssetsCate;
    private AddAssetsView mAvDaNumber;
    private TextView mAvAssetsLocation;
    private TextView mAvDept;
    private AddAssetsView mAvAssetsCount;
    private AddAssetsView mAvGlPeople;
    private AddAssetsView mAvScName;
    private TextView mAvAssetsStatus;
    private AddAssetsView mAvAssetsMark;

    private IUHFService mUhfService;


    private String assentStatus;
    private String avGyName;
    private String avAssetsLocation;
    private String avAssetsCate;
    private String avDept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_assets);
        try {
            mUhfService = UHFManager.getUHFService(this);
        } catch (Exception e) {
            ToastUtils.showShortToastSafe(R.string.rfid_exception);
        }

    }

    @Override
    protected int getActLayoutId() {
        return R.layout.activity_add_assets;
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Thread(() -> {
            mUhfService.OpenDev();
            mUhfService.inventory_start();
        }).start();
        mUhfService.setListener(this);
    }

    @Override
    protected void onStop() {
        new Thread(() -> {
            mUhfService.inventory_stop();
            mUhfService.CloseDev();
        }).start();
        super.onStop();
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mAvDzCode = findViewById(R.id.av_dz_code);
        mAvSbName = findViewById(R.id.av_sb_name);
        mAvSbModel = findViewById(R.id.av_sb_model);
        mAvLxYear = findViewById(R.id.av_lx_year);
        mAvLxYear.setOnClickListener(this);
        mAvQrNumber = findViewById(R.id.av_qr_number);
        mAvSbPrice = findViewById(R.id.av_sb_price);
        mAvHtDate = findViewById(R.id.av_ht_date);
        mAvHtDate.setOnClickListener(this);
        mAvZbDate = findViewById(R.id.av_zb_date);
        mAvChNumber = findViewById(R.id.av_ch_number);
        mAvPlArea = findViewById(R.id.av_pl_area);
        mAvGyName = findViewById(R.id.av_gy_name);
        mAvGyName.setOnClickListener(this);
        mAvAssetsCate = findViewById(R.id.av_assets_cate);
        mAvAssetsCate.setOnClickListener(this);
        mAvDaNumber = findViewById(R.id.av_da_number);
        mAvAssetsLocation = findViewById(R.id.av_assets_location);
        mAvAssetsLocation.setOnClickListener(this);
        mAvDept = findViewById(R.id.av_dept);
        mAvDept.setOnClickListener(this);
        mAvAssetsCount = findViewById(R.id.av_assets_count);
        mAvGlPeople = findViewById(R.id.av_gl_people);
        mAvScName = findViewById(R.id.av_sc_name);
        mAvAssetsStatus = findViewById(R.id.av_assets_status);
        mAvAssetsStatus.setOnClickListener(this);
        mAvAssetsMark = findViewById(R.id.av_assets_mark);
        findViewById(R.id.btn_upload).setOnClickListener(this);
    }

    @Override
    protected AddPresenterImpl createPresenter() {
        return new AddPresenterImpl();
    }

    @Override
    public void update(Tag_Data var1) {
        if (!TextUtils.isEmpty(var1.epc) && TextUtils.isEmpty(mAvDzCode.getText())) {
            new Handler(Looper.getMainLooper()).post(() -> mAvDzCode.setText(var1.epc));
        }
    }

    @Override
    public void onClick(View v) {
        SetContentPopWindow popWindow;
        switch (v.getId()) {
            case R.id.btn_upload:
                mPresenter.commit(mAvDzCode.getText(), mAvSbName.getText(), mAvSbModel.getText(), mAvLxYear.getText().toString(),
                        mAvQrNumber.getText(), mAvSbPrice.getText(), mAvHtDate.getText().toString(), mAvZbDate.getText()
                        , mAvChNumber.getText(), mAvPlArea.getText(), avGyName, mAvDaNumber.getText()
                        , avAssetsLocation, mAvAssetsCount.getText(), mAvGlPeople.getText()
                        , mAvScName.getText(), assentStatus, mAvAssetsMark.getText(),
                        avAssetsCate, avDept);
                break;
            case R.id.av_lx_year:
                showDataDialog(R.id.av_lx_year);
                break;
            case R.id.av_ht_date:
                showDataDialog(R.id.av_ht_date);
                break;
            case R.id.av_assets_status:
                popWindow = new SetContentPopWindow(this, this, R.id.av_assets_status);
                popWindow.showAtLocation(mAvAssetsStatus, Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
            case R.id.av_gy_name:
                popWindow = new SetContentPopWindow(this, this, R.id.av_gy_name);
                popWindow.showAtLocation(mAvGyName, Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
            case R.id.av_assets_location:
                popWindow = new SetContentPopWindow(this, this, R.id.av_assets_location);
                popWindow.showAtLocation(mAvAssetsLocation, Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
            case R.id.av_assets_cate:
                popWindow = new SetContentPopWindow(this, this, R.id.av_assets_cate);
                popWindow.showAtLocation(mAvAssetsCate, Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
            case R.id.av_dept:
                popWindow = new SetContentPopWindow(this, this, R.id.av_dept);
                popWindow.showAtLocation(mAvDept, Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
        }
    }

    @Override
    public void completeCommit(int code, AddResultEntity entity, Throwable throwable) {
        if (code == 1) {
            //保存到数据库
            ToastUtils.showShortToastSafe(R.string.save_successful);
        } else {
            //联网上传
            if (entity != null && "1".equals(entity.getErrCode())) {
                ToastUtils.showShortToastSafe(R.string.upload_successful);
            } else {
                ToastUtils.showShortToastSafe(throwable != null ? Log.getStackTraceString(throwable) :
                        entity != null ? entity.getErrMsg() : getString(R.string.upload_failed));
            }
        }
    }

    @Override
    public void completeSelect(int id, SelectEntity content) {
        switch (id) {
            case R.id.av_assets_status:
                if (!content.getCode().equals("5")) {
                    mAvDept.setText("");
                    avDept = "0";
                }
                if (!content.getCode().equals("1")) {
                    mAvAssetsLocation.setText("");
                    avAssetsLocation = "0";
                }
                assentStatus = content.getCode();
                mAvAssetsStatus.setText(content.getShow());
                break;
            case R.id.av_gy_name:
                avGyName = content.getCode();
                mAvGyName.setText(content.getShow());
                break;
            case R.id.av_assets_location:
                avAssetsLocation = content.getCode();
                mAvAssetsLocation.setText(content.getShow());
                break;
            case R.id.av_assets_cate:
                avAssetsCate = content.getCode();
                mAvAssetsCate.setText(content.getShow());
                break;
            case R.id.av_dept:
                avDept = content.getCode();
                mAvDept.setText(content.getShow());
                break;

            default:
                break;
        }
    }

    /**
     * 显示日期选择器
     */
    private void showDataDialog(int id) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(AddAssetsActivity.this, AlertDialog.THEME_HOLO_LIGHT, (view, year, month, day) -> {
            switch (id) {
                case R.id.av_lx_year:
                    mAvLxYear.setText(String.valueOf(year));
                    break;
                case R.id.av_ht_date:
                    mAvHtDate.setText(String.valueOf(getString(R.string.year_month_day, year, (++month), day)));
                    break;

                default:
                    break;
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}
