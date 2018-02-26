//Toast的使用与按钮联系


package com.example.apple.activitytest1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class FirstActivity extends BaseActivity {


    //菜单创建代码
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;//表示允许创建的菜单显示出来
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("FirstActivity", "onRestart");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.to_try:
                Toast.makeText(this, "click screen to connect menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_item:
                Toast.makeText(this, "You clicked the add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked the remove",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("FirstActivity","task id is"+getTaskId());//这里拿来试验SecondActivity里的singleInstance用
        setContentView(R.layout.first_layout);

        //TODO this is the key code to make the toast function.
        Button button1=(Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(FirstActivity.this,"Toast 的功能成功了，记得以后使用",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //显示转换并监控logcat的代码,后来在注册文件中改掉了活动一的启动模式到singleTop到singleTask
        Button button3=(Button) findViewById(R.id.skip);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        //隐式intent转换代码
        Button button4=(Button) findViewById(R.id.skip2);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                Intent intent_Implicit=new Intent("com.example.activitytest.ACTION_START");
                intent_Implicit.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent_Implicit);
            }
        });

        //隐式转换外部活动或者内部"http"式活动代码哈哈哈哈哈哈哈哈
        Button button5=(Button) findViewById(R.id.outside);
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                Intent intentOutside = new Intent(Intent.ACTION_VIEW);
                intentOutside.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intentOutside);
            }
        });


        //电话活动启动按钮
        Button button6=(Button) findViewById(R.id.tele);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:18322003724"));
                startActivity(intent);
            }
        });

        //直接传值代码
        Button button7=(Button) findViewById(R.id.transfer);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data="Hello SecondActivity I am from firstActivity";
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });



       // 传值然后回值代码
        Button button8=(Button) findViewById(R.id.transfer2);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });



        //碰触按钮摧毁活动的代码
        Button button2=(Button) findViewById(R.id.destroy);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }


    //打印传过来的值的代码
    @Override
    protected void onActivityResult(int requesetCode,int resultCode,Intent data){
        switch (requesetCode){
            case 1:
                if (resultCode==RESULT_OK){
                    String returnedData=data.getStringExtra("data_return");
                    Log.i("FirstActivity",returnedData);
                    System.out.println(7654321);//检验是否执行
                }
                break;
            default:
        }
    }

}




