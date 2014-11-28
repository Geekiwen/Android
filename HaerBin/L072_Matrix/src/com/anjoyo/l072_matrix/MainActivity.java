package com.anjoyo.l072_matrix;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn1, btn2;
	private ImageView iv;
	// ÒýÈëÍ¼Æ¬
	private Bitmap bitmap;
	private Matrix matrix;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		iv = (ImageView) findViewById(R.id.imageView1);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		matrix = new Matrix();
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btn1:
			matrix.postRotate(10);
			//set post  pre
			Bitmap b1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
					bitmap.getHeight(), matrix, true);
			iv.setImageBitmap(b1);
			break;

		case R.id.btn2:
			matrix.postScale(0.9f, 0.9f);
			Bitmap b2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
					bitmap.getHeight(), matrix, true);
			iv.setImageBitmap(b2);
			break;
		}
	}

}
