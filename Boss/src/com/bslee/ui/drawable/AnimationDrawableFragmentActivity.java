package com.bslee.ui.drawable;

import com.bslee.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationDrawableFragmentActivity extends FragmentActivity {
	
	TextView text;
	ImageView img;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.drawable_bitmap);
		text = (TextView) findViewById(R.id.text);
		img = (ImageView) findViewById(R.id.img);

		text.setText("AnimationDrawable用来创建动画的，" +
				"因为有的动画并不是Drawable，所以将他归为" +
				"anim Resource。将在以后学习动画的学习。");


	}

}
