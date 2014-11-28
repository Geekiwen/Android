package com.anjoyo.timedialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	private DatePickerDialog dpd;
	private int myear, mmonth, mday;
	private TimePickerDialog tpd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myear = 2013;
		mmonth = 7;
		mday = 26;
		dpd = new DatePickerDialog(this, new OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				myear = year;
				mmonth = monthOfYear;
				mday = dayOfMonth;
				Toast.makeText(MainActivity.this,
						myear + "/" + mmonth + "/" + mday + "onDateSet",
						Toast.LENGTH_SHORT).show();

			}
		}, myear, mmonth, mday);
		dpd.setTitle("日期");
		dpd.setMessage("当前日期为");
		// dpd.setButton("确定", new DialogInterface.OnClickListener() {
		//
		// @Override
		// public void onClick(DialogInterface dialog, int which) {
		// Toast.makeText(MainActivity.this,
		// myear + "/" + mmonth + "/" + mday, Toast.LENGTH_SHORT).show();
		//
		// }
		// });
		// dpd.setButton2("取消", new DialogInterface.OnClickListener() {
		//
		// @Override
		// public void onClick(DialogInterface dialog, int which) {
		// Toast.makeText(MainActivity.this,
		// myear + "/" + mmonth + "/" + mday, Toast.LENGTH_SHORT).show();
		//
		// }
		// });
		dpd.show();
		
		
//		tpd = new TimePickerDialog(context, callBack, hourOfDay, minute, is24HourView)

	}

}
