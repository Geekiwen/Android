package com.example.l092_acttab;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ImageFragMent extends Fragment {

	private View imageView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		imageView = inflater.inflate(R.layout.imagefragment, container, false);
		return imageView;
	}

}
