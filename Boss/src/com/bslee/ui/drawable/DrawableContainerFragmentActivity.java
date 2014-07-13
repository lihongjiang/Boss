package com.bslee.ui.drawable;

import com.bslee.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawableContainerFragmentActivity extends FragmentActivity {
	
	TextView text;
	ImageView img;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.drawable_bitmap);
		text = (TextView) findViewById(R.id.text);
		img = (ImageView) findViewById(R.id.img);

		text.setText("DrawableContainer一个帮助类，" +
				"包含了多个Drawable，你可以选中一个拿来使用。" +
				"你也可以继承它重写自己的DrawableContainers。" +
				"或者直接使用它的某个子类。AnimationDrawable," +
				" LevelListDrawable, StateListDrawable都是它的子类。");

	}

}
