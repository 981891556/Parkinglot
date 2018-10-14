package com.example.liangjiacheng.parkinglot.Base;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.liangjiacheng.parkinglot.R;
/**
 * 这个类主要我为了设置标题栏，然后自定义一些类，
 * 让其他Activity继承这个Java父类然后去实现这些抽象方法
 *
 * */

public abstract class BaseActivity extends AppCompatActivity {
    private TextView title_center;//标题的中间部分
    private ImageView title_left,title_right;//标题的左边和右边
    private RelativeLayout title_relRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutToView();    /**初始化窗口  （抽象方法）*/
        initValues();   /**设置初始化的值和变量（抽象方法）*/
        setActivityTitle(); /**初始化标题（抽象方法）*/
        initViews();/**初始化控件（抽象方法）*/
        setViewsListener();/**初始化控件的监听（抽象方法）*/
        setViewsFunction();/** 设置相关管功能（抽象方法）*/
    }

    /**
     * 初始化标题
     */
    public void initTitle(){
        title_center = (TextView) findViewById(R.id.titles);
        title_left = (ImageView) findViewById(R.id.left_btn);
        title_right = (ImageView) findViewById(R.id.right_btn);
        title_left.setVisibility(View.INVISIBLE); //设置左标题显示
        title_right.setVisibility(View.INVISIBLE);
        title_relRelativeLayout = (RelativeLayout) findViewById(R.id.title_back);//整个标题栏
    }

    public void setMyBackGround(int color){
        title_relRelativeLayout.setBackgroundResource(color);/**上面获取整个标题栏id，然后设置背景颜色*/
    }
    /**
     * 设置TextView的下滑线
     * @param view
     */
    public void setTextViewUnderLine(TextView view){
        Paint paint = view.getPaint();
        paint.setColor(getResources().getColor(R.color.btn_gray));//设置画笔颜色
        paint.setAntiAlias(true);//设置抗锯齿
        paint.setFlags(Paint.UNDERLINE_TEXT_FLAG);//设置下滑线
        view.invalidate();
    }
    /**
     * 初始化标题
     */
    protected abstract void setActivityTitle(); //抽象方法继承需要实现方法
    /**
     * 初始化窗口
     */
    protected abstract void getLayoutToView(); //抽象方法继承需要实现方法
    /**
     * 设置初始化的值和变量
     */
    protected abstract void initValues(); //抽象方法继承需要实现方法
    /**
     * 初始化控件
     */
    protected abstract void initViews(); //抽象方法继承需要实现方法
    /**
     * 初始化控件的监听
     */
    protected abstract void setViewsListener(); //抽象方法继承需要实现方法
    /**
     * 设置相关管功能
     */
    protected abstract void setViewsFunction(); //抽象方法继承需要实现方法


    /*** 设置标题的名称*/
    public void setTitle(String name){
        title_center.setText(name);
        title_left.setVisibility(View.INVISIBLE);
    }

    /**
     * 设置标题有返回键功能-->可以改变返回键的图片
     * @param name
     * @param activity
     */
    public void setTitle(String name,final Activity activity){/**重写上面的方法*/
        title_center.setText(name);
        title_left.setVisibility(View.VISIBLE);
        title_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();/**返回功能*/
            }
        });
    }

    /**
     * 获取标题左边的按钮
     * @param name
     * @return
     */
    public ImageView setTitleLeft(String name){
        title_center.setText(name);
        title_left.setVisibility(View.VISIBLE);
        return title_left;
    }
    /**
     * 设置标题左 中 右 全部显示
     * @param name
     * @param activity
     * @param picID
     */
    public ImageView setTitle(String name,final Activity activity ,int picID){
        title_center.setText(name);
        title_left.setVisibility(View.VISIBLE);
        title_right.setVisibility(View.VISIBLE);
        if (picID != 0){
            title_right.setImageResource(picID);
        }
        title_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
        return title_right;
    }

    /**
     * 设置标题的文字颜色
     * @param colorID
     */
    public void setTitleTextColor(int colorID){
        title_center.setTextColor(colorID);
    }

    /**
     * 设置标题左侧图片按钮的图片
     * @param picID
     */
    public void setTitleLeftImage(int picID){
        title_left.setImageResource(picID);
    }
    /**
     * 设置标题右侧图片按钮的图片
     * @param picID
     */
    public void setTitleRightImage(int picID){
        title_right.setImageResource(picID);
    }
}
