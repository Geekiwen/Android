package com.anjoyo.helloword;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MyActivity extends Activity {

	/**
	 * Android�Ĵ������� Activity�� Service:���� BraodCastReceiver:�㲥
	 * ContentProvider:�����ṩ��
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);

//		System.out.println("�ܸ�������������");
//		Log.d("TAG", "HelloWorld");
//		Log.e("TAG", "HelloWorld");
//		Log.w("TAG", "HelloWorld");
//		Log.v("TAG", "HelloWorld");
//		Log.i("TAG", "HelloWorld");
		
	}

}
