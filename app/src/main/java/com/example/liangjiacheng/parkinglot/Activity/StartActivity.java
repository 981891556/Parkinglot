package com.example.liangjiacheng.parkinglot.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.example.liangjiacheng.parkinglot.R;

import com.example.liangjiacheng.parkinglot.utils.CacheUtils;

public class StartActivity extends Activity {

    public static final String START_MAIN = "start_main";  //静态常量  ,作用是键值对
    private RelativeLayout rl_start_root; //实例化


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //不显示状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        rl_start_root = findViewById(R.id.rl_start_root);

        /**   这个是我自己写的的欢迎界面

        Timer timer =new Timer();//计时任务
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(StartActivity.this, MainActivity.class));
                finish();
            }
        };timer.schedule(timerTask,3000);//进入动画跳转时间     */




        /**渐变动画，缩放动画，旋转动画*/
       /*渐变动画，缩放动画，旋转动画
         private RelativeLayout rl_start_root; //实例化
         rl_start_root = findViewById(R.id.rl_start_root);*/
         AlphaAnimation aa = new AlphaAnimation(0,1);
        aa.setFillAfter(true); //停留在改状态

        ScaleAnimation sa =new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,05f);
        sa.setFillAfter(true);

        RotateAnimation ra = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        ra.setFillAfter(true);

        //设置三个动态同时播放,添加三个动画没有先后顺序
        AnimationSet set = new AnimationSet(false);
        set.addAnimation(ra);
        set.addAnimation(aa);
        set.addAnimation(sa);
        set.setDuration(2000);
        rl_start_root.startAnimation(set); //开始播放


        set.setAnimationListener(new MyAnimationListener()); //设置动画播放监听
    }

        class MyAnimationListener implements  Animation.AnimationListener{

        //动画开始播放回调
        @Override
            public void onAnimationStart(Animation animation) {

            }

            //动画播放结束回调
            @Override
            public void onAnimationEnd(Animation animation) {
            //判断是否进入过主页面
                boolean isStartMain = CacheUtils.getBoolean(StartActivity.this,START_MAIN); /**  START_MAIN 使用快捷键 ctrl + alt + c 变成成员变量  */
                Intent intent;
                if (isStartMain){
                     intent = new Intent(StartActivity.this,MainActivity.class);

                    // 如果进入过主页面，直接进入主页面
                }
                else {//如果没进入过主页面，则进入引导页面ViewPager的控件来设置
                     intent  = new Intent(StartActivity.this,GuideActivtiy.class);

                }
                startActivity(intent);
                finish();  //关闭欢迎页面

            }

            //当动画重复播放的时候回调
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        }



    }

