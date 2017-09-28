package com.speedata.xutest.main.inventory;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.speedata.xutest.R;
import com.speedata.xutest.base.BaseMvpFragment;
import com.speedata.xutest.datebase.GreenDaoManager;
import com.speedata.xutest.main.inventory.details.CheckDetailsActivity;
import com.speedata.xutest.utils.ToastUtils;

/**
 * @author :Reginer in  2017/9/18 18:58.
 *         联系方式:QQ:282921012
 *         功能描述:盘点
 */
public class InventoryFragment extends BaseMvpFragment<InventoryFragment, CheckPresenterImpl> implements ICheckView, View.OnClickListener, BaseQuickAdapter.OnItemClickListener {

    private CheckAdapter mAdapter;
    private Button btnUpdate;
    private boolean update;

    public InventoryFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_inventory;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getCheckListBean();
    }


    @Override
    protected void initView(View view, @Nullable Bundle savedInstanceState) {

        update = false;
        btnUpdate = view.findViewById(R.id.btn_update_check);
        btnUpdate.setOnClickListener(this);

        mAdapter = new CheckAdapter(null);
        RecyclerView recyclerView = view.findViewById(R.id.rv_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.btn_update_check: //更新盘点任务
               mPresenter.getCheckListBean();
               update = true;
               break;
       }
    }



    @Override
    public void completeGetCheckListbean(Throwable e, CheckListEntity entity) {
        if (e != null) {
            ToastUtils.showShortToastSafe(Log.getStackTraceString(e));
            return;
        }
        if ("1".equals(entity.getErrCode())) {
            mAdapter.replaceData(entity.getCheckListBean());
            GreenDaoManager.saveCheckListBean(entity.getCheckListBean());
            if (update){
                ToastUtils.showShortToastSafe("下载" + entity.getCheckListBean().size() + "个盘点任务");
                update = false;
            }
        } else {
            ToastUtils.showShortToastSafe(entity.getErrMsg());
        }
    }

    @Override
    protected CheckPresenterImpl createPresenter() {
        return new CheckPresenterImpl();
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        CheckDetailsActivity.start(mContext, mAdapter.getData().get(position).getChkId());
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getCheckListBean();
    }
}
