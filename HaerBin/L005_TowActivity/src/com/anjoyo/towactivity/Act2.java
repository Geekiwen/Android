package com.anjoyo.towactivity;

import android.app.Activity;
import android.os.Bundle;

public class Act2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act2);
		System.out.println("2---onCreate");
	}

	@Override
	protected void onStart() {
		System.out.println("2---onStart");
		super.onStart();
	}

	@Override
	protected void onResume() {
		System.out.println("2---onResume");
		super.onResume();
	}

	@Override
	protected void onPause() {
		System.out.println("2---onPause");
		super.onPause();
	}

	@Override
	protected void onStop() {
		System.out.println("2---onStop");
		super.onStop();
	}

	@Override
	protected void onRestart() {
		System.out.println("2---onRestart");
		super.onRestart();
	}

	@Override
	protected void onDestroy() {
		System.out.println("2---onDestroy");
		super.onDestroy();
	}

}
