package com.anjoyo.helloword;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MyActivity extends Activity {

	/**
	 * Android四大基本组件 Activity： Service:服务 BraodCastReceiver:广播
	 * ContentProvider:内容提供者
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);

//		System.out.println("很高兴来到哈尔滨");
//		Log.d("TAG", "HelloWorld");
//		Log.e("TAG", "HelloWorld");
//		Log.w("TAG", "HelloWorld");
//		Log.v("TAG", "HelloWorld");
//		Log.i("TAG", "HelloWorld");
		
	}

}
