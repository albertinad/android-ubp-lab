package com.dev.multifragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class BookListActivity extends FragmentActivity implements
		BookListFragment.Callbacks {

	private boolean isTwoPaneMode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_list);

		if (findViewById(R.id.book_detail_container) != null) {
			// The detail container view will be present only in the
			// large-screen layouts (res/values-large and
			// res/values-sw600dp). If this view is present, then the
			// activity should be in two-pane mode.
			isTwoPaneMode = true;

			// In two-pane mode, list items should be given the
			// 'activated' state when touched.
			final BookListFragment booksFragment = (BookListFragment) getSupportFragmentManager()
					.findFragmentById(R.id.book_list);

			booksFragment.setActivateOnItemClick(true);
		}
	}

	@Override
	public void onItemSelected(String id) {
		if (isTwoPaneMode) {
			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			showDetailFragment(id);
		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			showDetailActivity(id);
		}
	}

	private void showDetailFragment(String id) {
		final BookDetailFragment fragment = new BookDetailFragment();
		final Bundle arguments = new Bundle();

		arguments.putString(BookDetailFragment.ARG_ITEM_ID, id);

		fragment.setArguments(arguments);

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.book_detail_container, fragment).commit();
	}

	private void showDetailActivity(String id) {
		final Intent detailIntent = new Intent(this, BookDetailActivity.class);
		detailIntent.putExtra(BookDetailFragment.ARG_ITEM_ID, id);
		startActivity(detailIntent);
	}
}
