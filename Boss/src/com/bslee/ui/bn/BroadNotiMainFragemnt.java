package com.bslee.ui.bn;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.bslee.R;
import com.bslee.ui.fragment.DialogFragmentActivity;
import com.bslee.ui.fragment.FragmentPagerAdapterActivity;
import com.bslee.ui.fragment.FragmentTabHostActivity;
import com.bslee.ui.fragment.ListFragmentActivity;

public class BroadNotiMainFragemnt  extends Fragment {

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
		data.add("Broadcast使用");
		data.add("Notification使用");
	
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
			
			default:
				break;
			}	
			}
		} );
		return rootView;
	}

}

