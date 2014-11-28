package com.anjoyo.fbfxmlanimation;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn1, btn2;
	private ImageView iv;
	private AnimationDrawable animationDrawable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		iv = (ImageView) findViewById(R.id.imageView1);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		animationDrawable = (AnimationDrawable) iv.getBackground();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			animationDrawable.start();
			break;

		case R.id.button2:
			animationDrawable.stop();
			break;
		}
	}

}
