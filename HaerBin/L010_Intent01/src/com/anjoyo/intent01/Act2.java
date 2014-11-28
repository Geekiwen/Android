package com.anjoyo.intent01;

import android.app.Activity;
import android.os.Bundle;

public class Act2 extends Activity {

	public static final String ACTION_INTENT = "com.anjoyo.intent01.intent.action.Act2";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act2);
	}

}
