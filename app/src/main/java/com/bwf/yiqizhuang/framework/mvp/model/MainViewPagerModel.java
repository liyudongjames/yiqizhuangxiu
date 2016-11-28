package com.bwf.yiqizhuang.framework.mvp.model;

import com.bwf.yiqizhuang.framework.mvp.databean.FontPagePagerResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;

/**
 * Created by Administrator on 2016/11/24.
 */

public interface MainViewPagerModel {
    void startViewPager(ModelBaseCallBack<FontPagePagerResponse> callBack);
}
