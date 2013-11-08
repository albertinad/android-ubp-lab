package com.dev.multifragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.multifragments.data.MockContent;

public class BookDetailFragment extends Fragment {

	public static final String ARG_ITEM_ID = "item_id";

	private TextView txtvInfo;
	private MockContent.Book book;

	public BookDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final Bundle args = getArguments();

		if (args.containsKey(ARG_ITEM_ID)) {
			book = MockContent.ITEM_MAP.get(args.getString(ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater
				.inflate(R.layout.fragment_book_detail, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		txtvInfo = (TextView) view.findViewById(R.id.book_detail);
	}

	@Override
	public void onResume() {
		super.onResume();

		if (book != null) {
			txtvInfo.setText(book.summary);
		}
	}
}
