package com.example.liangjiacheng.parkinglot.Fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.liangjiacheng.parkinglot.Base.BaseFragment;

/**
 * 左侧菜单Fragment
 *
 * Fragment 继承v4.app的包
 * */
public class LeftmenuFragment extends BaseFragment {
    private TextView textView;
    @Override
    public View initView() {
        textView = new TextView(content);//这个content是父类的
        textView.setTextSize(23);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initDate() {
        super.initDate();
        textView.setText("左侧菜单页面");
    }
}

