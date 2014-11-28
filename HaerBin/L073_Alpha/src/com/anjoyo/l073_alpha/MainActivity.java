package com.anjoyo.l073_alpha;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
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
				// 创建Animationset对象
				AnimationSet animationSet = new AnimationSet(true);
				// 创建Animation
				AlphaAnimation alpha = new AlphaAnimation(1, 0);
				// 设置动画的属性
				alpha.setDuration(3000);
				// 将动画放入到AnimationSet中
				animationSet.addAnimation(alpha);
				// 给相应的控件加上动画
				iv.startAnimation(animationSet);
			}
		});
	}

}
