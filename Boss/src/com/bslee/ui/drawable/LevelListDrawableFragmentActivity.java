package com.bslee.ui.drawable;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bslee.boss.R;

public class LevelListDrawableFragmentActivity extends FragmentActivity {
	private int[] ids = new int[] { R.drawable.w01, R.drawable.w02,
			R.drawable.w03, R.drawable.w04, R.drawable.w05 };
	TextView text;
	ImageView img;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.drawable_bitmap);
		text = (TextView) findViewById(R.id.text);
		img = (ImageView) findViewById(R.id.img);

		text.setText("一个LeveListDrawable管理着一组交替的drawable资源。"
				+ "LeveListDrawable里面的每一个drawable资源与一个最大数值结合起来"
				+ "，作为LevelListDrawable资源的一项。"
				+ "调用Drawable的setLevel()方法可以加载level-list或代码中定义的"
				+ "某个drawable资源，判断加载某项的方式：level-list中某项的android:maxLevel"
				+ "数值大于或者等于setLevel设置的数值，就会被加载"
				+ "\n使用LevelDrawable注意几点："
				+ "1、默认的level为0，如果没有和0匹配的level，那么就不显示。"
				+ "\n"
				+ "2、level匹配以maxLevel优先。即如果有个item，min：1，max：2。   另一份item，min：2，max：3。"
				+ "如果此时设置level=2，那么会匹配第一个item。");
		// 布局
		img.setImageDrawable(getResources().getDrawable(
				R.drawable.drawable_level));

		// 代码设置
		// BitmapFactory.Options opts = new BitmapFactory.Options();
		// opts.inJustDecodeBounds = true;
		// BitmapFactory.decodeResource(getResources(), R.drawable.w01, opts);
		// opts.inSampleSize = computeSampleSize(opts, -1, 500 * 500);
		// opts.inJustDecodeBounds = false;
		//
		// LevelListDrawable levelListDrawable = new LevelListDrawable();//
		// 定义一个LevelDrawable
		// try {
		// for (int i = 0; i < ids.length; i++) {// for循环，加载5个drawable资源
		// Bitmap bmp = BitmapFactory.decodeResource(getResources(),
		// ids[i], opts);
		// BitmapDrawable bitmapDrawable = new BitmapDrawable(bmp);
		// levelListDrawable.addLevel(i, i + 1, bitmapDrawable);//
		// 添加到LevelListDrawable
		// }
		// img.setImageDrawable(levelListDrawable);// 设置
		// } catch (OutOfMemoryError err) {
		// err.printStackTrace();
		// }

		img.setImageLevel(1);// 默认的level为0，将到设置为1

		img.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int i = img.getDrawable().getLevel();
				if (i >= 5)
					i = 0;
				// imageView.setImageLevel(++i);//改变level
				img.getDrawable().setLevel(++i); // 能达到同样的效果
			}
		});

	}

	private static int computeSampleSize(BitmapFactory.Options options,
			int minSideLength, int maxNumOfPixels) {
		double w = options.outWidth;
		double h = options.outHeight;

		int lowerBound = (maxNumOfPixels == -1) ? 1 : (int) Math.ceil(Math
				.sqrt(w * h / maxNumOfPixels));
		int upperBound = (minSideLength == -1) ? 128 : (int) Math.min(
				Math.floor(w / minSideLength), Math.floor(h / minSideLength));

		if (upperBound < lowerBound) {
			// return the larger one when there is no overlapping zone.
			return lowerBound;
		}

		if ((maxNumOfPixels == -1) && (minSideLength == -1)) {
			return 1;
		} else if (minSideLength == -1) {
			return lowerBound;
		} else {
			return upperBound;
		}
	}
}
