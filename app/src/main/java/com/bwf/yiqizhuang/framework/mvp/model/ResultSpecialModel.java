package com.bwf.yiqizhuang.framework.mvp.model;

import com.bwf.yiqizhuang.framework.mvp.databean.ResultSpeciaResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public interface ResultSpecialModel {
    void getSpecial(int page, ModelBaseCallBack<ResultSpeciaResponse> callBack);
}
