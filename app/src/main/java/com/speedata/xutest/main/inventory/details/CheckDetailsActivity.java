package com.speedata.xutest.main.inventory.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.speedata.xutest.R;
import com.speedata.xutest.base.BaseActivity;
import com.speedata.xutest.datebase.CheckListBeanEntity;
import com.speedata.xutest.datebase.EqListBean;
import com.speedata.xutest.datebase.GreenDaoManager;
import com.speedata.xutest.datebase.ProjListBean;
import com.speedata.xutest.datebase.UploadRptChkInfoListEntity;
import com.speedata.xutest.inventory.TakeInventoryActivity;
import com.speedata.xutest.utils.ToastUtils;
import com.speedata.xutest.widget.TextEditView;

import java.util.List;

/**
 * @author :Xu in  2017/9/20 20:00.
 *         联系方式:QQ:2419646399
 *         功能描述:盘点单详情
 */
public class CheckDetailsActivity extends BaseActivity implements View.OnClickListener {

    //使用的text+edit控件
    private CheckListBeanEntity mEntity;
    private String chkid;

    private TextEditView tevCheckName;
    private TextEditView tevBuildTime;
    private TextEditView tevBuildPerson;
    private TextEditView tevCheckPerson;
    private CheckBox cbAll;
    private CheckBox cbRoom;
    private Button btnCheck;
    private TextView tvRoomMessage;

    private boolean isEq;


    private static final String INTENT_NAME = "cid";

    public static void  start(Context context,  CheckListBeanEntity checkListBeanEntity) {
        Intent intent = new Intent(context, CheckDetailsActivity.class);
        intent.putExtra(INTENT_NAME, checkListBeanEntity);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEntity = (CheckListBeanEntity) getIntent().getSerializableExtra(INTENT_NAME);
        setView();
    }

    @Override
    protected int getActLayoutId() {
        return R.layout.activity_check_details;
    }



    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tevCheckName = findViewById(R.id.tev_check_name);
        tevBuildTime = findViewById(R.id.tev_build_time);
        tevBuildPerson = findViewById(R.id.tev_build_person);
        tevCheckPerson = findViewById(R.id.tev_check_person);
        tvRoomMessage = findViewById(R.id.tv_room_message);

        cbAll = findViewById(R.id.cb_scope_content);
        cbRoom = findViewById(R.id.cb_room_content);
        btnCheck = findViewById(R.id.btn_checking);
        btnCheck.setOnClickListener(this);

    }


    private void setView() {

        tevCheckName.setViewTitle(R.string.tev_check_name);
        tevCheckName.setViewContent(mEntity.getChkName());
        tevCheckName.setViewEnable(false);

        tevBuildTime.setViewTitle(R.string.tev_build_time);
        tevBuildTime.setViewContent(mEntity.getCreateTime());
        tevBuildTime.setViewEnable(false);

        tevBuildPerson.setViewTitle(R.string.tev_build_person);
        tevBuildPerson.setViewContent(mEntity.getCreateAccount());
        tevBuildPerson.setViewEnable(false);

        tevCheckPerson.setViewTitle(R.string.tev_check_person);
        tevCheckPerson.setViewContent(mEntity.getChkAccount());
        tevCheckPerson.setViewEnable(false);



        List<EqListBean> eqList = mEntity.getEqList();
        List<ProjListBean> projList = mEntity.getProjList();
        if (eqList.size() != 0){ //资产范围
            isEq = true;
            tvRoomMessage.setVisibility(View.GONE);
            cbAll.setChecked(true);
            cbAll.isChecked();
        }
        if (projList.size() != 0){ //资产位置
            isEq = false;
            String cbText = "按照位置盘点：" + projList.size() + "个库房";
            cbRoom.setText(cbText);
            cbRoom.setChecked(true);
            cbRoom.isChecked();
            //显示位置：
            StringBuilder message = new StringBuilder();
            for (int i = 0; i < projList.size(); i++){
                message.append(GreenDaoManager.getProjName(projList.get(i).getProjId())).append("  ");
            }
            tvRoomMessage.setText(message);
        }
        cbAll.setEnabled(false);
        cbRoom.setEnabled(false);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_checking:

                //查一下是否在已盘点数据库中，如果在不允许进入，要求先操作已盘点数据
                UploadRptChkInfoListEntity uploadRptChkInfoListEntity = GreenDaoManager.getUploadRptChkInfoByChkid(mEntity.getChkId());
                if (uploadRptChkInfoListEntity != null){
                    ToastUtils.showShortToastSafe("当前盘点单已被盘点，请到“已盘点”中查看");
                    return;
                }

                //进入盘点页
                TakeInventoryActivity.start(this, mEntity, isEq, false);
                break;

                default:
                    break;
        }

    }
}
