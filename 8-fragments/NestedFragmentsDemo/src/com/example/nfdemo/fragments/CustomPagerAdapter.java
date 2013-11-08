package com.example.nfdemo.fragments;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CustomPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> fragments;

	public CustomPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public CustomPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
		this(fm);

		this.fragments = (fragments != null) ? fragments
				: new ArrayList<Fragment>();
	}

	@Override
	public Fragment getItem(int position) {
		return this.fragments.get(position);
	}

	@Override
	public int getCount() {
		return this.fragments.size();
	}

}
