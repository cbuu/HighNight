package com.cbuu.highnight;


import java.util.ArrayList;
import java.util.List;

import com.cbuu.highnight.adapter.MyPagerAdapter;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.Notification.Action;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
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

public class MainActivity extends FragmentActivity implements ActionBar.TabListener{
	
	private ViewPager viewPager = null;
	private MyPagerAdapter pagerAdapter = null;
	
	private List<Fragment> fragments = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initFragments();
		
		initActionBar();
		initViewPager();
		addTabs();
	}
	
	private void addTabs(){
		ActionBar actionBar = getActionBar();  
        for (int i = 0; i < pagerAdapter.getCount(); ++i) {  
            actionBar.addTab(actionBar.newTab()  
                    .setText("a")  
                    .setTabListener(this));  
        }
	}
	
	private void initFragments(){
		fragments = new ArrayList<Fragment>();
		
		fragments.add(ArrayListFragment.newInstance(0));
		fragments.add(ArrayListFragment.newInstance(1));
		fragments.add(ArrayListFragment.newInstance(2));
	}
	
	private void initViewPager(){
		viewPager = (ViewPager)findViewById(R.id.viewpager);
		pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
		
		viewPager.setAdapter(pagerAdapter);
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				final ActionBar actionBar = getActionBar();  
                actionBar.setSelectedNavigationItem(position);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
	
	
	public static class ArrayListFragment extends ListFragment {
        int mNum;

        static ArrayListFragment newInstance(int num) {
            ArrayListFragment f = new ArrayListFragment();

            Bundle args = new Bundle();
            args.putInt("num", num);
            f.setArguments(args);

            return f;
        }

        /**
         * When creating, retrieve this instance's number from its arguments.
         */
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mNum = getArguments() != null ? getArguments().getInt("num") : 1;
        }

        /**
         * The Fragment's UI is just a simple text view showing its
         * instance number.
         */
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_pager_list, container, false);
            View tv = v.findViewById(R.id.text);
            ((TextView)tv).setText("Fragment #" + mNum);
            return v;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            setListAdapter(new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, new String[]{"hehe","sdas"}));
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Log.i("FragmentList", "Item clicked: " + id);
        }
    }


	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
}
