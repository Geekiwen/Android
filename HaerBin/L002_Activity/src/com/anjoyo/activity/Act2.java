package com.anjoyo.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * 创建Activity：
 * 1.继承Activity
 * 2.覆写oncreate方法
 * 3.创建一个xml文件
 * 4.通过setContentView加载视图
 * 5.在AndroidManifest文件中注册：书写一个activity标签，标签中需加入一个name属性
 */

public class Act2 extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act2);//加载视图
	}
	
}
