package com.anjoyo.l074_scale;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv = (ImageView) findViewById(R.id.imageView1);
		iv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AnimationSet animationSet = new AnimationSet(true);
				ScaleAnimation scale = new ScaleAnimation(1, 0.5f, 1, 0.5f,
						Animation.RELATIVE_TO_PARENT, 0.5f,
						Animation.RELATIVE_TO_PARENT, 0.5f);
				scale.setDuration(3000);
				animationSet.addAnimation(scale);
				iv.startAnimation(animationSet);
			}
		});

	}

}
