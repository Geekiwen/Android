package com.anjoyo.usingactivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	//声明一个Button
	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//通过findviewbyid方法去引入资源文件
		btn = (Button)findViewById(R.id.btn);
		//给按钮做监听
		btn.setOnClickListener(new OnClickListener() {
			
			//次方法是出发事件的方法
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, Act2.class);// 要从MainAct跳转到Act2里
				// 启动Activity的方法
				startActivity(i);
			}
		});
		
	}

}
