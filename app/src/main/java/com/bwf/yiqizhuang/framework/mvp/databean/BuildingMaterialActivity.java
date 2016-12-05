package com.bwf.yiqizhuang.framework.mvp.databean;

import android.widget.GridView;
import android.widget.ImageView;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.GridAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.BuildingPresetnerImpl;
import com.bwf.yiqizhuang.framework.mvp.view.BuildingView;
import com.bwf.yiqizhuang.utils.LogUtils;

import butterknife.BindView;

/**
 * Created by liyudongjames on 2016/12/4.
 */

public class BuildingMaterialActivity extends BaseActivity implements BuildingView {

    @BindView(R.id.company_activity_return_img)
    ImageView companyActivityReturnImg;
    @BindView(R.id.activity_building_material_Grid)
    GridView activityBuildingMaterialGrid;
    @BindView(R.id.activity_building_furniture_Grid)
    GridView activityBuildingFurnitureGrid;
    @BindView(R.id.activity_building_electric_Grid)
    GridView activityBuildingElectricGrid;
    @BindView(R.id.activity_building_fully_Grid)
    GridView activityBuildingFullyGrid;

    private BuildingPresetnerImpl presetner;
    private BuildingResponse response;
    private GridAdapter materialAdapter;
    private GridAdapter furnitureAdpater;
    private GridAdapter electricAdapter;
    private GridAdapter fullAdapter;

    @Override
    protected void initDatas() {
        presetner = new BuildingPresetnerImpl();
        presetner.attachView(this);
        presetner.startData();
    }

    @Override
    protected void initViews() {
        LogUtils.log((14%3) + "");
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_build_material;
    }

    @Override
    public void beforeShowView() {

    }

    @Override
    public void onShowView(BuildingResponse response) {
        LogUtils.log("成功");
        materialAdapter = new GridAdapter(response.getData().get(0),this);
        furnitureAdpater = new GridAdapter(response.getData().get(1),this);
        electricAdapter = new GridAdapter(response.getData().get(2),this);
        fullAdapter = new GridAdapter(response.getData().get(3),this);
        activityBuildingMaterialGrid.setAdapter(materialAdapter);
        activityBuildingFurnitureGrid.setAdapter(furnitureAdpater);
        activityBuildingElectricGrid.setAdapter(electricAdapter);
        activityBuildingFullyGrid.setAdapter(fullAdapter);
    }

    @Override
    public void onShowComplete() {

    }

    @Override
    public void onFailed(Throwable error) {
        LogUtils.log("失败");
        LogUtils.log(error.getMessage());
    }

    @Override
    protected void onDestroy() {
        presetner.detachView();
        super.onDestroy();
    }

}
