package com.bslee.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.bslee.boss.R;

public class LifeCycleActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lifecycle);
	}
}
