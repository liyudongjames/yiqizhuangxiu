package com.bwf.yiqizhuang.framework.mvp.presenter.impl;

import com.bwf.yiqizhuang.framework.mvp.base.BasePresenter;
import com.bwf.yiqizhuang.framework.mvp.databean.YiqiTeamResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.YiqiTeamModel;
import com.bwf.yiqizhuang.framework.mvp.model.impl.YiqiModelImpl;
import com.bwf.yiqizhuang.framework.mvp.view.YiqiTeamView;

/**
 * Created by Administrator on 2016/12/2.
 */

public class YiqiTeamPresenterImpl extends BasePresenter<YiqiTeamView>{
    private YiqiTeamModel model;
    private int type;
    private int pageNo;

    public YiqiTeamPresenterImpl(int type, int pageNo){
        model = new YiqiModelImpl();
        this.type = type;
        this.pageNo = pageNo;
    }

    @Override
    public void startData() {
        t.beforeShow();
        model.getYiqiTeam(new ModelBaseCallBack<YiqiTeamResponse>() {
            @Override
            public void onComplete() {
                t.showYiqiTeamViewComplete();
            }

            @Override
            public void onNext(YiqiTeamResponse yiqiTeamResponse) {
                t.showYiqiTeamView(yiqiTeamResponse);
            }

            @Override
            public void onFailed(Throwable error) {
                t.showYiqiTeamViewfailed(error);
            }
        },type,pageNo);
    }
}
