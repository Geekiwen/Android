package com.anjoyo.dataactivity;

import android.app.Activity;
import android.os.Bundle;

public class Act2 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act2);
		//�õ���һ��act���ݹ���������
		
		String val = getIntent().getStringExtra("data");
		System.out.println(val);
	}

}