package com.anjoyo.mytabhost;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity {

	private TabHost tabHost;
	private TabWidget tabWidget;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 创建了一个tabhost对象
		tabHost = (TabHost) findViewById(R.id.tabhost);
		// tabhost初始化
		tabHost.setup();
		// 创建Tabweight对象
		tabWidget = tabHost.getTabWidget();
		// 创建选项卡
		TabSpec spec1 = tabHost.newTabSpec("Tag1");
		spec1.setIndicator(createTabView(tabHost, "亲情", R.drawable.ic_launcher));
		spec1.setContent(R.id.tab1content);
		tabHost.addTab(spec1);

		TabSpec spec2 = tabHost.newTabSpec("Tag2");
		spec2.setIndicator(createTabView(tabHost, "友情", R.drawable.ic_launcher));
		spec2.setContent(R.id.tab2content);
		tabHost.addTab(spec2);

		TabSpec spec3 = tabHost.newTabSpec("Tag3");
		spec3.setIndicator(createTabView(tabHost, "爱情", R.drawable.ic_launcher));
		spec3.setContent(R.id.tab3content);
		tabHost.addTab(spec3);

		showSpec();

		// // tabhost监听:设置tabhost背景图片的
		tabHost.setOnTabChangedListener(new OnTabChangeListener() {

			@Override
			public void onTabChanged(String tabId) {
				showSpec();
			}
		});
	}

	
	public void showSpec() {
		for (int i = 0; i < tabWidget.getChildCount(); i++) {
			// 获得当前的视图对象
			View v = tabWidget.getChildAt(i);
			// 判断当前点击的视图对象是否与得到的视图对象相同
			if (tabHost.getCurrentTab() == i) {
				v.setBackgroundResource(R.drawable.ic_icon);
			} else {
				v.setBackgroundResource(R.drawable.ic_icon_on);
			}
		}
	}

	// 自定义tabhost选项卡的视图效果
	public View createTabView(TabHost tabHost, String tabTitle, int tabIconId) {
		View tabView = LayoutInflater.from(this).inflate(R.layout.cell, null);
		TextView tv = (TextView) tabView.findViewById(R.id.textView1);
		tv.setText(tabTitle);
		ImageView iv = (ImageView) tabView.findViewById(R.id.imageView1);
		iv.setBackgroundResource(tabIconId);
		return tabView;

	}
}
