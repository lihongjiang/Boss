package com.bslee.ui.widget;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.bslee.boss.R;

@SuppressLint("NewApi")
public class CustomActionBarActivity extends Activity implements
		SearchView.OnQueryTextListener {
	ListView listView;
	SearchView searchView;
	Object[] names;
	ArrayAdapter<String> adapter;
	ArrayList<String> mAllList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_actionbar_main);
		initActionbar();
		names = loadData();
		listView = (ListView) findViewById(R.id.list);
		listView.setAdapter(new ArrayAdapter<Object>(getApplicationContext(),
				android.R.layout.simple_expandable_list_item_1, names));

		listView.setTextFilterEnabled(true);
		searchView.setOnQueryTextListener(this);
		searchView.setSubmitButtonEnabled(true);//打开搜索按钮

	}

	public void initActionbar() {
		// 自定义标题栏
		getActionBar().setDisplayShowHomeEnabled(false);
		getActionBar().setDisplayShowTitleEnabled(false);
		getActionBar().setDisplayShowCustomEnabled(true);
		LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View mTitleView = mInflater.inflate(R.layout.custom_action_bar_layout,
				null);
		getActionBar().setCustomView(
				mTitleView,
				new ActionBar.LayoutParams(LayoutParams.MATCH_PARENT,
						LayoutParams.WRAP_CONTENT));
		searchView = (SearchView) mTitleView.findViewById(R.id.search_view);
	}

	public Object[] loadData() {
		mAllList.add("aa");
		mAllList.add("ddfa");
		mAllList.add("qw");
		mAllList.add("sd");
		mAllList.add("fd");
		mAllList.add("cf");
		mAllList.add("re");
		return mAllList.toArray();
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		if (TextUtils.isEmpty(newText)) {
			// Clear the text filter.
			listView.clearTextFilter();
		} else {
			// Sets the initial value for the text filter.
			listView.setFilterText(newText.toString());
		}
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		Toast.makeText(getApplicationContext(), "单击了", Toast.LENGTH_SHORT).show();
		
		// 处理提交事件
		return false;
	}
}