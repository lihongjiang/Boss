package com.bslee.ui.widget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bslee.R;
import com.bslee.widget.MyScrollLayout;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 14-6-1 Time: 下午10:56 To
 * change this template use File | Settings | File Templates.
 */
public class LoadPageActivity extends Activity implements OnViewChangeListener {
	private LinearLayout animLayout;
	private LinearLayout leftLayout;
	private RelativeLayout mainRLayout;
	private LinearLayout pointLayout;
	private MyScrollLayout scrollLayout;
	private LinearLayout rightLayout;
	private Button startBtn;
	private int count;
	private ImageView[] imgs;
	private int currentItem;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.load);
		initView();
	}

	/**
	 * 初始化界面
	 */
	private void initView() {
	
		pointLayout = (LinearLayout) findViewById(R.id.pointLayout);
	
		scrollLayout = (MyScrollLayout) findViewById(R.id.scrollLayout);

		count = scrollLayout.getChildCount();
		imgs = new ImageView[count];
		for (int i = 0; i < count; i++) {
			imgs[i] = (ImageView) pointLayout.getChildAt(i);
			imgs[i].setEnabled(true);
			imgs[i].setTag(i);
		}
		currentItem = 0;
		imgs[currentItem].setEnabled(false);
		scrollLayout.setOnViewChangeLintener(this);

	}

	@Override
	public void onViewChange(int postion) {
		setCurrentPoint(postion);
	}

	private void setCurrentPoint(int postion) {
		if (postion < 0 || postion > count - 1 || currentItem == postion) {
			return;
		}

		imgs[currentItem].setEnabled(true);
		imgs[postion].setEnabled(false);
		currentItem = postion;

	}

}