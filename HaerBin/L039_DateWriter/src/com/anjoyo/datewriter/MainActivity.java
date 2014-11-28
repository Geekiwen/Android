package com.anjoyo.datewriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		File file = new File("mnt/sdcard/anjoyo/hs.txt");
//		if (!file.exists()) {
//			File f = file.getParentFile();// 返回上一级目录
//			if (!f.exists()) {
//				f.mkdir();
//			}
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

		// 写入数据
		OutputStream os;
		try {
			os = new FileOutputStream(file);
			os.write(new String("call me may be").getBytes());
			os.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
