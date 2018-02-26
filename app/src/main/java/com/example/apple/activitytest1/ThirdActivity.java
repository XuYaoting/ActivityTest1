package com.example.apple.activitytest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ThirdActivity","Task ID is"+getTaskId());
        setContentView(R.layout.third_layout);

        Button button3=(Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCollector.finishAll();
            }
            //android.os.killProcess(android.os.Process.myPid());//用myPid方法获得id杀掉进程且完全退出
        });

    }

}
