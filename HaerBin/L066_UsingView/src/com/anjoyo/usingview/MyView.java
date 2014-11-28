package com.anjoyo.usingview;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.text.format.Time;
import android.view.View;

public class MyView extends View {

	private Paint paint = new Paint();
	private float x = 0;
	private float y = 0;
	private float speedx = 50;
	private float speedy = 50;
	private float addy = 2;
	private Timer timer;
	private TimerTask task;

	public MyView(Context context) {
		super(context);
		paint.setColor(Color.RED);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(0xFFFFFFFF);
		canvas.drawRect(x, y, speedx, speedy + y, paint);
		y += addy;
		super.onDraw(canvas);
		if (y < 0) {
			addy = Math.abs(addy);
		}
		if (y > getHeight() - speedy) {
			addy = -Math.abs(addy);
		}
	}

	public void startTimer() {
		timer = new Timer();
		task = new TimerTask() {

			@Override
			public void run() {
				handler.sendEmptyMessage(0);
			}
		};
		timer.schedule(task, 100, 10);
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			invalidate();// ÖØÐÂ»ØÖ´
		};
	};

}
