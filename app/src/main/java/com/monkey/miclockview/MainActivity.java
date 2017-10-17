package com.monkey.miclockview;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.monkey.miclockview.view.LEDView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends AppCompatActivity {

    private LEDView ledView;
    private TextView text_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleDateFormat formatter    =   new    SimpleDateFormat    ("MM月dd日  ");
        Date curDate    =   new    Date(System.currentTimeMillis());//获取当前时间
        String    str    =    formatter.format(curDate);

        Calendar cal = Calendar.getInstance();
        int i = cal.get(Calendar.DAY_OF_WEEK);

        str += get_weekday(i);
        ledView = (LEDView) findViewById(R.id.led_time);
        text_date = (TextView) findViewById(R.id.text_date);
        text_date.setText(str);
    }


    public  String get_weekday(int i){
        switch (i) {
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            case 7:
                return "星期六";
            default:
                return "";
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        ledView.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        ledView.stop();
    }
}
