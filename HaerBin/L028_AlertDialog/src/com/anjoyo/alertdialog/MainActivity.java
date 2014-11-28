package com.anjoyo.alertdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	/**
	 * 對話 框：
	 */
	private View view;
	private EditText et;
	/**
	 * 1.AlertDialog
	 * 2.ProgressDialog
	 * 3.DatePickerDialog
	 * 4.TimePickerDialog
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		// 自定义
		LayoutInflater lf = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = lf.inflate(R.layout.cell, null);
		et = (EditText) view.findViewById(R.id.edt1);
		// AlertDialog.Builder ab = new AlertDialog.Builder(this);
		new AlertDialog.Builder(this).setTitle("温馨提示").setMessage("您确定要退出？")
				.setView(view).setIcon(R.drawable.ic_launcher)
				.setNegativeButton("取消", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "您点击了确定",
								Toast.LENGTH_SHORT).show();
					}
				}).setNeutralButton("隐藏", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "您点击了取消",
								Toast.LENGTH_SHORT).show();
					}
				}).setPositiveButton("确定", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						Toast.makeText(MainActivity.this,
								et.getText().toString(), Toast.LENGTH_SHORT)
								.show();
					}
				}).show();

	}

}
