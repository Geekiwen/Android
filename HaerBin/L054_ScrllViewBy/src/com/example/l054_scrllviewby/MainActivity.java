package com.example.l054_scrllviewby;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.ScrollView;

public class MainActivity extends Activity {

	private ScrollView sv;
	private Handler handler;
	private int lastScrollViewPosition = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sv = (ScrollView) findViewById(R.id.scrollView1);

		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == 1) {
					int startScrollViewPosition = sv.getScrollY();// 获得当前svY坐标
					if ( sv.getScrollY() == 0
							|| startScrollViewPosition != lastScrollViewPosition) {
						lastScrollViewPosition = sv.getScrollY();
						sv.scrollBy(0, 2);
						sendEmptyMessageDelayed(1, 100);
					}
				}
				super.handleMessage(msg);
			}
		};
		handler.sendEmptyMessageDelayed(1, 100);
	}

}
