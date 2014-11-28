package com.anjoyo.drawpath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MyView extends SurfaceView implements Callback, OnTouchListener {

	private Paint paint = new Paint();
	private Path path = new Path();

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		getHolder().addCallback(this);
		paint.setColor(Color.RED);
		paint.setTextSize(10);
		paint.setStyle(Style.STROKE);
		setOnTouchListener(this);
	}

	public void draw() {
		Canvas canvas = getHolder().lockCanvas();
		canvas.drawColor(Color.WHITE);
		canvas.drawPath(path, paint);
		getHolder().unlockCanvasAndPost(canvas);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		draw();
	}

	public void clear() {
		path.reset();// ÖØÖÃ
		draw();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			path.moveTo(event.getX(), event.getY());
			draw();
			break;

		case MotionEvent.ACTION_MOVE:
			path.lineTo(event.getX(), event.getY());
			draw();
			break;
		}
		return true;
	}

}
