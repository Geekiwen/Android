package com.anjoyo.callphone;

import android.R.string;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// �õ�ϵͳ����绰�ļ�
		System.out.println(intent.getExtras().keySet());
		String state = intent.getExtras().getString("state");
		System.out.println("�绰״̬" + state);
		String incoming_number = intent.getExtras()
				.getString("incoming_number");
		System.out.println(incoming_number);
	}

}
