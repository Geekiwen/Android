package com.anjoyo.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * ����Activity��
 * 1.�̳�Activity
 * 2.��дoncreate����
 * 3.����һ��xml�ļ�
 * 4.ͨ��setContentView������ͼ
 * 5.��AndroidManifest�ļ���ע�᣺��дһ��activity��ǩ����ǩ�������һ��name����
 */

public class Act2 extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act2);//������ͼ
	}
	
}
