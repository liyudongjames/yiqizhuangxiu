package com.bwf.yiqizhuang.framework.mvp.view;

import com.bwf.yiqizhuang.framework.mvp.databean.YiqiTeamResponse;

/**
 * Created by Administrator on 2016/12/2.
 */

public interface YiqiTeamView {
    void beforeShow();
    void showYiqiTeamView(YiqiTeamResponse response);
    void showYiqiTeamViewfailed(Throwable e);
    void showYiqiTeamViewComplete();
}
