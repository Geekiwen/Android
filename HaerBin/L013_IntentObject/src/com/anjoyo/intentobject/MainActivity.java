package com.anjoyo.intentobject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/**
		 * Intent对象有6个： 1、componentName:setClass SetCompnent setClassName
		 * 2、Action: 3、Data:
		 * 4、extra:
		 * 5、flag
		 * 6、category:
		 */

		Intent i = new Intent();
		i.setClass(MainActivity.this, Act2.class);
		startActivity(i);
		startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel://10086")));
		i.setDataAndType(Uri.parse("file://mnt/sdcard/a"), ".data.mp3");
		//setType:
	}
}
