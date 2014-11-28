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
		
		// 创建一个tabhost对象
		TabHost tabHost = getTabHost();
		LayoutInflater.from(this).inflate(R.layout.activity_main,
				tabHost.getTabContentView(), true);

		//加载tabhost选项卡 
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("亲情")
				.setContent(R.id.tab1));
		//加载tabhost选项卡 
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("友情")
				.setContent(new Intent(this, Act2.class)));

	}

}
