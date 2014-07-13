package com.bslee.ui.widget;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bslee.R;
import com.bslee.ui.DrawerLayoutActivity;

public class ViewWidgetFragment extends Fragment {

	private ListView listView;
	private FragmentActivity activity;
	public ArrayList<String> data = new ArrayList<String>();
	public ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		data.add("SwipeRefreshLayout使用ok");
		data.add("SlidingPaneLayout使用ok");
        data.add("ActionBar下拉导航ok");
        data.add("ActionBar + ActionProvider + PopupMenu使用ok");
        data.add("自定义actionbar使用ok");
        data.add("自定义固定滚动视图ok");
        data.add("自定义固定页卡ok");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		activity = getActivity();
		View rootView = inflater.inflate(R.layout.fragment_page, container,
				false);

		listView = (ListView) rootView.findViewById(R.id.list);
		adapter = new ArrayAdapter<String>(activity,
				android.R.layout.simple_list_item_1, data);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				switch (arg2) {
				case 0:
					startActivity(new Intent(getActivity(),
							ViewWidgetSwipeRefreshLayoutFragmentActivity.class));
					break;
				case 1:
					startActivity(new Intent(getActivity(),
							SlideLayoitActivity.class));
					break;
				case 2:
					startActivity(new Intent(getActivity(),
							ActionBarListNavActivity.class));
					break;
				case 3:
					startActivity(new Intent(getActivity(),
							ActionBarListNavActivity.class));
					break;
				case 4:
					startActivity(new Intent(getActivity(),
							CustomActionBarActivity.class));
					break;
				case 5:
					startActivity(new Intent(getActivity(),
							LoadPageActivity.class));
					break;
				case 6:
					startActivity(new Intent(getActivity(),
							MyPageTabActivity.class));
					break;
					
				default:
					break;
				}
			}
		});
		return rootView;
	}

}