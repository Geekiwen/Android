package com.anjoyo.fbfanimation;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private Button startbtn, stopbtn;
	private ImageView iv;
	private AnimationDrawable animationDrawable;
	private int ids[] = { R.drawable.anim_0010001, R.drawable.anim_0010002,
			R.drawable.anim_0010003, R.drawable.anim_0010004,
			R.drawable.anim_0010005, R.drawable.anim_0010006,
			R.drawable.anim_0010007, R.drawable.anim_0010008,
			R.drawable.anim_0010009, R.drawable.anim_0010010,
			R.drawable.anim_0010011, R.drawable.anim_0010012,
			R.drawable.anim_0010013, R.drawable.anim_0010014,
			R.drawable.anim_0010015 };

	private Resources resources;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startbtn = (Button) findViewById(R.id.button1);
		stopbtn = (Button) findViewById(R.id.button2);
		startbtn.setOnClickListener(this);
		iv = (ImageView) findViewById(R.id.imageView1);
		stopbtn.setOnClickListener(this);
		resources = getResources();
		animationDrawable = new AnimationDrawable();
		for (int i = 0; i < ids.length; i++) {
			animationDrawable.addFrame(resources.getDrawable(ids[i]), 100);
		}
		iv.setBackgroundDrawable(animationDrawable);
		animationDrawable.setVisible(true, false);
		animationDrawable.setOneShot(true);
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
