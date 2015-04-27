package com.bslee.ui.drawable;

import android.graphics.drawable.RotateDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bslee.boss.R;

public class RotateDrawableFragmentActivity extends FragmentActivity {
	RotateDrawable rotateDrawable;
	int level = 0;
	TextView text;
	ImageView img;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.drawable_bitmap);
		text = (TextView) findViewById(R.id.text);
		img = (ImageView) findViewById(R.id.img);

		text.setText("基于当前的level，进行旋转的drawable。图片将从-90到180进行旋转。level值为10000，也就是说level每加1000，即顺时针旋转270/10000*1000=27度。");

		img.setImageResource(R.drawable.drawable_rotate);

		rotateDrawable = (RotateDrawable) img.getDrawable();
		thread.start();

	}

	Thread thread = new Thread(new Runnable() {
		public void run() {
			while (level <= 10000) {
				handler.sendEmptyMessage(0x00);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			Toast.makeText(RotateDrawableFragmentActivity.this, level + "", 500)
					.show();
			rotateDrawable.setLevel(level);
			level += 1000;
		};
	};
}
