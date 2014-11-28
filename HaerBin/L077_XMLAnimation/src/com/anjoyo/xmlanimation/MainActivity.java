package com.anjoyo.xmlanimation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn1, btn2, btn3, btn4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn3 = (Button) findViewById(R.id.button3);
		btn4 = (Button) findViewById(R.id.button4);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			// 引用资源文件
			Animation animation = AnimationUtils.loadAnimation(this,
					R.anim.alpha);
			btn1.startAnimation(animation);
			break;
		case R.id.button2:
			Animation animation1 = AnimationUtils.loadAnimation(this,
					R.anim.rotate);
			btn2.startAnimation(animation1);
			break;
		case R.id.button3:

			break;
		case R.id.button4:

			break;

		}
	}

}
