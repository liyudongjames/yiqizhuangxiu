package com.bwf.yiqizhuang.framework.mvp.model;

import com.bwf.yiqizhuang.framework.mvp.databean.YiqiTeamResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;

/**
 * http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteVendors
 *
 * token: DAB088BA50C9405E84C789055D657614
 * app_version : android_com.aiyiqi.galaxy_1.1（固定参数）
 * type: 1701（设计师），1702（监理），1703（工长）
 * haspermission: yes
 * pageNo : 页数，默认0
 * pageSize： 一页的数据条数，默认10
 *
 *
 */

public interface YiqiTeamModel {
    void getYiqiTeam(ModelBaseCallBack<YiqiTeamResponse> callBack,int type,int pageNo);
}
