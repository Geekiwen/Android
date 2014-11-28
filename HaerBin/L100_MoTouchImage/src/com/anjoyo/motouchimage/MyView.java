package com.anjoyo.motouchimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MyView extends SurfaceView implements Callback {

	private Bitmap bitmap;
	private BitmapDrawable bitmapDrawable;
	private int BitmapHeight = 0;
	private int BitmapWidth = 0;
	private Rect src = new Rect();
	private RectF dst = new RectF();
	private PointF scale = new PointF(1, 1);

	public MyView(Context context) {
		super(context);
		getHolder().addCallback(this);
		bitmapDrawable = (BitmapDrawable) getResources().getDrawable(
				R.drawable.i1);
		bitmap = bitmapDrawable.getBitmap();
		BitmapHeight = bitmap.getHeight();
		BitmapWidth = bitmap.getWidth();
		src.bottom = BitmapHeight;
		src.right = BitmapWidth;
		dst.bottom = src.bottom;
		dst.right = src.right;
	}

	private void draw() {
		Canvas canvas = getHolder().lockCanvas();
		canvas.drawColor(Color.WHITE);
		canvas.save();
		canvas.scale(getScale().x, getScale().y, getWidth() / 2,
				getHeight() / 2);
		// »æÖÆÍ¼Æ¬
		canvas.drawBitmap(bitmap, src, dst, null);
		canvas.restore();
		getHolder().unlockCanvasAndPost(canvas);
	}

	public void scaleMothd(float scalex, float scaley) {
		getScale().x = scalex;
		getScale().y = scaley;
		if (getScale().x > 0.5) {
			draw();
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		draw();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}

	public PointF getScale() {
		return scale;
	}

	public void setScale(PointF scale) {
		this.scale = scale;
	}

}
