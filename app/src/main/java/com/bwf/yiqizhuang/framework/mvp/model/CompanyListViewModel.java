package com.bwf.yiqizhuang.framework.mvp.model;

import com.bwf.yiqizhuang.framework.mvp.databean.CompanyListViewResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;

/**
 * Created by Administrator on 2016/11/30.
 */

public interface CompanyListViewModel {
    void startGetCompanyListViewData(ModelBaseCallBack<CompanyListViewResponse> callBack);
}
