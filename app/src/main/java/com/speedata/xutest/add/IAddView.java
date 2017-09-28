package com.speedata.xutest.add;

/**
 * @author :Reginer in  2017/9/21 15:35.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public interface IAddView {
    void completeCommit(int code, AddResultEntity entity, Throwable throwable);

    void completeSelect(int id, SelectEntity entity);
}
