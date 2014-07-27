package com.bslee.ui;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;

import com.bslee.R;
import com.bslee.ui.adapter.MyFragmentPagerAdapter;
import com.bslee.ui.widget.FirstFragment;
import com.bslee.widget.PagerSlidingTabStrip;

public class MainPageFragment extends Fragment {

	/**
	 * PagerSlidingTabStrip的实例
	 */
	private PagerSlidingTabStrip tabs;
	private DisplayMetrics dm;
	ViewPager pager;
	private final String[] titles = { "广场", "吃货", "小摊", "设置" };
	private List<Fragment> list = new ArrayList<Fragment>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// 这里不要使用container,会出现已经存在View
		View view = inflater.inflate(R.layout.activity_main, null);
		setOverflowShowingAlways();

		list.add(new MsgFragment());
		list.add(new ContentFragment());
		list.add(new EatFragment());
		list.add(new SetFragment());

		dm = getResources().getDisplayMetrics();
		pager = (ViewPager) view.findViewById(R.id.pager);
		tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);

		// 技术点:这里必须使用子碎片管理器,否则会出现问题
		pager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(),
				list, titles));
		tabs.setViewPager(pager);
		setTabsValue();
		return view;
	}

	/**
	 * 对PagerSlidingTabStrip的各项属性进行赋值。
	 */
	private void setTabsValue() {

		// 设置Tab是自动填充满屏幕的
		tabs.setShouldExpand(true);
		// 设置Tab的分割线是透明的
		tabs.setDividerColor(Color.TRANSPARENT);
		// 设置Tab底部线的高度
		tabs.setUnderlineHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 1, dm));
		// 设置Tab Indicator的高度
		tabs.setIndicatorHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, dm));
		// 设置Tab标题文字的大小
		tabs.setTextSize((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_SP, 16, dm));
		// 设置Tab Indicator的颜色
		tabs.setIndicatorColor(Color.parseColor("#45c01a"));
		// 设置选中Tab文字的颜色 (这是我自定义的一个方法)
		tabs.setSelectedTextColor(Color.parseColor("#45c01a"));
		// 取消点击Tab时的背景色
		tabs.setTabBackground(0);
	}

	private void setOverflowShowingAlways() {
		try {
			ViewConfiguration config = ViewConfiguration.get(getActivity());
			Field menuKeyField = ViewConfiguration.class
					.getDeclaredField("sHasPermanentMenuKey");
			menuKeyField.setAccessible(true);
			menuKeyField.setBoolean(config, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}