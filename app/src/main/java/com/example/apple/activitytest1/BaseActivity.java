package com.example.apple.activitytest1;
//这是个用来知晓当前处于哪个活动的类,其他活动继承着继承A...C..A的它，每次活动都会在logcat上显示出来
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by apple on 26/02/2018.
 */

public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        Log.i("BaseActivity", getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

}
