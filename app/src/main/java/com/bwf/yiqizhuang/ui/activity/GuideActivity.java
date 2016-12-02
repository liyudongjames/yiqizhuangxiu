package com.bwf.yiqizhuang.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

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
    @BindView(R.id.guide_activity_know_you_layout)
    LinearLayout guideActivityKnowYouLayout;

    private String sex;
    private int mYear;
    private int mMonth;
    private int mDay;
    private String fitmentPlan;
    public final String PREFS_NAME = "Note.sample.roiding.com";
    private boolean isFirst;
    @Override
    protected void initDatas() {
        mYear = guideDatepiker.getYear();
        mMonth = guideDatepiker.getMonth() + 1;
        mDay = guideDatepiker.getDayOfMonth();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        isFirst = settings.getBoolean("isFirst", false);
        if(isFirst == false){
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("isFirst",true);
            editor.commit();
        }else{
            guideActivityKnowYouLayout.setVisibility(View.GONE);
            getHomeActivity();
        }
    }

    private void getHomeActivity() {
        Timer timer=new Timer();
        TimerTask task=new TimerTask(){
            public void run(){
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        };
        timer.schedule(task, 2500);
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        setTextClickable(false);
        textOnclick();
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
                mMonth = monthOfYear + 1;
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
                if(isChecked) {
                    changeFitmentPlanTextColor(0);
                    setTextClickable(true);
                    fitmentPlan = guidePlanfitmentRadioBtn.getText().toString() + guidePlanFitmentThisyear.getText().toString();
                }else {
                    changeFitmentPlanTextColor(4);
                    setTextClickable(false);
                }
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

    public void textOnclick(){
        guidePlanFitmentThisyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v;
                changeFitmentPlanTextColor(0);
                setfitmentPlaning(tv);
            }
        });

        guidePlanFitmentNextyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v;
                changeFitmentPlanTextColor(1);
                setfitmentPlaning(tv);
            }
        });

        guidePlanFitmentNextnextyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v;
                changeFitmentPlanTextColor(2);
                setfitmentPlaning(tv);
            }
        });
    }

    public void setfitmentPlaning(TextView view){
        fitmentPlan = guidePlanfitmentRadioBtn.getText().toString();
        fitmentPlan += view.getText().toString();
    }

    public void changeFitmentPlanTextColor(int i){
        switch (i){
            case 0:
                guidePlanFitmentThisyear.setTextColor(getResources().getColor(R.color.darker_green));
                guidePlanFitmentNextnextyear.setTextColor(Color.BLACK);
                guidePlanFitmentNextyear.setTextColor(Color.BLACK);
                break;
            case 1:
                guidePlanFitmentNextyear.setTextColor(getResources().getColor(R.color.darker_green));
                guidePlanFitmentNextnextyear.setTextColor(Color.BLACK);
                guidePlanFitmentThisyear.setTextColor(Color.BLACK);
                break;
            case 2:
                guidePlanFitmentNextnextyear.setTextColor(getResources().getColor(R.color.darker_green));
                guidePlanFitmentThisyear.setTextColor(Color.BLACK);
                guidePlanFitmentNextyear.setTextColor(Color.BLACK);
                break;
            default:
                guidePlanFitmentNextnextyear.setTextColor(Color.BLACK);
                guidePlanFitmentThisyear.setTextColor(Color.BLACK);
                guidePlanFitmentNextyear.setTextColor(Color.BLACK);
                break;
        }
    }

    public void setTextClickable(boolean flag){
        guidePlanFitmentThisyear.setClickable(flag);
        guidePlanFitmentNextyear.setClickable(flag);
        guidePlanFitmentNextnextyear.setClickable(flag);
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
            Toast.makeText(GuideActivity.this, mYear+ " " + mMonth + " " + mDay + " " + sex + " " + fitmentPlan, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(GuideActivity.this,MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("year",mYear);
            bundle.putInt("month",mMonth);
            bundle.putInt("day",mDay);
            bundle.putString("sex",sex);
            bundle.putString("fitmentPlan",fitmentPlan);
            intent.putExtra("data",bundle);
            startActivity(intent);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
