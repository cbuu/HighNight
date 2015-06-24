package com.cbuu.highnight.fragment;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.cbuu.highnight.MainActivity;
import com.cbuu.highnight.R;
import com.cbuu.highnight.SingleChatActivity;
import com.cbuu.highnight.adapter.MyPagerAdapter;
import com.cbuu.highnight.base.MyFragment;
import com.cbuu.highnight.common.Weibo;
import com.cbuu.highnight.common.WeiboFragment;
import com.cbuu.highnight.dialog.PublishDialog;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class SingleFragment extends MyFragment {

	
	private MyPagerAdapter adapter;

	private ViewPager pager;
	
	private List<Weibo> weibos;
	
	private List<Fragment> fragments;
	
	public SingleFragment(String tabName) {
		super(tabName);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_single, null);

		pager = (ViewPager)view.findViewById(R.id.viewpager_single);
		fragments = new ArrayList<Fragment>();
		weibos = new ArrayList<Weibo>();
		
		
		//TODO update the weibos
		addData();
		
		adapter = new MyPagerAdapter(getFragmentManager(), fragments);
		
		pager.setAdapter(adapter);	

		return view;
	}
	
	private void addData(){
		
		Weibo weibo = new Weibo();
		weibo.setShitNum(100);
		weibo.setStarNum(200);
		weibo.setText("我日你");
		weibo.setTime(System.currentTimeMillis());
		weibo.setId(1);
		
		weibos.add(weibo);
		weibos.add(weibo);
		weibos.add(weibo);
		weibos.add(weibo);
		
		fragments.add(new WeiboFragment(weibos.get(0),1,weibos.size()));

		fragments.add(new WeiboFragment(weibos.get(1),2,weibos.size()));

		fragments.add(new WeiboFragment(weibos.get(2),3,weibos.size()));

		fragments.add(new WeiboFragment(weibos.get(3),4,weibos.size()));
	}
}
