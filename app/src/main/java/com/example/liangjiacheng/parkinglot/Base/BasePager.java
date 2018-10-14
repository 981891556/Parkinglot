package com.example.liangjiacheng.parkinglot.Base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.liangjiacheng.parkinglot.R;

/**
 * create by liangjiacheng on 2018/10/1315:10
 * 这个类的作用是：基类或者说是公共类
 * 其他——Pager都会继承这个类
 */
public class BasePager {
    public final Context context; //MainActivity
    public View rootView; //视图，显示各个不同的页面
    public TextView tv_title;//显示标题_
    public ImageButton ib_menu; //显示菜单（点击侧滑的）
    public FrameLayout fl_content;//容器，加载各个子页面

    public BasePager(Context context) {
        this.context = context;
        //构造方法一执行，我们的视图就会被初始化
        rootView = initView();
    }

    /**
     * 用于初始化公共部分的视图，并且初始化加载子视图的FragmentLayout
     */
    private View initView() {
        //基类的页面
        View view = View.inflate(context, R.layout.base_pager, null);
        tv_title = view.findViewById(R.id.tv_title);
        ib_menu = view.findViewById(R.id.ib_menu);
        fl_content = view.findViewById(R.id.fl_content);
        return view;
    }
    /**
     * 初始化数据，当孩子需要初始化数据；或者绑定数据，联网请求数据并且绑定的时候，重写该方法
     */
    public void initData() {
    }

}
