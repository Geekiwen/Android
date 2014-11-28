package com.anjoyo.l015_linearlayout;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	/**
	 * 1.LinearLayout: layout_grivity:ʹ���ܲ��ֵ�Ӱ�죺���õ�ǰ�ؼ��ڸ����ؼ����λ�� ��ֱֻ���������Һ�ˮƽ��
	 * ˮƽֻ���������ºʹ�ֱ�� grivity�����ܲ���Ӱ�죺���ÿؼ���������ݵ�λ�� �������Ӽ��ؼ���λ��
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
