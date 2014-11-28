package com.anjoyo.l014_androidiu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	/**
	 * android UI布局 1.基本控件布局 2.布局： 3.高级控件布局（adapterView） 4.UI组件（对话框，提示框） 5.自定义控件
	 */

	// 声明：
	private TextView name_tv;
	private EditText name_et;
	private Button btn;
	private CheckBox cb;
	private LinearLayout ly;
	String nameet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		name_tv = (TextView) findViewById(R.id.main_tv_name);
		name_et = (EditText) findViewById(R.id.main_et_name);
		btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				nameet = name_et.getText().toString();
				name_tv.setText(nameet);
			}
		});
	}
}
