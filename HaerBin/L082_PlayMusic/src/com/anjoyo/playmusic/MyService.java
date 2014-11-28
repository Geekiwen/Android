package com.anjoyo.playmusic;

import java.io.File;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;

public class MyService extends Service {

	private MediaPlayer mediaPlayer;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// mediaPlayer = MediaPlayer.create(this, R.raw.yonggan);
		mediaPlayer = MediaPlayer.create(
				this,
				Uri.fromFile(new File(Environment.getExternalStorageDirectory()
						.getAbsoluteFile() + "/bai.mp3")));
		mediaPlayer.start();
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		mediaPlayer.stop();
		super.onDestroy();
	}
}
