package com.anjoyo.l071_bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
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

	public MyView(Context context) {
		super(context);
		getHolder().addCallback(this);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i1);
		// bitmap = BitmapFactory.decodeFile("/mnt/sdcard/i1");
		// bitmapDrawable = (BitmapDrawable) getResources().getDrawable(
		// R.drawable.i1);
		// bitmap = bitmapDrawable.getBitmap();
		BitmapWidth = bitmap.getWidth();
		BitmapHeight = bitmap.getHeight();
	}

	public void draw() {
		Canvas canvas = getHolder().lockCanvas();
		canvas.drawColor(0xFFFFFFFF);
		// 第一种
		// bitmapDrawable.setBounds(0, 0, BitmapWidth, BitmapHeight);
		// bitmapDrawable.draw(canvas);
		// 第二种
		// canvas.drawBitmap(bitmap, 0, 0, null);
		// 第三种
		Rect src = new Rect(0, 0, getWidth(), getHeight());
		RectF dst = new RectF(0, 0, getWidth(), getHeight());
		canvas.drawBitmap(bitmap, src, dst, null);

		getHolder().unlockCanvasAndPost(canvas);
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

}
