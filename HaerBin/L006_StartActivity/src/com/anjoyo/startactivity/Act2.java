package com.anjoyo.startactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Act2 extends Activity {
	/**
	 * �о�Activity������ʽ��2�� Activity�ش�ֵ�����յڶ���act�Ĵ��ݵ�����
	 */


	private Button btn;
	public static final int RESULT_ACT2 = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act2);
		btn = (Button) findViewById(R.id.bt1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.putExtra("act2", "����Act2");
				setResult(RESULT_ACT2, i);
				finish();
			}
		});
	
	}
}
