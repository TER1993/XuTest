package com.speedata.xutest.main.assets;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.speedata.xutest.R;
import com.speedata.xutest.base.BaseMvpFragment;
import com.speedata.xutest.datebase.EquipmentListEntity;
import com.speedata.xutest.datebase.GreenDaoManager;
import com.speedata.xutest.main.assets.details.EquipmentDetailsActivity;
import com.speedata.xutest.utils.ToastUtils;

import java.util.List;

/**
 * @author :Reginer in  2017/9/18 18:57.
 *         联系方式:QQ:282921012
 *         功能描述:资产
 */
public class AssetsFragment extends BaseMvpFragment<AssetsFragment, AssetsPresenterImpl> implements
        IAssetsView, BaseQuickAdapter.OnItemClickListener, OnRefreshListener, View.OnClickListener {

    private AssetsAdapter mAdapter;
    private SmartRefreshLayout mRefreshLayout;
    private EditText mEtName;

    public AssetsFragment() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_assets;
    }

    @Override
    protected void initView(View view, @Nullable Bundle savedInstanceState) {
        mAdapter = new AssetsAdapter(null);
        RecyclerView recyclerView = view.findViewById(R.id.rv_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mAdapter);
        mRefreshLayout = view.findViewById(R.id.srl_content);
        mEtName = view.findViewById(R.id.et_name);
        view.findViewById(R.id.img_search).setOnClickListener(this);
        mAdapter.setOnItemClickListener(this);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.autoRefresh();
    }


    @Override
    public void onResume() {
        super.onResume();
        mAdapter.replaceData(GreenDaoManager.getInstance().getDao().getEquipmentListEntityDao().loadAll());
    }

    @Override
    protected AssetsPresenterImpl createPresenter() {
        return new AssetsPresenterImpl();
    }

    @Override
    public void completeGetEquipmentList(Throwable e, AssetsEntity entity) {
        mRefreshLayout.finishRefresh();
        if (e != null) {
            ToastUtils.showShortToastSafe(Log.getStackTraceString(e));
            return;
        }
        if ("1".equals(entity.getErrCode())) {
            GreenDaoManager.saveAssetsList(entity.getEquipmentList());
            mAdapter.replaceData(GreenDaoManager.getInstance().getDao().getEquipmentListEntityDao().loadAll());
        } else {
            ToastUtils.showShortToastSafe(entity.getErrMsg());
        }
    }

    @Override
    public void completeQuery(List<EquipmentListEntity> listEntities) {
        mAdapter.replaceData(listEntities);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        EquipmentDetailsActivity.start(mContext, mAdapter.getData().get(position).getEid());
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.getEquipmentList();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_search:
                mPresenter.searchByTitle(mEtName.getText().toString().trim());
                break;

            default:
                break;
        }
    }
}
