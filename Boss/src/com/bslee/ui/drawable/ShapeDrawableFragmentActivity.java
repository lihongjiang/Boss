package com.bslee.ui.drawable;

import com.bslee.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ShapeDrawableFragmentActivity extends FragmentActivity {
	
	TextView text;
	ImageView img;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.drawable_bitmap);
		text = (TextView) findViewById(R.id.text);
		img = (ImageView) findViewById(R.id.img);

		text.setText("ShapeDrawable和PaintDrawable" +
				"都是用来绘制Shape的。不能通过xml文件创建");


	}

}
