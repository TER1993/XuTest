package com.speedata.xutest.main.inventory.checked;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.speedata.xutest.R;
import com.speedata.xutest.base.BaseMvpFragment;
import com.speedata.xutest.datebase.GreenDaoManager;
import com.speedata.xutest.datebase.UploadRptChkInfoListEntity;
import com.speedata.xutest.inventory.TakeInventoryActivity;
import com.speedata.xutest.utils.ToastUtils;

import java.util.List;

/**
 * Created by xu on 2017/9/21.
 *  根据盘点结果显示当前已保存的盘点单
 */

public class InventoryDoneFragment extends BaseMvpFragment<InventoryDoneFragment, InventoryDonePresenterImpl> implements IInventoryDoneCheckView, BaseQuickAdapter.OnItemChildClickListener {

    private DoneAdapter mAdapter;
    private AlertDialog mDialog;
    private TextView tvMessage;
    private UploadRptChkInfoListEntity uploadRptChkInfoListEntity;
    public InventoryDoneFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_inventory_done;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getCheckListBean();
        uploadRptChkInfoListEntity = new UploadRptChkInfoListEntity();
    }

    @Override
    protected void initView(View view, @Nullable Bundle savedInstanceState) {
        mAdapter = new DoneAdapter(null);
        RecyclerView recyclerView = view.findViewById(R.id.rv_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemChildClickListener(this);

    }

    @Override
    protected InventoryDonePresenterImpl createPresenter() {

        return new InventoryDonePresenterImpl();
    }

    @Override
    public void completeGetCheckListbean(List<UploadRptChkInfoListEntity> entity) {
        //从获取的list显示内容
        if (entity == null){
            ToastUtils.showShortToast("没有数据");
            return;
        }

        mAdapter.replaceData(entity);

    }

    /**
     * 退出时的对话框的按钮点击事件
     */
    private class DialogButtonOnClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE: // 确定

                    mDialog.dismiss();

                    GreenDaoManager.delInventory(uploadRptChkInfoListEntity);

                    mPresenter.getCheckListBean();

                    break;
                case DialogInterface.BUTTON_NEGATIVE: // 取消
                    // 取消显示对话框
                    mDialog.dismiss();

                    break;
            }
        }
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.iv_dustbin:

                DialogButtonOnClickListener dialogButtonOnClickListener = new DialogButtonOnClickListener();
                tvMessage = new TextView(mContext);
                uploadRptChkInfoListEntity = mAdapter.getData().get(position);
                boolean upload = mAdapter.getData().get(position).getUploadAlready();
                String uploadtext;
                if (upload){
                    uploadtext = "已上传";
                }else {
                    uploadtext = "未上传";
                }
                String message = "\n      当前盘点单状态：" + uploadtext + "\n\n" + "      确定要删除此盘点单吗？";
                tvMessage.setText(message);
                mDialog = new AlertDialog.Builder(mContext)
                        .setTitle(mAdapter.getData().get(position).getChechName())
                        .setView(tvMessage)
                        .setPositiveButton(R.string.sure, dialogButtonOnClickListener)
                        .setNegativeButton(R.string.miss, dialogButtonOnClickListener)
                        .show();

                break;

            case R.id.tv_check_name: {

                UploadRptChkInfoListEntity mEntity = mAdapter.getData().get(position); //根据当前选择进行数据整理

                TakeInventoryActivity.start(this.getContext(), mEntity.getChechName(), mEntity.getChkAccount(), mEntity.getId(), mEntity.getChkId(), true, true);
            }
                break;


            case R.id.tv_done_state: {

                UploadRptChkInfoListEntity mEntity = mAdapter.getData().get(position); //根据当前选择进行数据整理

                TakeInventoryActivity.start(this.getContext(), mEntity.getChechName(), mEntity.getChkAccount(), mEntity.getId(), mEntity.getChkId(), true, true);
            }
                break;

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getCheckListBean();
    }
}
