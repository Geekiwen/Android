package com.anjoyo.l084_playvideo;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button startbtn, pausebtn, stopbtn, positionbtn;
	private SurfaceView surfaceView;
	private MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startbtn = (Button) findViewById(R.id.start);
		pausebtn = (Button) findViewById(R.id.pause);
		stopbtn = (Button) findViewById(R.id.stop);
		positionbtn = (Button) findViewById(R.id.setPositoin);
		surfaceView = (SurfaceView) findViewById(R.id.view);
		// surfaceview自己不管理缓冲区，而是等待屏幕渲染器引擎去自动呈现视频到用戶面前
		surfaceView.getHolder()
				.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		startbtn.setOnClickListener(this);
		pausebtn.setOnClickListener(this);
		stopbtn.setOnClickListener(this);
		positionbtn.setOnClickListener(this);
		mediaPlayer = new MediaPlayer();
	}

	public void play() {
		mediaPlayer.reset();
		try {
			mediaPlayer.setDataSource(Environment.getExternalStorageDirectory()
					.getAbsoluteFile() + "/newjiao.mp4");
			// 视频输出到surfaceview上面
			mediaPlayer.setDisplay(surfaceView.getHolder());
			mediaPlayer.prepare();// 准备资源
			mediaPlayer.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getPosition() {
		if (mediaPlayer.isPlaying()) {
			int time = mediaPlayer.getDuration();// 获得当前视频的长度
			int times = mediaPlayer.getCurrentPosition();// 得到当前视频执行了多少时间
			System.out.println(time + "--" + times);

		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start:
			play();

			break;

		case R.id.pause:
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.pause();
			} else {
				mediaPlayer.start();
			}
			break;

		case R.id.stop:
			mediaPlayer.stop();
			break;

		case R.id.setPositoin:
			mediaPlayer.seekTo(5000);
			getPosition();
			break;
		}
	}

}
