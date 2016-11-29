package com.bwf.yiqizhuang.framework.mvp.model;

import com.bwf.yiqizhuang.framework.mvp.databean.CompanyViewPagerResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;

/**
 * Created by Administrator on 2016/11/29.
 */

public interface CompanyPagerModel {
    void startGetPager(ModelBaseCallBack<CompanyViewPagerResponse> callBack);
}
