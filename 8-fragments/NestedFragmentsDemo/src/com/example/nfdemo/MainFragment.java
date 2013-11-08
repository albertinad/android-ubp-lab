package com.example.nfdemo;

import com.example.nfdemo.fragments.FragmentNavigationUtils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {

	public static MainFragment newInstance() {
		return new MainFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.main_fragment, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		final Button btnShow = (Button) view
				.findViewById(R.id.btnShowViewPager);

		btnShow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				FragmentNavigationUtils.navigate(getActivity(),
						PagerFragment.newInstance());
			}
		});
	}
}
