package com.mobile3121.datedemo;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {
private EditText eddate;
private EditText edtime;
private DatePicker datePicker;
private TimePicker timePicker;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		eddate=(EditText)findViewById(R.id.eddateID);
		edtime=(EditText)findViewById(R.id.edtimeID);
		datePicker=(DatePicker)findViewById(R.id.datePickerID);
		timePicker=(TimePicker)findViewById(R.id.timePickerID);
		Calendar  calendar=Calendar.getInstance();
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int year = calendar.get(Calendar.YEAR);
		int monthOfYear = calendar.get(Calendar.MONTH);
	datePicker.init(year, monthOfYear, dayOfMonth, new OnDateChangedListener(){
           public void onDateChanged(DatePicker view, int year,
                   int monthOfYear, int dayOfMonth) {
        	   eddate.setText("您选择的日期是："+year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日。");
           }
       });

	   timePicker.setOnTimeChangedListener(new OnTimeChangedListener(){
           public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        	   edtime.setText("您选择的时间是："+hourOfDay+"时"+minute+"分。");
           }
           
       });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
