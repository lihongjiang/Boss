package com.bslee.ui.fragment;

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

import com.bslee.boss.R;

public class FragmentMainFragment extends Fragment {

	private ListView listView;

	private FragmentActivity activity;
	public ArrayList<String> data = new ArrayList<String>();
	public ArrayAdapter<String> adapter;

	/**
	 * 初始化一次
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		data.add("DialogFragment测试ok");
		data.add("ListFragment测试ok");
		data.add("WebViewFragment测试");
		data.add("FragmentPagerAdapter测试ok");
		data.add("FragmentStatePagerAdapter测试");
		data.add("FragmentTabHost使用ok");	
		data.add("Fragment生命周期");	
	}
	/**
	 * 创建多次View
	 */
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
				// TODO Auto-generated method stub
			switch (arg2) {
			case 0:
				startActivity(new Intent(getActivity(), DialogFragmentActivity.class));
				break;
			case 1:	
				startActivity(new Intent(getActivity(), ListFragmentActivity.class));
				break;
			case 2:
				
				break;
			case 3:
				startActivity(new Intent(getActivity(), FragmentPagerAdapterActivity.class));
				break;
			case 4:
				
				break;
			case 5:
				startActivity(new Intent(getActivity(), FragmentTabHostActivity.class));
				break;
			case 6:
				startActivity(new Intent(getActivity(), FragmentCycleActivity.class));
				break;
			default:
				break;
			}	
			}
		} );
		return rootView;
	}

}
