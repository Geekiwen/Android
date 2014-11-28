package com.anjoyo.callphone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.R.string;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// 得到系统呼入电话的键
		System.out.println(intent.getExtras().keySet());
		String state = intent.getExtras().getString("state");
		System.out.println("电话状态" + state);
		String incoming_number = intent.getExtras()
				.getString("incoming_number");
		System.out.println(incoming_number);

		if ("15245066772".equals(incoming_number)) {
			TelephonyManager tm = (TelephonyManager) context
					.getSystemService(Context.TELEPHONY_SERVICE);

			try {
				// tm.getITelephony().endCall();
				// 挂断电话
				Method getITelephonyMethod = TelephonyManager.class
						.getDeclaredMethod("getITelephony");
				getITelephonyMethod.setAccessible(true);
				Object endCallMethod = getITelephonyMethod.invoke(tm);// tm.getITelephony
				Method endcall = endCallMethod.getClass().getMethod("endCall");
				endcall.invoke(endCallMethod);//getITelephony().endCall()

			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
