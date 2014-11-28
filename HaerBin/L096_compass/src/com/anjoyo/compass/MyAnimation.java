package com.anjoyo.compass;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class MyAnimation extends Animation {

	private int width = 0;
	private int height = 0;
	private float startposition = 0;
	private float stopposition = 0;

	// ≥ı ºªØ
	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight) {
		this.width = width;
		this.height = height;
		super.initialize(width, height, parentWidth, parentHeight);
	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		float distance = stopposition - startposition;
		t.getMatrix().setRotate(startposition + distance * interpolatedTime,
				width / 2, height / 2);
		super.applyTransformation(interpolatedTime, t);
	}

	public float getStartposition() {
		return startposition;
	}

	public void setStartposition(float startposition) {
		this.startposition = startposition;
	}

	public float getStopposition() {
		return stopposition;
	}

	public void setStopposition(float stopposition) {
		this.stopposition = stopposition;
	}
	
	
	
	
}
