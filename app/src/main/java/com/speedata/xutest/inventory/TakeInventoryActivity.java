package com.speedata.xutest.inventory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.speedata.libuhf.IUHFService;
import com.speedata.libuhf.UHFManager;
import com.speedata.libuhf.bean.Tag_Data;
import com.speedata.utils.MyDateAndTime;
import com.speedata.xutest.R;
import com.speedata.xutest.base.AppFid;
import com.speedata.xutest.base.BaseMvpActivity;
import com.speedata.xutest.datebase.EqListBean;
import com.speedata.xutest.datebase.EqListEntity;
import com.speedata.xutest.datebase.EquipmentListEntity;
import com.speedata.xutest.datebase.GreenDaoManager;
import com.speedata.xutest.datebase.ProjListBean;
import com.speedata.xutest.datebase.UploadRptChkInfoListEntity;
import com.speedata.xutest.main.assets.details.EquipmentDetailsActivity;
import com.speedata.xutest.net.Constant;
import com.speedata.xutest.utils.DeviceUtils;
import com.speedata.xutest.utils.Logcat;
import com.speedata.xutest.utils.SPUtils;
import com.speedata.xutest.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :Reginer in  2017/9/22 12:07.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class TakeInventoryActivity extends BaseMvpActivity<TakeInventoryActivity, TakePresenterImpl> implements ITakeView, BaseQuickAdapter.OnItemClickListener, View.OnClickListener, IUHFService.Listener {

    private TextView tvName;
    private TextView tvAccount;
    private TextView tvAssets;
    private TextView tvTime;

    private TextView tvStart;
    private TextView tvOver;


    private ImageButton ibStart; //开始
    private ImageButton ibOver; //结束
    private Button btnUpload; //上传
    private TextView tvTagTotal; //已扫描到标签数
    private int mTagTotal;
    private TextView tvOverage; //盘盈
    private int mOverage;
    private TextView tvLoss; //盘亏
    private int mLoss; //其他基本是+1，它是扫到后-1，但是盈的不算
    private int mInitTotal; //初始总数


    private String mName; //盘点单名称
    private String mAccount; //盘点人
    private String mTotal; //资产总数
    private String mTime; //盘点时间
    private Long mID; //盘点单id，根据他找到list并加载
    private String mChkid; //盘点单chkid，盘点单主要的属性
    private boolean mIsEq; //判断是有Eqlist有设备Eid还是projlist有库房的位置id
    private boolean mIsDone; //判断是否是已盘点的盘点单进来

    //两种情况2种list
    private List<EqListBean> eqListBeanlist;
    private List<ProjListBean> projListBeanlist;

    private List<EquipmentListEntity> mList;

    private TakeInventoryAdapter mAdapter;

    private static String TAG = "inventory";

    private IUHFService mUhfService;

    private String mEPC = ""; //记录扫描结果，重复的不查数据库


    /**
     * start。
     *
     * @param context context
     * @param name    盘点单名称
     * @param user    盘点人
     */
    public static void start(Context context, String name, String user, Long id, String chkid, boolean iseq, boolean isdone) {
        Intent intent = new Intent(context, TakeInventoryActivity.class);
        intent.putExtra(NAME, name);
        intent.putExtra(USER, user);
        intent.putExtra(ID, id);
        intent.putExtra(CHKID, chkid);
        intent.putExtra(ISEQ, iseq);
        intent.putExtra(ISDONE, isdone);

        context.startActivity(intent);
    }

    private static final String NAME = "name";
    private static final String USER = "user";
    private static final String ID = "id";
    private static final String CHKID = "chkid";
    private static final String ISEQ = "iseq";
    private static final String ISDONE = "isdone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_inventory);
        mName = getIntent().getStringExtra(NAME);
        mAccount = getIntent().getStringExtra(USER);
        mIsEq = getIntent().getBooleanExtra(ISEQ, false);
        mID = getIntent().getLongExtra(ID, -1);
        mChkid = getIntent().getStringExtra(CHKID);
        mIsDone = getIntent().getBooleanExtra(ISDONE, false);

        try {
            mUhfService = UHFManager.getUHFService(this);
        } catch (Exception e) {
            ToastUtils.showShortToastSafe(R.string.rfid_exception);
        }

        setView(); //显示内容初始化
    }

    @Override
    protected int getActLayoutId() {
        return R.layout.activity_inventory;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        //资产总数应该是所有 Eid x 数量 。 资产位置模式盘点并不知道总量。
        //显示的是所有需要盘点的资产列表 。 资产位置模式不知道要盘的数据是什么。
        tvName = findViewById(R.id.tv_inventory_name);
        tvAccount = findViewById(R.id.tv_inventory_account);
        tvAssets = findViewById(R.id.tv_inventory_assets);
        tvTime = findViewById(R.id.tv_inventory_time);

        tvStart = findViewById(R.id.tv_upload_start);
        tvOver = findViewById(R.id.tv_upload_over);

        ibStart = findViewById(R.id.ib_start);
        ibOver = findViewById(R.id.ib_over);
        btnUpload = findViewById(R.id.btn_inventory_upload);
        tvTagTotal = findViewById(R.id.tv_tag_total);
        tvOverage = findViewById(R.id.tv_overage);
        tvLoss = findViewById(R.id.tv_loss);

        ibStart.setOnClickListener(this);
        ibOver.setOnClickListener(this);
        btnUpload.setOnClickListener(this);

        mAdapter = new TakeInventoryAdapter(null);
        RecyclerView recyclerView = findViewById(R.id.rv_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);

    }

    @Override
    protected TakePresenterImpl createPresenter() {
        return new TakePresenterImpl();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void setView() {
        Logcat.d(TAG, "setView");

        String name = "盘点单名称：" + mName;
        tvName.setText(name);
        String account = "盘点人：" + mAccount;
        tvAccount.setText(account);
        mTime = MyDateAndTime.getTimeStringYMD();
        tvTime.setText(mTime);
        //初始化按钮状态显示
        ibOver.setEnabled(false);
        ibOver.setBackground(getDrawable(R.drawable.ic_stop_unclick));
        btnUpload.setEnabled(false);

        mList = new ArrayList<>();

        if (!mIsDone){
            //不是已盘点，就正常判断2种盘点方法

        if (mIsEq){ //有设备的Eid列表
            //根据id查eid设备列表
            eqListBeanlist = GreenDaoManager.getEqListBeanByUniqueNum(mID);

            //显示eqid对应的信息
            for (int i = 0; i < eqListBeanlist.size(); i++){
                EquipmentListEntity equipmentListEntity = GreenDaoManager.getEquipmentByEid(eqListBeanlist.get(i).getEqId());
                equipmentListEntity.setOverageOrLoss(0); //新的显示初始化后都是0，亏盈记录在保存的上传盘点单中
                mList.add(equipmentListEntity);
            }

            mInitTotal = mList.size();
            //得到了mList,显示它的内容
            mAdapter.replaceData(mList);

        } else { //有仓库的位置列表projlist
            //根据id查eid设备列表
            projListBeanlist = GreenDaoManager.getProjListBeanByUniqueNum(mID);
            //根据库房查资产

            //显示projid对应内容
            for (int i = 0; i < projListBeanlist.size(); i++){
                List<EquipmentListEntity> equipmentListEntity = GreenDaoManager.getEquipmentListByProjid(projListBeanlist.get(i).getProjId());
                mList.addAll(equipmentListEntity);
            }

            mInitTotal = mList.size();
            //mList是所有资产内容
            mAdapter.replaceData(mList);
        }

        //列表显示完了，则先显示盘亏这一条为list.size
        mTotal = "资产总数：" + mInitTotal;
        tvAssets.setText(mTotal);
        mLoss = mInitTotal;
        tvLoss.setText(String.valueOf(mLoss));

        } else { //从已盘点页面进来，不需要开始结束再盘点。按需保留上传按钮即可

            UploadRptChkInfoListEntity listEntities = new UploadRptChkInfoListEntity();
            listEntities = GreenDaoManager.getUploadRptChkInfoByChkid(mChkid); //当前的
            List<EqListEntity> eqList = listEntities.getEqList(); //获取子list信息

            mTime = listEntities.getChkDate();
            tvTime.setText(mTime);

            //初始化按钮状态显示
            ibStart.setBackground(getDrawable(R.drawable.ic_start_unclick));
            ibStart.setEnabled(false);
            ibOver.setEnabled(false);
            ibOver.setBackground(getDrawable(R.drawable.ic_stop_unclick));

            //更改显示内容
            ibStart.setVisibility(View.GONE);
            ibOver.setVisibility(View.GONE);
            tvStart.setText("上传情况：");

            if (listEntities.getUploadAlready()){
                btnUpload.setEnabled(false);
                btnUpload.setBackgroundColor(getResources().getColor(R.color.color_dark_button));
                tvOver.setText("已上传");

            } else {
                btnUpload.setEnabled(true);
                tvOver.setText("未上传");
            }

            for (int i = 0; i < eqList.size(); i++){
                EquipmentListEntity equipmentListEntity = GreenDaoManager.getEquipmentByEid(eqList.get(i).getEid());
                mList.add(equipmentListEntity);
            }

            mInitTotal = Integer.parseInt(listEntities.getAllCount());
            //mList是所有资产内容
            mAdapter.replaceData(mList);

            mTotal = "资产总数：" + mInitTotal;
            tvAssets.setText(mTotal);
            mLoss = Integer.parseInt(listEntities.getInventoryShortagesCount());
            tvLoss.setText(String.valueOf(mLoss));
            mOverage = Integer.parseInt(listEntities.getInventoryProfitCount());
            tvOverage.setText(String.valueOf(mOverage));
            mTagTotal = Integer.parseInt(listEntities.getChkAllCount());
            tvTagTotal.setText(String.valueOf(mTagTotal));

        }
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        EquipmentDetailsActivity.start(mContext, mAdapter.getData().get(position).getEid());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_start: //开始盘点按钮，开始盘点
                //先修改按钮状态
                ibStart.setBackground(getDrawable(R.drawable.ic_start_unclick));
                ibStart.setEnabled(false);
                ibOver.setBackground(getDrawable(R.drawable.ic_stop));
                ibOver.setEnabled(true);

                //再启动service
                new Thread(() -> {
                    mUhfService.OpenDev();
                    mUhfService.inventory_start();
                }).start();
                mUhfService.setListener(this);

                break;

            case R.id.ib_over: //结束盘点按钮，结束盘点

                ibStart.setBackground(getDrawable(R.drawable.ic_start));
                ibStart.setEnabled(true);
                ibOver.setBackground(getDrawable(R.drawable.ic_stop_unclick));
                ibOver.setEnabled(false);

                btnUpload.setEnabled(true);

                mEPC = ""; //结束后清掉EPC记录
                new Thread(() -> {
                    mUhfService.inventory_stop();
                    mUhfService.CloseDev();
                }).start();

                //点击结束然后开始整理数据，并保存待上传盘点单
                collatingdata();

                break;

            case R.id.btn_inventory_upload: //上传按钮，上传盘点数据
                //根据已保存的盘点单，从数据库中查询并上传当前盘点单

                uploadInventory(mChkid);

                break;

        }
    }

    private void uploadInventory(String mChkid) {

        //待上传的信息
        UploadRptChkInfoListEntity entity = new UploadRptChkInfoListEntity();
        entity = GreenDaoManager.getUploadRptChkInfoByChkid(mChkid);
        entity.getEqList(); //至此得到了要上传的数据

        Logcat.d(TAG, new Gson().toJson(entity));
        mPresenter.uploadInventory(entity, null);

    }

    private void collatingdata() {
        UploadRptChkInfoListEntity uploadRptChkInfoListEntity = new UploadRptChkInfoListEntity();

        String usertaken = (String) SPUtils.get(this, Constant.TOKEN, "");
        uploadRptChkInfoListEntity.setUserToken(usertaken);
        uploadRptChkInfoListEntity.setDeviceId(DeviceUtils.getAndroidID(AppFid.getInstance()));
        uploadRptChkInfoListEntity.setChkId(mChkid);
        uploadRptChkInfoListEntity.setAllCount(mInitTotal + "");
        uploadRptChkInfoListEntity.setChkAllCount(mTagTotal + "");
        uploadRptChkInfoListEntity.setInventoryProfitCount(mOverage + "");
        uploadRptChkInfoListEntity.setInventoryShortagesCount(mLoss + "");
        uploadRptChkInfoListEntity.setChkDate(mTime);
        uploadRptChkInfoListEntity.setChkAccount(mAccount);
        uploadRptChkInfoListEntity.setChechName(mName);

        //先保存生成id
        GreenDaoManager.saveUploadRptChkInfo(uploadRptChkInfoListEntity);

        Long uniqueNum = GreenDaoManager.getUploadRptChkInfoByChkid(mChkid).getId();

        //整理list
        List<EqListEntity> eqListEntity = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++){
            EqListEntity eqListEntity1 = new EqListEntity();
            eqListEntity1.setUniqueNum(uniqueNum);
            eqListEntity1.setEid(mList.get(i).getEid());
            eqListEntity1.setRfid(mList.get(i).getRfid());
            eqListEntity1.setChkStatus(mList.get(i).getOverageOrLoss() + "");
            eqListEntity.add(eqListEntity1);
        }

        //得到符合标准的Eqlist将他保存
        GreenDaoManager.saveEqListEntity(eqListEntity);
        //至此保存了待上传盘点单
    }

    @Override
    public void update(Tag_Data var1) {
        //处理扫描到的数据

        if (!TextUtils.isEmpty(var1.epc) && !(var1.epc).equals(mEPC)) {
            boolean isInList = false; //默认不在
           //判断扫到的结果符合要求，则查数据库。有则变成正常，没有则为盘盈。先查mList
            for (int i = 0; i < mList.size(); i++ ){
                if ((var1.epc).equals(mList.get(i).getRfid())){ //找到了就修改mList中的对应的状态为正常以及其他对应的记录

                    //判断一下是否盘过了，就在这里判断即可，因为mList会更新
                    if (mList.get(i).getOverageOrLoss() != 0){
                        //盘过了，不向下进行
                        new Handler(Looper.getMainLooper()).post(() -> ToastUtils.showShortToast("此标签已盘点过了"));

                        mEPC = var1.epc;
                        return;
                    }

                    mList.get(i).setOverageOrLoss(2); //0亏1盈2正常
                    mTagTotal++;
                    new Handler(Looper.getMainLooper()).post(() -> tvTagTotal.setText(String.valueOf(mTagTotal)));
                    mLoss--;
                    new Handler(Looper.getMainLooper()).post(() -> tvLoss.setText(String.valueOf(mLoss)));
                    new Handler(Looper.getMainLooper()).post(() -> mAdapter.replaceData(mList));
                    isInList = true;
                    break;
                }
            }

            if (!isInList){ //for循环跑完没找到就查数据库添加这一项并先修改这一项的状态为盘盈再添加
                EquipmentListEntity equipmentListEntity = GreenDaoManager.getEquipmentByRfid(var1.epc);
                //判断一下标签不在数据库中，实际使用应该不会发生
                if (equipmentListEntity == null){

                    new Handler(Looper.getMainLooper()).post(() -> ToastUtils.showShortToast("此标签不在资产范围内"));

                    //此为盘盈，做个显示即可
                    equipmentListEntity = new EquipmentListEntity();
                    equipmentListEntity.setEid("0");
                    equipmentListEntity.setRfid(var1.epc);
                    equipmentListEntity.setEquipmentTitle("无相关设备");

                }
                equipmentListEntity.setOverageOrLoss(1); //盘盈
                mList.add(equipmentListEntity);
                mTagTotal++;
                new Handler(Looper.getMainLooper()).post(() -> tvTagTotal.setText(String.valueOf(mTagTotal)));
                mOverage++;
                new Handler(Looper.getMainLooper()).post(() -> tvOverage.setText(String.valueOf(mOverage)));
                new Handler(Looper.getMainLooper()).post(() -> mAdapter.replaceData(mList));
            }

            mEPC = var1.epc;
        }

    }


    @Override
    public void completeUploadRptChkInfo(Throwable e, UploadRptChkInfoListEntity entity) {
        if (e != null) {
            ToastUtils.showShortToastSafe(Log.getStackTraceString(e));
            return;
        }
        if (entity.getUploadAlready()) {
            ToastUtils.showShortToastSafe("上传成功");
            //操作数据库 mID
            GreenDaoManager.delCheckListById(mID);

        } else {
            ToastUtils.showShortToastSafe("上传失败");
        }

    }
}
