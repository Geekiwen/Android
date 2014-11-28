package com.anjoyo.l069_ball;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Canvas;
import android.test.AndroidTestCase;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MyView extends SurfaceView implements Callback {

	private Ball ball;
	private Timer timer;
	private TimerTask task;
	private List<Ball> balls = new ArrayList<Ball>();

	public MyView(Context context) {
		super(context);
		for (int i = 0; i < 50; i++) {
			balls.add(new Ball(this));
		}
		getHolder().addCallback(this);
	}

	public void draw() {
		Canvas canvas = getHolder().lockCanvas();
		canvas.drawColor(0xFFFFFFFF);
		// ball.draw(canvas);
		for (Ball b : balls) {
			b.draw(canvas);
		}
		getHolder().unlockCanvasAndPost(canvas);
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
		timer = null;
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
