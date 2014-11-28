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
		// surfaceview�Լ����������������ǵȴ���Ļ��Ⱦ������ȥ�Զ�������Ƶ���Ñ���ǰ
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
			// ��Ƶ�����surfaceview����
			mediaPlayer.setDisplay(surfaceView.getHolder());
			mediaPlayer.prepare();// ׼����Դ
			mediaPlayer.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getPosition() {
		if (mediaPlayer.isPlaying()) {
			int time = mediaPlayer.getDuration();// ��õ�ǰ��Ƶ�ĳ���
			int times = mediaPlayer.getCurrentPosition();// �õ���ǰ��Ƶִ���˶���ʱ��
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
