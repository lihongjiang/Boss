package com.bslee.ui.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

//注意:FragmentPagerAdapter里面的Fragment每次都会从OnCreatView显示调用,但不是销毁.
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
	FragmentManager fragmentManager;
	private final String[] titles;
	private List<Fragment> list;

	public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list,
			String[] titles) {
		super(fm);
		fragmentManager = fm;
		this.list = list;
		this.titles = titles;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return titles[position];
	}

	@Override
	public int getCount() {
		return titles.length;
	}

	@Override
	public Fragment getItem(int position) {
		return list.get(position);
	}

}