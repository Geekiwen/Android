package com.example.l092_acttab;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TextFragMent extends Fragment {

	// º”‘ÿ ”Õº
	private View textView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		textView = inflater.inflate(R.layout.textfragment, container, false);
		return textView;
	}
}
