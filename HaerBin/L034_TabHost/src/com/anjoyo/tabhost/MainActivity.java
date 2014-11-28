package com.anjoyo.tabhost;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// ����һ��tabhost����
		TabHost tabHost = getTabHost();
		LayoutInflater.from(this).inflate(R.layout.activity_main,
				tabHost.getTabContentView(), true);

		//����tabhostѡ� 
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("����")
				.setContent(R.id.tab1));
		//����tabhostѡ� 
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("����")
				.setContent(new Intent(this, Act2.class)));

	}

}
