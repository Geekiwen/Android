package com.anjoyo.startactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Act2 extends Activity {
	/**
	 * 研究Activity启动方式：2种 Activity回传值：接收第二个act的传递的数据
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
				i.putExtra("act2", "我是Act2");
				setResult(RESULT_ACT2, i);
				finish();
			}
		});
	
	}
}
