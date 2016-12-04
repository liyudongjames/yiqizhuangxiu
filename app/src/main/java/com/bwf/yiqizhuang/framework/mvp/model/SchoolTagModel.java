package com.bwf.yiqizhuang.framework.mvp.model;

import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;

/**
 * Created by Administrator on 2016/12/2.
 */

public interface SchoolTagModel {
    void getTag(ModelBaseCallBack<String> callBack,int tag);
}
