package com.anjoyo.startactivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btn1, btn2;
	public static final int REQUEST_A = 1;
	public static final int REQUEST_B = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1 = (Button) findViewById(R.id.btn);
		btn2 = (Button) findViewById(R.id.btn2);
		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				startActivityForResult(
						new Intent(MainActivity.this, Act2.class), REQUEST_A);
			}
		});
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				startActivityForResult(
						new Intent(MainActivity.this, Act3.class), REQUEST_B);
			}
		});
	}

	// 当一个任务结束的时候出发
	/**
	 * requestCode:匹配跳转的act
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case REQUEST_A://act2
			switch (resultCode) {
			case 1:
				System.out.println(data.getStringExtra("act2"));
				break;

			case 2:
				System.out.println("未得到数据");
				break;
			}
			break;

		case REQUEST_B://act3
			switch (resultCode) {
			case 1:
				System.out.println("未得到数据");
				break;

			case 2:
				System.out.println(data.getStringExtra("act3"));
				break;
			}
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}
