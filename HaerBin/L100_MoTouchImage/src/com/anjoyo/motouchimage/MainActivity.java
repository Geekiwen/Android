package com.anjoyo.motouchimage;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainActivity extends Activity implements OnTouchListener {

	private MyView view;
	private float tance = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = new MyView(this);
		setContentView(view);
		view.setOnTouchListener(this);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {

		// 判断当前是否是双指操作
		if (event.getPointerCount() >= 2) {
			float p1_x = event.getX(0);
			float p1_y = event.getY(0);
			float p2_x = event.getX(1);
			float p2_y = event.getY(1);
			// 获得两指间的距离
			float disp_x = p2_x - p1_x;
			float disp_y = p2_y - p1_y;
			float distance = (float) Math.sqrt(disp_x * disp_x + disp_y
					* disp_y);
			System.out.println("两点间的距离为:" + distance);
			if (tance == 0) {
				tance = distance;
			} else {
				if (distance - tance > 10) {
					// 放大
					view.scaleMothd(view.getScale().x + 0.01f,
							view.getScale().y + 0.01f);
				} else if (distance - tance < -10) {
					// 缩小
					view.scaleMothd(view.getScale().x - 0.01f,
							view.getScale().y - 0.01f);
				}
			}
		}
		if (event.getAction() == MotionEvent.ACTION_UP) {
			tance = 0;
		}

		return true;
	}
}
