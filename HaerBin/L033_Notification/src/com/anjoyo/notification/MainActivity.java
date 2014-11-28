package com.anjoyo.notification;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 创建NofiticationMa
		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		// 创建Nofitication
		Notification notification = new Notification(R.drawable.ic_launcher,
				"天气提示", System.currentTimeMillis());
		Intent intent = new Intent(MainActivity.this, MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 1,
				intent, 0);
		// 设置Nofitication的信息
		notification.setLatestEventInfo(this, "哈尔滨天气预报", "太冷了，受不了",
				pendingIntent);
		// 启动notification
		notificationManager.notify(1, notification);
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.cancel(1);// 取消当前的notification
		
	}

}
