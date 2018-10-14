package com.example.liangjiacheng.parkinglot.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.liangjiacheng.parkinglot.R;

import java.util.ArrayList;

import com.example.liangjiacheng.parkinglot.utils.CacheUtils;
import com.example.liangjiacheng.parkinglot.utils.DensityUtil;


/**
 * 引导页面
 */
public class GuideActivtiy extends Activity {
    private static final String TAG  = GuideActivtiy.class.getSimpleName();
    private ViewPager viewpager;
    private Button btn_start_main;
    private LinearLayout ll_point_group;
    private ImageView iv_point_red;
    private ArrayList<ImageView> imageViews;
    private int  leftmax;  //两点间的间距
    private int widthdpi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_activtiy);
        //控件初始化
        viewpager = findViewById(R.id.viewpager);
        btn_start_main = findViewById(R.id.btn_start_main);
        ll_point_group = findViewById(R.id.ll_point_group);//灰色点
        iv_point_red = findViewById(R.id.iv_point_red);//红色点

        //准备数据
        int ids[] = new int[]{
                R.drawable.group_1,
                 R.drawable.group_3,
                R.drawable.group_2
        };
        /**单位转换,然后传入LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(widthdpi,widthdpi);*/
        widthdpi = DensityUtil.dip2px(this,10);
        Log.e(TAG,widthdpi+"----------");

        imageViews = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            //临时创建一个ImageView对象用来存放数据
            ImageView imageView = new ImageView(this);
            //设置背景：
            imageView.setBackgroundResource(ids[i]);
            //添加到集合中
            imageViews.add(imageView);
            //创建点
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.point_color_gray);

            /**显示10x10的单位是像素,到时候要做一个适配
             * 把单位当成dp转成像数*/
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(widthdpi,widthdpi);
            if (i!=0){/**设置间距*/
                //不包括第零个点，其他点都会距离左边的点10dp
                params.leftMargin = 10;
            }

            point.setLayoutParams(params);
            //添加到线性布局里面（灰色的点）
            ll_point_group.addView(point);
        }
        //设置viewPager的适配器：
        viewpager.setAdapter(new MyPagerAdapter());


        /**开始添加红点*/
        //根据View的生命周期，当视图执行到onLayout或者onDraw的时候，视图的高和宽，边距都有了
        iv_point_red.getViewTreeObserver().addOnGlobalLayoutListener( new MyGlobalLayoutListener());

        //得到屏幕滑动的百分比 ，监听页面的改变
        viewpager.addOnPageChangeListener(new MyOnPageChangeListener());


//        设置按钮的点击事件
        btn_start_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1.保存曾经进入过主页面
                   CacheUtils.putBoolean(GuideActivtiy.this, StartActivity.START_MAIN,true);
                //跳转页面
                Intent intent = new Intent(GuideActivtiy.this,MainActivity.class);
                startActivity(intent);
                //关闭单前引导页面
                finish();
            }
        });
    }
    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{

        /** 当页面滚动的时候回调这个方法
         * @param i 当前滑动页面的位置
         * @param v  当前滑动页面的百分比
         * @param i1  滑动的像数
         */
        @Override
        public void onPageScrolled(int i, float v, int i1) {
            //两点间移动的距离 = 屏幕滑动百分比 * 间距
            Log.e(TAG,"当前位置=="+ i +"百分比=="+ v + "滑动像数=="+ i1);
            /**两点间互动的距离对应的坐标 = 原来的起始位置 + 两点间的移动位置    这是灰色点从一个滑动到另外一个点的重要代码*/
            int leftMargin = (int) ((i * leftmax)+(v * leftmax ));
            //params.leftMargin = 两点间滑动距离对应的坐标

            RelativeLayout.LayoutParams params  = (RelativeLayout.LayoutParams) iv_point_red.getLayoutParams();
            params.leftMargin = leftMargin;
            iv_point_red.setLayoutParams(params);
        }

        /**当页面被选中的时候被回调
         * @param i  被选中页面的对应位置
         */
        @Override
        public void onPageSelected(int i) {
            //隐藏“开始体验”这个按钮
            if (i ==imageViews.size()-1){
                //最后一个页面
                btn_start_main.setVisibility(View.VISIBLE);//显示
            }else {
                //其他页面
                btn_start_main.setVisibility(View.GONE);//隐藏
            }

        }

        /**当Viewpager页面滑动状态发生改变的时候
         * @param i
         */
        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }

    class MyGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener{
        @Override
        public void onGlobalLayout() {
        //执行不止一次,但是有了下面那一行代码可以使其只执行一次，提高一点性能
            iv_point_red.getViewTreeObserver().removeGlobalOnLayoutListener(this);  //this是指MyGlobalLayoutListener这个类

            // 间距 = 第1个距离左边的距离 - 第0个距离左边的距离
             leftmax  = ll_point_group.getChildAt(1).getLeft() - ll_point_group.getChildAt(0).getLeft();

        }

    }


    class MyPagerAdapter extends PagerAdapter {
        //返回数据总个数
        @Override
        public int getCount() {
            return imageViews.size();
        }
        /**
         * 作用是类似GetView
         *
         * @param container ViewPager
         * @param position  要创建页面的位置，0开始
         * @return 返回和创建当前页面的有关系的值
         */
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView imageView = imageViews.get(position);
            //添加到ViewPager容器：
            container.addView(imageView);
            return imageView;
//                return super.instantiateItem(container,position);    当这段代码执行的时候下面的isViewFromObject方法也要执行注释中的代码来代替对应方法中的上面一行代码
        }
        /**
         * @param view   是当前创建的视图
         * @param object 是上面的instantiateItem方法返回的结果值
         * @return
         */
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
//                return view == imageViews.get(Integer.parseInt((String)o));
        }

        /**
         * @param container ViewPager
         * @param position  要销毁页面的位置
         * @param object    要销毁的页面
         */
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//                super.destroyItem(container, position, object);必须要删除这段代码。不然程序必然崩掉
            container.removeView((View) object);
        }
    }
}



