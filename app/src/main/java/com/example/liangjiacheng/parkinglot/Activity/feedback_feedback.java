package com.example.liangjiacheng.parkinglot.Activity;

import com.example.liangjiacheng.parkinglot.Base.BaseActivity;
import com.example.liangjiacheng.parkinglot.R;

public class feedback_feedback extends BaseActivity {
/**
 * 意见反馈*/
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_feedback_feedback);
//    }
    @Override
    protected void setActivityTitle() {
        initTitle();//初始化标题
        setTitle("意见反馈", this); /**使用的是BaseActivity的98行代码因此具有返回功能*/
        setMyBackGround(R.color.watm_background_gray);
        setTitleTextColor(R.color.theme_blue_two);
        setTitleLeftImage(R.mipmap.title_back);
    }

    @Override
    protected void getLayoutToView() {//获取布局文件
        setContentView(R.layout.activity_feedback_feedback);

    }

    /**初始化变量的数值*/
    @Override
    protected void initValues() {

    }

    /**获取控件*/
    @Override
    protected void initViews() {

    }

    /**初始化控件的监听*/
    @Override
    protected void setViewsListener() {

    }

    /**设置相关功能*/
    @Override
    protected void setViewsFunction() {

    }
}
