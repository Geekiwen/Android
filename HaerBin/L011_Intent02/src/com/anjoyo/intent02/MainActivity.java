package com.anjoyo.intent02;

import java.net.URI;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Intent i = new
				// Intent("com.anjoyo.intent01.intent.action.Act2");
				// startActivity(i);
//				startActivity(new Intent(Intent.ACTION_CALL, Uri
//						.parse("tel://10086")));
				startActivity(new Intent(Intent.ACTION_SENDTO, Uri
						.parse("smsto://10056")));

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
