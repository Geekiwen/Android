package com.anjoyo.dataactivity;

import android.app.Activity;
import android.os.Bundle;

public class Act2 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act2);
		//得到第一个act传递过来的数据
		
		String val = getIntent().getStringExtra("data");
		System.out.println(val);
	}

}
