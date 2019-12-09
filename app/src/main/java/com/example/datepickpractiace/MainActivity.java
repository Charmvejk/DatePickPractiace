package com.example.datepickpractiace;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button btnSelectDate;
    Calendar calendar = Calendar.getInstance(Locale.CHINA);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSelectDate=findViewById(R.id.btn_select_date);
        findViewById(R.id.btn_select_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(MainActivity.this, 3, calendar);
            }
        });
    }

    public void showDatePickerDialog(Activity activity, int themeResId, final Calendar calendar) {
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(activity, themeResId, new DatePickerDialog.OnDateSetListener() {
            // 绑定监听器(How the parent is notified that the date is set.)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                showTimePickerDialog(MainActivity.this, 3, calendar, year, monthOfYear + 1, dayOfMonth);

            }
        }
                // 设置初始日期
                , calendar.get(Calendar.YEAR)
                , calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void showTimePickerDialog(Activity activity, int themeResId, Calendar calendar, final int Year, final int Month, final int Day) {
        // Calendar c = Calendar.getInstance();
        // 创建一个TimePickerDialog实例，并把它显示出来
        // 解释一哈，Activity是context的子类
        new TimePickerDialog(activity, themeResId,
                // 绑定监听器
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String mHours = "" + hourOfDay;
                        String mSeconds = "" + minute;
                        String mYear = "" + Month;
                        String mMonth = "" + Day;
//                        if (isClicked) {
//                            tvStartTime.setText("" + Year + "-" + (mYear.length() < 2 ? "0" + Month : Month) + "-" + (mMonth.length() < 2 ? "0" + Day : Day) + "  " + (mHours.length() < 2 ? "0" + hourOfDay : hourOfDay) + ":" + (mSeconds.length() < 2 ? "0" + minute : minute));
//
//                        }else {
//                            tvTimeBack.setText("" + Year + "-" + (mYear.length() < 2 ? "0" + Month : Month) + "-" + (mMonth.length() < 2 ? "0" + Day : Day) + "  " + (mHours.length() < 2 ? "0" + hourOfDay : hourOfDay) + ":" + (mSeconds.length() < 2 ? "0" + minute : minute));
//
//                        }
                        // TODO 显示秒，直接拼接
//                        mStartTime = btnSelectDate.getText().toString() + ":" + Utilities.getDateTimeEs1(Calendar.getInstance().getTime());
                        btnSelectDate.setText("" + Year + "-" + Month + "-" + Day + "  " + hourOfDay + ":" + minute);

                    }
                }
                // 设置初始时间
                , calendar.get(Calendar.HOUR_OF_DAY)
                , calendar.get(Calendar.MINUTE)
                // true表示采用24小时制
                , true).show();
    }

}
