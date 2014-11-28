package com.anjoyo.l069_ball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball {

	private MyView view;
	private float x = 0;
	private float y = 0;
	private float r = 20;
	private Paint paint = new Paint();
	private float addx = 0;
	private float addy = 0;

	public Ball(MyView view) {
		this.view = view;
		setX((float) (Math.random() * 320));
		setY((float) (Math.random() * 400));
		addx = ((float) (Math.random() * 10 - 5));
		addy = ((float) (Math.random() * 10 - 5));
		paint.setColor(Color.RED);
	}

	public void draw(Canvas canvas) {
		canvas.drawCircle(x, y, r, paint);
		x += addx;
		y += addy;
		if (x < r) {
			addx = Math.abs(addx);
		}
		if (x > view.getWidth() - r) {
			addx = -Math.abs(addx);
		}
		if (y < r) {
			addy = Math.abs(addy);
		}
		if (y > view.getHeight() - r) {
			addy = -Math.abs(addy);
		}
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getAddx() {
		return addx;
	}

	public void setAddx(float addx) {
		this.addx = addx;
	}

	public float getAddy() {
		return addy;
	}

	public void setAddy(float addy) {
		this.addy = addy;
	}

}
