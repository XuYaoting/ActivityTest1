package com.example.apple.activitytest1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    //优雅地在启动时候就传承启动活动而来的数据
    public static void actionStart(Context context,String data1,String data2){
        Intent intent=new Intent(context,SecondActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }




    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("SecondActivity", "onDestroy");
    }

    //重写关于back的方法来使得按back值还是可以返回(销毁同时传值按钮）
    @Override
    public void onBackPressed(){
        Intent intent=new Intent();
        intent.putExtra("data_return","Hello FirstActivity I returned from back key");
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Log.i("SecondActivity", "Task ID is"+getTaskId());

        Button button3=(Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }

        });


        //？？从活动1中取值显示代码（出了大问题,会闪退）
//        Intent intent=getIntent();
//        String data = intent.getStringExtra("extra_data");
//        Log.i("SecondActivity", data);
//        System.out.println(1234567);

        //本来是优雅地启动，但却出现了不知名的问题
//        Button button4=(Button) findViewById(R.id.button_4);
//        button4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SecondActivity.actionStart(FirstActivity.this,"data1","data2");
//            }
//        });



        //回值到activity1的onActivityResult()的代码
        Button button2=(Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent9=new Intent();
                intent9.putExtra("data_return","Hello FirstActivity I returned from button");
                setResult(RESULT_OK,intent9);//如果不是从Start来的，那么就只会返回不会传值
                finish();
            }
        });



    }
}
