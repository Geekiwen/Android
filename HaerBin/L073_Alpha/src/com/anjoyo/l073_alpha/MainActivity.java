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
				// ����Animationset����
				AnimationSet animationSet = new AnimationSet(true);
				// ����Animation
				AlphaAnimation alpha = new AlphaAnimation(1, 0);
				// ���ö���������
				alpha.setDuration(3000);
				// ���������뵽AnimationSet��
				animationSet.addAnimation(alpha);
				// ����Ӧ�Ŀؼ����϶���
				iv.startAnimation(animationSet);
			}
		});
	}

}
