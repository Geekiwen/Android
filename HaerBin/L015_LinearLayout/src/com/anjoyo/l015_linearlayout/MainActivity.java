package com.anjoyo.l015_linearlayout;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	/**
	 * 1.LinearLayout: layout_grivity:使用受布局的影响：设置当前控件在父级控件里的位置 垂直只能设置左右和水平中
	 * 水平只能设置上下和垂直中 grivity：不受布局影响：设置控件里面的内容的位置 设置其子级控件的位置
	 * 
	 * 2.RelativeLayout 3.FrameLayout 4.TableLayout 5.
	 */
	private Button btn1, btn2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo);
		btn1 = (Button) findViewById(R.id.main_gone_btn);
		btn2 = (Button) findViewById(R.id.main_show_btn);
		
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn1.setVisibility(View.VISIBLE);
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
