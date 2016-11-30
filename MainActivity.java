package com.tvmining.yiyuangou;


import java.util.ArrayList;

import com.tvmining.yiyuangou.fragment.AboutFragment;
import com.tvmining.yiyuangou.fragment.FriendsFragment;
import com.tvmining.yiyuangou.fragment.MainTabFragment;
import com.tvmining.yiyuangou.fragment.MessageFragment;
import com.tvmining.yiyuangou.fragment.UseBalanceFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class MainActivity extends FragmentActivity {
	
	private Class[] fragments = new Class[] { MessageFragment.class,
			FriendsFragment.class, MainTabFragment.class,
			UseBalanceFragment.class, AboutFragment.class };
	private FragmentTabHost fragmentTabHost;
	private int position = 4;
	private String[] tabNames;
	private ArrayList<ImageView> tabs = new ArrayList<ImageView>();
	private ArrayList<TextView> titles = new ArrayList<TextView>();
	private int[] imageResources = { R.drawable.ic_launcher,
			R.drawable.ic_launcher,
			R.drawable.ic_launcher,
			R.drawable.ic_launcher,
			R.drawable.ic_launcher,};
			
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgeet();
    }
    
    
	private String whichTab = "4";

	private void initWidgeet() {
		fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		fragmentTabHost.setup(this, getSupportFragmentManager(),
				R.id.fragment_content);

		tabNames = getResources().getStringArray(R.array.main_tab_names);
		for (int i = 0; i < fragments.length; i++) {
			TabSpec tabSpec = fragmentTabHost.newTabSpec(String.valueOf(i))
					.setIndicator(getTabItemView(i));
			fragmentTabHost.addTab(tabSpec, fragments[i], null);
		}
		
		fragmentTabHost.setCurrentTab(4);
		
		fragmentTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			public void onTabChanged(String arg0) {
				whichTab = arg0;
				int which = Integer.parseInt(arg0);
				position = which;
				fragmentTabHost.setCurrentTab(position);
			}
		});
	}
	
	
	//git test again
	//and git again test
	private View getTabItemView(int index) {
		View view = View.inflate(this, R.layout.maintab_item, null);
		ImageView ivIcon = (ImageView) view.findViewById(R.id.iv_maintab_icon);
		TextView tvName = (TextView) view.findViewById(R.id.tv_maintab_text);

		ivIcon.setImageResource(imageResources[index]);
		tabs.add(ivIcon);
		titles.add(tvName);
		tvName.setText(tabNames[index]);
		return view;
	}
}
