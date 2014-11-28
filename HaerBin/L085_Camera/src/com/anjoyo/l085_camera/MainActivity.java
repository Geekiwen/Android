package com.anjoyo.l085_camera;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private Button btn;
	private ImageView iv;
	private File phoneFile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.button1);
		iv = (ImageView) findViewById(R.id.imageView1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				phoneFile = new File(Environment.getExternalStorageDirectory()
						.getAbsoluteFile() + "/ph01.jpg");
				intent.putExtra(MediaStore.EXTRA_OUTPUT,
						Uri.fromFile(phoneFile));
				startActivityForResult(intent, 1);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Bitmap bitmap = BitmapFactory.decodeFile(phoneFile.getAbsolutePath());// ¾ø¶ÔÂ·¾¶
		iv.setImageBitmap(bitmap);
	}

}
