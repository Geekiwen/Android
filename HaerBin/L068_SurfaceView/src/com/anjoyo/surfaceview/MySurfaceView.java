package com.anjoyo.surfaceview;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements
		SurfaceHolder.Callback {

	private Paint paint = new Paint();
	private Timer timer;
	private TimerTask task;
	private float x = 0;
	private float y = 0;
	private float speedx = 50;
	private float speedy = 50;
	private float addx = 2;
	private float addy = 2;

	public MySurfaceView(Context context) {
		super(context);
		paint.setColor(Color.BLUE);
		getHolder().addCallback(this);
	}

	public void draw() {
		Canvas canvas = getHolder().lockCanvas();// 锁定画布
		// 绘制图形
		canvas.drawColor(Color.WHITE);// 初始化画布
		canvas.drawRect(x, y, speedx + x, speedy + y, paint);
		x += addx;
		y += addy;
		if (x < 0) {
			addx = Math.abs(addx);
		}
		if (x > getWidth() - speedx) {
			addx = -Math.abs(addx);
		}
		if (y < 0) {
			addy = Math.abs(addy);
		}
		if (y > getHeight() - speedy) {
			addy = -Math.abs(addy);
		}
		getHolder().unlockCanvasAndPost(canvas);// 解锁画布
	}

	public void startTimer() {
		timer = new Timer();
		task = new TimerTask() {

			@Override
			public void run() {
				draw();
			}
		};
		timer.schedule(task, 100, 100);
	}

	public void stopTimer() {
		timer.cancel();
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		startTimer();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		stopTimer();

	}

}
