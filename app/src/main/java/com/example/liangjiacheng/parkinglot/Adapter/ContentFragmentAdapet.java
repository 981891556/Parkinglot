package com.example.liangjiacheng.parkinglot.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.liangjiacheng.parkinglot.Base.BasePager;

import java.util.ArrayList;

/**
 * create by liangjiacheng on 2018/10/14  10:46
 * 这个类的作用是：ContentFragmentAdapet
 */
public class ContentFragmentAdapet extends PagerAdapter {
    private final ArrayList<BasePager> basePagers;

    public ContentFragmentAdapet(ArrayList<BasePager>basePagers){
        this.basePagers =basePagers;

    }
    @Override
    public int getCount() {
        return basePagers.size();
    }

    /**
     * 类似gerView的作用
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        BasePager basePager = basePagers.get(position);//各个页面的实例
        View rootView = basePager.rootView; //各个子页面

/**            basePager.initData();   //调用各个页面的initData(),初始化数据。不是调用父类方法，而是调用子类方法，但父类的空方法不能删除，否则会报错*/
        container.addView(rootView);//添加到容器

        return rootView; //返回
    }

    /**
     * @param view 当前页面
     * @param o
     * @return
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    /**
     * @param container
     * @param position
     * @param object    要销毁的页面
     */
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

