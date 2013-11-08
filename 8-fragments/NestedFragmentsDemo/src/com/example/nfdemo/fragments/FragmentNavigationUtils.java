package com.example.nfdemo.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentNavigationUtils {

	public static void navigate(FragmentActivity activity, Fragment fragment,
			boolean addToBackStack) {
		final FragmentManager fragmentManager = activity
				.getSupportFragmentManager();

		final FragmentTransaction transaction = fragmentManager
				.beginTransaction();
		transaction.replace(android.R.id.content, fragment);

		if (addToBackStack) {
			transaction.addToBackStack(null);
		}

		transaction.commit();
	}

	public static void navigate(FragmentActivity activity, Fragment fragment) {
		navigate(activity, fragment, false);
	}
}
