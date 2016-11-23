package com.bwf.yiqizhuang.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/23.
 */

public class GuideActivity extends BaseActivity {

    @BindView(R.id.branch_cancel)
    TextView branchCancel;
    @BindView(R.id.guide_sex_check_male)
    RadioButton guideSexCheckMale;
    @BindView(R.id.guide_sex_check_female)
    RadioButton guideSexCheckFemale;
    @BindView(R.id.guide_sex_check)
    RadioGroup guideSexCheck;
    @BindView(R.id.guide_datepiker)
    DatePicker guideDatepiker;
    @BindView(R.id.guide_fitmenting_text)
    TextView guideFitmentingText;
    @BindView(R.id.guide_fitmenting_radioBtn)
    RadioButton guideFitmentingRadioBtn;
    @BindView(R.id.guide_planfitment_radioBtn)
    RadioButton guidePlanfitmentRadioBtn;
    @BindView(R.id.guide_is_living_radioBtn)
    RadioButton guideIsLivingRadioBtn;
    @BindView(R.id.guide_noplan_radioBtn)
    RadioButton guideNoplanRadioBtn;
    @BindView(R.id.guide_plan_fitment_radioGroup)
    RadioGroup guidePlanFitmentRadioGroup;
    @BindView(R.id.guide_plan_fitment_thisyear)
    TextView guidePlanFitmentThisyear;
    @BindView(R.id.guide_plan_fitment_nextyear)
    TextView guidePlanFitmentNextyear;
    @BindView(R.id.guide_plan_fitment_nextnextyear)
    TextView guidePlanFitmentNextnextyear;
    @BindView(R.id.guide_enter_fitment)
    Button guideEnterFitment;

    private String sex;
    private int mYear;
    private int mMonth;
    private int mDay;
    private String fitmentPlan;

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        flexibalListener();
        setEnterButton();
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_guide;
    }

    private boolean isSexCheck() {
        if (guideSexCheckMale.isChecked() == true
                || guideSexCheckFemale.isChecked() == true) {
            return true;
        }
        return false;
    }

    private boolean isPlaningCheck() {
        for (int i = 0; i < guidePlanFitmentRadioGroup.getChildCount(); i++) {
            RadioButton radiobtn = (RadioButton) guidePlanFitmentRadioGroup.getChildAt(i);
            if (radiobtn.isChecked() == true) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private void setEnterButton(){
        if (isSexCheck() && isPlaningCheck()) {
            guideEnterFitment.setClickable(true);
            guideEnterFitment.setTextColor(Color.WHITE);
            guideEnterFitment.setBackgroundColor(getResources().getColor(R.color.darker_green));
        }else{
            guideEnterFitment.setClickable(false);
            guideEnterFitment.setTextColor(getResources().getColor(R.color.light_gray));
            guideEnterFitment.setBackgroundColor(getResources().getColor(R.color.light_green));
        }
    }


    public void flexibalListener(){
        guideSexCheck.setOnCheckedChangeListener(new onRadioClickListener());
        guidePlanFitmentRadioGroup.setOnCheckedChangeListener(new onRadioClickListener());
        guideDatepiker.init(guideDatepiker.getYear(), guideDatepiker.getMonth(), guideDatepiker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
            }
        });
        guideSexCheckMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                sex = guideSexCheckMale.getText().toString();
            }
        });

        guideSexCheckFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    sex = guideSexCheckFemale.getText().toString();
            }
        });

        guidePlanfitmentRadioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    fitmentPlan = guidePlanfitmentRadioBtn.getText().toString();
            }
        });

        guideFitmentingRadioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    fitmentPlan = guideFitmentingRadioBtn.getText().toString();
            }
        });

        guideIsLivingRadioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    fitmentPlan = guideIsLivingRadioBtn.getText().toString();
            }
        });

        guideNoplanRadioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    fitmentPlan = guideNoplanRadioBtn.getText().toString();
            }
        });
        guideEnterFitment.setOnClickListener(new onEnterButtonClickListener());
        
    }


    class onRadioClickListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            setEnterButton();
        }
    }

    class onEnterButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Toast.makeText(GuideActivity.this, mYear + mMonth + mDay + sex + fitmentPlan, Toast.LENGTH_SHORT).show();
        }
    }

}
