package com.anjoyo.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {

	private Paint paint = new Paint();

	public MyView(Context context) {
		super(context);
		paint.setColor(Color.RED);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// ��ʼ������
		canvas.drawColor(Color.WHITE);

		// ����ɿɱ༭״̬

		canvas.save();
		// ����һ��ֱ��
		canvas.drawLine(0, 0, 100, 100, paint);
		// �ͷŵ���Դ
		canvas.restore();
		canvas.drawRect(10, 10, 100, 100, paint);
		canvas.drawCircle(150, 150, 20, paint);

		super.onDraw(canvas);
	}
}
