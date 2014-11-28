package com.anjoyo.playmusic;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button playbtn, pausebtn, stopbtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		playbtn = (Button) findViewById(R.id.play);
		pausebtn = (Button) findViewById(R.id.pause);
		stopbtn = (Button) findViewById(R.id.stop);
		playbtn.setOnClickListener(this);
		pausebtn.setOnClickListener(this);
		stopbtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.play:
			// mediaPlayer.start();
			startService(new Intent(this, MyService.class));
			break;

		case R.id.pause:
			// mediaPlayer.pause();
			break;
		case R.id.stop:
			stopService(new Intent(this, MyService.class));
			// mediaPlayer.pause();
			// mediaPlayer.seekTo(0);//当前的播放位置处于0的位置
			// mediaPlayer.getDuration()
			// mediaPlayer.getCurrentPosition()
			// mediaPlayer.stop();
			// try {
			// mediaPlayer.prepare();
			// } catch (IllegalStateException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			break;
		}
	}

}
