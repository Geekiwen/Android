package com.anjoyo.progressdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.view.Menu;

public class MainActivity extends Activity {

	private ProgressDialog pd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		pd = new ProgressDialog(this);
		pd.setTitle("温馨提示");
		pd.setMessage("正在下载");
		pd.setMax(100);
		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pd.setButton("确定", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			}
		});
		pd.setButton2("确定", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

			}
		});

		pd.show();

	}

}
