package com.example.liangjiacheng.parkinglot.Fragment;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.liangjiacheng.parkinglot.Activity.MainActivity;
import com.example.liangjiacheng.parkinglot.Adapter.ContentFragmentAdapet;
import com.example.liangjiacheng.parkinglot.Base.BaseFragment;
import com.example.liangjiacheng.parkinglot.Base.BasePager;
import com.example.liangjiacheng.parkinglot.Pager.GovaffairPager;
import com.example.liangjiacheng.parkinglot.Pager.HomePager;
import com.example.liangjiacheng.parkinglot.Pager.NewsPager;
import com.example.liangjiacheng.parkinglot.Pager.SettingPager;
import com.example.liangjiacheng.parkinglot.Pager.SmartServicePager;
import com.example.liangjiacheng.parkinglot.R;
import com.example.liangjiacheng.parkinglot.view.NoScrollViewPager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * 正文Fragment
 */
public class ContentFragment extends BaseFragment {
    //1.初始化控件并关联
    //被初始化的控件1
    @ViewInject(R.id.viewpager) //找到id
    private NoScrollViewPager viewPager;//初始化定义名字为：R.id.viewpager控件的名字：viewPager
    //被初始化的控件2
    @ViewInject(R.id.rg_main)//RadioGroup
    private RadioGroup rg_main;

    //装五个Pager页面集合
    private ArrayList<BasePager> basePagers;

    @Override
    public View initView() {
//        textView = new TextView(content);//这个content是父类的
//        textView.setTextSize(23);
//        textView.setGravity(Gravity.CENTER);
//        textView.setTextColor(Color.RED);
        View view = View.inflate(content, R.layout.content_fragment, null);

        /*        viewPager = view.findViewById(R.id.viewpager);
        rg_main = view.findViewById(R.id.rg_main);
       2. 通过下面这行行代码来代替上面这两行代码*/
        /** 一、把视图注入到框架中，让ContentFragment.this和View关联起来 */
        x.view().inject(ContentFragment.this, view);
        return view;
    }

    @Override
    public void initDate() {
        super.initDate();
        /**初始化五个Pager，并且放入集合中，因为ViewPager就是要用集合
         * 注意现在的顺序就是到时候手机在屏幕上加载的顺序
         * */
        basePagers = new ArrayList<>();
        basePagers.add(new HomePager(content));//主页面
        basePagers.add(new NewsPager(content));//新闻界面
        basePagers.add(new SmartServicePager(content));//智慧界面
        basePagers.add(new GovaffairPager(content));//指南页面
        basePagers.add(new SettingPager(content));//设置页面


        //设置ViewPager的适配器
        viewPager.setAdapter(new ContentFragmentAdapet(basePagers));
        //设置RadioGroup选中状态改变的监听
        rg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());


        //监听某个页面被选中，初始化对应页面的数据  （设置后下一个页面仍然会被初始化，只是不会执行联网强求）
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());
        //设置默认选中的首页
        rg_main.check(R.id.rb_home); //如果不加，首页没数据
        basePagers.get(0).initData();//加载第一个页面的数据。如果不加，首页没数据
        //设置默认SlidingMenu不可以滑动
        isEnablesSlidingMenu(SlidingMenu.TOUCHMODE_NONE);

    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /**
         * 当页面滚动的时候
         *
         * @param i  当前滚动位置
         * @param v  页面滚动的百分比
         * @param i1 滑动的像数
         */
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        /**
         * 某个页面被选中回调
         *
         * @param position 被选中页面的位置
         */
        @Override
        public void onPageSelected(int position) {
            /**BasePager basePager =basePagers.get(position);
             basePager.initData();*/
            basePagers.get(position).initData();//当页面被选中的时候加载相应的数据(与上面两行代码做哦有那个一样)

        }

        /**
         * 状态变化
         *
         * @param i
         */
        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }


    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        /**
         * @param group     RadioGroup
         * @param checkedId 被选中RadioButton的id
         */

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_home:
                    viewPager.setCurrentItem(0, false);
                    //不可以滑出SlidingMenu菜单
                    isEnablesSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;

                case R.id.rb_news_center:
                    viewPager.setCurrentItem(1, false);
                    //下面两个设置屏幕可以滑出menu菜单，其他设置不可以
                    isEnablesSlidingMenu(SlidingMenu.TOUCHMODE_FULLSCREEN);
                    break;

                case R.id.rb_nearby:
                    viewPager.setCurrentItem(2, false);
                    //不可以滑出SlidingMenu菜单
                    isEnablesSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;

                case R.id.rb_about:
                    viewPager.setCurrentItem(3, false);
                    //不可以滑出SlidingMenu菜单
                    isEnablesSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;

                case R.id.rb_mine:
                    viewPager.setCurrentItem(4, false);
                    //不可以滑出SlidingMenu菜单
                    isEnablesSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;
            }
        }
    }

    //根据传入的参数，设置SlidingMenu是否能滑出的方法
    private void isEnablesSlidingMenu(int touchmodeFullscreen) {
        MainActivity mainActivity = (MainActivity) content;
        mainActivity.getSlidingMenu().setTouchModeAbove(touchmodeFullscreen);
    }

//    class ContentFragmentAdapet extends PagerAdapter {
//        @Override
//        public int getCount() {
//            return basePagers.size();
//        }
//
//        /**
//         * 类似gerView的作用
//         */
//        @NonNull
//        @Override
//        public Object instantiateItem(@NonNull ViewGroup container, int position) {
//            BasePager basePager = basePagers.get(position);//各个页面的实例
//            View rootView = basePager.rootView; //各个子页面
//
///**            basePager.initData();   //调用各个页面的initData(),初始化数据。不是调用父类方法，而是调用子类方法，但父类的空方法不能删除，否则会报错*/
//            container.addView(rootView);//添加到容器
//
//            return rootView; //返回
//        }
//
//        /**
//         * @param view 当前页面
//         * @param o
//         * @return
//         */
//        @Override
//        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
//            return view == o;
//        }
//
//        /**
//         * @param container
//         * @param position
//         * @param object    要销毁的页面
//         */
//        @Override
//        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            container.removeView((View) object);
//        }
//    }
}


