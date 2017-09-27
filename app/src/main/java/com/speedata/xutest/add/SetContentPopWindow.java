package com.speedata.xutest.add;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.speedata.utils.ToolCommon;
import com.speedata.xutest.R;
import com.speedata.xutest.datebase.CateListEntity;
import com.speedata.xutest.datebase.DeptListEntity;
import com.speedata.xutest.datebase.GreenDaoManager;
import com.speedata.xutest.datebase.ProjListEntity;
import com.speedata.xutest.datebase.StatusListEntity;
import com.speedata.xutest.datebase.SupplierListEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :Reginer in  2017/9/22 16:01.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
class SetContentPopWindow extends PopupWindow {
    SetContentPopWindow(AppCompatActivity context, IAddView iAddView, int id) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View mView = inflater.inflate(R.layout.view_set_content_layout, new LinearLayout(context), false);
        RecyclerView mRecyclerView = mView.findViewById(R.id.rv_contracts_filter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        SelectAdapter mAdapter = new SelectAdapter(null);
        mRecyclerView.setAdapter(mAdapter);
        List<SelectEntity> mList = new ArrayList<>();
        switch (id) {

            case R.id.av_assets_status:
                List<StatusListEntity> listEntity = GreenDaoManager.getInstance().getDao().getStatusListEntityDao().loadAll();
                for (int i = 0; i < listEntity.size(); i++) {
                    mList.add(new SelectEntity(listEntity.get(i).getStatusId(), listEntity.get(i).getStatusName()));
                }
                break;
            case R.id.av_gy_name:
                List<SupplierListEntity> listSupplierListEntity = GreenDaoManager.getInstance().getDao().getSupplierListEntityDao().loadAll();
                for (int i = 0; i < listSupplierListEntity.size(); i++) {
                    mList.add(new SelectEntity(listSupplierListEntity.get(i).getSupplierId(), listSupplierListEntity.get(i).getSupplierName()));
                }
                break;
            case R.id.av_assets_location:
                List<ProjListEntity> listEntityList = GreenDaoManager.getInstance().getDao().getProjListEntityDao().loadAll();
                for (int i = 0; i < listEntityList.size(); i++) {
                    mList.add(new SelectEntity(listEntityList.get(i).getProjId(), listEntityList.get(i).getProjName()));
                }
                break;
            case R.id.av_assets_cate:
                List<CateListEntity> cateListEntities = GreenDaoManager.getInstance().getDao().getCateListEntityDao().loadAll();
                for (int i = 0; i < cateListEntities.size(); i++) {
                    mList.add(new SelectEntity(cateListEntities.get(i).getCid(), cateListEntities.get(i).getCategoryName()));
                }
                break;
            case R.id.av_dept:
                List<DeptListEntity> deptListEntities = GreenDaoManager.getInstance().getDao().getDeptListEntityDao().loadAll();
                for (int i = 0; i < deptListEntities.size(); i++) {
                    mList.add(new SelectEntity(deptListEntities.get(i).getDeptId(), deptListEntities.get(i).getDeptName()));
                }
                break;

            default:
                break;
        }
        mAdapter.replaceData(mList);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            iAddView.completeSelect(id, mList.get(position).getCode());
            dismiss();
        });
        this.setContentView(mView);
        this.setWidth(ToolCommon.dip2px(context, 200));
        this.setHeight(ToolCommon.dip2px(context, 300));
        this.setFocusable(true);
        this.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.bg_pop));
        mView.setOnTouchListener((v, event) -> {
            dismiss();
            v.performClick();
            return true;
        });

    }
}
