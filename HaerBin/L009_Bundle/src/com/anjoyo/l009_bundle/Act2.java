package com.anjoyo.l009_bundle;

import android.app.Activity;
import android.os.Bundle;

public class Act2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act2);
		Bundle bundle = getIntent().getExtras();
		String val = bundle.getString("name");
		System.out.println(val);
	}
}
