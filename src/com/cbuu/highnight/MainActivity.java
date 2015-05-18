package com.cbuu.highnight;


import java.util.ArrayList;
import java.util.List;

import com.cbuu.highnight.adapter.MyPagerAdapter;
import com.cbuu.highnight.base.MyFragment;
import com.cbuu.highnight.fragment.GroupFragment;
import com.cbuu.highnight.fragment.SingleFragment;
import com.cbuu.highnight.utils.Logger;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Notification.Action;
import android.os.Bundle;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements ActionBar.TabListener{
	
	private List<MyFragment> fragments = null;
	
	private int curFragmentNum = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initActionBar();

		addTabs();
		
		
	}
	
	private void addTabs(){
		fragments = new ArrayList<MyFragment>();
		
		fragments.add(new GroupFragment("群聊"));
		fragments.add(new SingleFragment("私聊"));
		fragments.add(new SingleFragment("好友"));
		
		
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		
		ActionBar actionBar = getActionBar();  
        for (int i = 0; i < fragments.size(); ++i) {
        	MyFragment fragment = fragments.get(i);
            actionBar.addTab(actionBar.newTab()  
                    .setText(fragment.getTabName())  
                    .setTabListener(this));  
            transaction.add(R.id.fragment_layout,(Fragment)fragment);
            transaction.hide(fragment);
        }
        
        transaction.show(fragments.get(curFragmentNum));
        
        transaction.commit();
	}
	

	
	private void initActionBar() {
		View customActionbar = getLayoutInflater().inflate(
				R.layout.custom_bar_main, null);
		
		ActionBar.LayoutParams params =new ActionBar.LayoutParams(
				ActionBar.LayoutParams.MATCH_PARENT,
				ActionBar.LayoutParams.MATCH_PARENT,
				Gravity.CENTER);

		ActionBar actionBar = getActionBar();
		actionBar.setCustomView(customActionbar,params);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		
	}


	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		if (tab.getPosition() ==  curFragmentNum) {
			return;
		}
		
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.hide(fragments.get(curFragmentNum));
		curFragmentNum = tab.getPosition();
		transaction.show(fragments.get(curFragmentNum));
		transaction.commit();
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		
	}
}
