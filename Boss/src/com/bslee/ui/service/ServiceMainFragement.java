package com.bslee.ui.service;

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

public class ServiceMainFragement  extends Fragment {

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
	data.add("单任务service使用");
	data.add("并发任务service使用");
	data.add("单任务IntentService使用");
	data.add("AIDL服务Service使用");
	data.add("Handler使用");
	data.add("HandlerThread使用");
	data.add("AsyncQueryHandler使用");
	data.add("AsyncTaskLoader使用");
	data.add("AsyncTask使用");
	data.add("DownloadManager使用");
	data.add("本地服务bindService使用");
	
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
				//startActivity(new Intent(getActivity(), DialogFragmentActivity.class));
				break;
			case 3:
				startActivity(new Intent(getActivity(), MessengerActivity.class));
				break;
			case 10:
				startActivity(new Intent(getActivity(), LocalActivity.class));
				break;
			default:
				break;
			}	
			}
		} );
		return rootView;
	}

}
