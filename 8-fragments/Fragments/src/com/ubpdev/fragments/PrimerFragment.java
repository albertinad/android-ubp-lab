package com.ubpdev.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PrimerFragment extends Fragment {

	private TextView txtInfo;

	public static PrimerFragment newInstance(String info) {
		final PrimerFragment fragment = new PrimerFragment();
		final Bundle arguments = new Bundle();

		arguments.putString("info", info.toUpperCase());
		fragment.setArguments(arguments);

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.primer_fragment, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		final String info = getArguments().getString("info");

		txtInfo = (TextView) view.findViewById(R.id.txtv_title_1);
		txtInfo.setText(info);
	}

}
