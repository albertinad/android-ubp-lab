package com.example.nfdemo;

import java.util.ArrayList;
import java.util.List;

import com.example.nfdemo.fragments.CustomPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PagerFragment extends Fragment {

	public static PagerFragment newInstance() {
		return new PagerFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.pager_fragment, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		setUpPager();
	}

	private void setUpPager() {
		final View view = getView();
		final ViewPager viewpager = (ViewPager) view.findViewById(R.id.pager);

		final List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(FirstFragment.newInstance());
		fragments.add(SecondFragment.newInstance());

		final CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(
				getChildFragmentManager(), fragments);

		viewpager.setAdapter(pagerAdapter);
		viewpager.setCurrentItem(0);
	}
}
