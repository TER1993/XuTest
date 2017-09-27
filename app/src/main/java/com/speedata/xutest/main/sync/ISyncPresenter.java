package com.speedata.xutest.main.sync;

/**
 * @author :Reginer in  2017/9/20 15:00.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public interface ISyncPresenter {
    void loadData(boolean loadAssets, boolean loadUser, boolean loadLocation, boolean loadStatus, boolean loadSupplier,
                  boolean loadDept, boolean uploadAssets);
}
