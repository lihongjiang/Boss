package com.bslee.ui.activity;

import com.bslee.R;

import android.app.Activity;
import android.os.Bundle;

public class LifeCycleActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lifecycle);
	}
}
