package com.example.liangjiacheng.parkinglot.Pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.example.liangjiacheng.parkinglot.Base.BasePager;

/**
 * create by liangjiacheng on 2018/10/13  15:52
 * 这个类的作用是：新闻消息的中心
 */
public class NewsPager extends BasePager {
    public NewsPager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        //1.设置标题
        tv_title.setText("新闻消息");
        //2.联网请求得到数据，创建视图
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        //3.把子视图添加到BasePager的FragmeLayout视图中
        fl_content.addView(textView);
        //4.绑定数据
        textView.setText("我是新闻消息内容");
    }
}
