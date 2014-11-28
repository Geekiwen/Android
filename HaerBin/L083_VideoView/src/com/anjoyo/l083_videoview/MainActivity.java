package com.anjoyo.l083_videoview;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Video;
import android.app.Activity;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

	private VideoView vv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		vv = (VideoView) findViewById(R.id.videoView1);
		vv.setMediaController(new MediaController(this));
		vv.setVideoURI(Uri.fromFile(new File(Environment
				.getExternalStorageDirectory().getAbsoluteFile()
				+ "/newjiao.mp4")));
		vv.start();
	}

}
