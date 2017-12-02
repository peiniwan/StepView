package com.example.stepview.stepview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<StepViewBean> traceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvTrace= (ListView) findViewById(R.id.lvTrace);
        traceList.add(new StepViewBean("10-20 22: 22", "您的订单已打印完毕", "招商银行（9979） 小明\n支付金额   100000"));
        traceList.add(new StepViewBean("10-20 22:22", "您已提交定单，等待系统确认"));
        traceList.add(new StepViewBean("10-20 22:24", "您的订单已拣货完成"));
        traceList.add(new StepViewBean("10-20 22:24", "扫描员已经扫描"));
        traceList.add(new StepViewBean("10-20 22:24", "您的订单已拣货完成"));
        traceList.add(new StepViewBean("10-20 22:24", "感谢你在京东购物，欢迎你下次光临！"));
        StepViewAdapter adapter = new StepViewAdapter(this, traceList);
        lvTrace.setAdapter(adapter);
    }
}
