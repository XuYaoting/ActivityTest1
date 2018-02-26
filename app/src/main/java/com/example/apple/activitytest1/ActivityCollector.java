package com.example.apple.activitytest1;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 26/02/2018.
 */


//这个类用来直接退出程序的所有活动而不用back
public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity:activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
