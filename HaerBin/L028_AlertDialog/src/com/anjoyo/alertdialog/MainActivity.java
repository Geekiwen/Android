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
	 * ��Ԓ ��
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
		
		
		// �Զ���
		LayoutInflater lf = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = lf.inflate(R.layout.cell, null);
		et = (EditText) view.findViewById(R.id.edt1);
		// AlertDialog.Builder ab = new AlertDialog.Builder(this);
		new AlertDialog.Builder(this).setTitle("��ܰ��ʾ").setMessage("��ȷ��Ҫ�˳���")
				.setView(view).setIcon(R.drawable.ic_launcher)
				.setNegativeButton("ȡ��", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "�������ȷ��",
								Toast.LENGTH_SHORT).show();
					}
				}).setNeutralButton("����", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "�������ȡ��",
								Toast.LENGTH_SHORT).show();
					}
				}).setPositiveButton("ȷ��", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						Toast.makeText(MainActivity.this,
								et.getText().toString(), Toast.LENGTH_SHORT)
								.show();
					}
				}).show();

	}

}
