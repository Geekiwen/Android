package com.anjoyo.l078_animationlisten;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView iv;
	private AlphaAnimation a1 = new AlphaAnimation(1, 0);
	private AlphaAnimation a2 = new AlphaAnimation(0, 1);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv = (ImageView) findViewById(R.id.imageView1);
		a1.setDuration(2000);
		a2.setDuration(2000);
		iv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				iv.startAnimation(a1);
			}
		});
		a1.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				iv.startAnimation(a2);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
