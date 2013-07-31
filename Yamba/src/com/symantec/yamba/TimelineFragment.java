package com.symantec.yamba;

import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class TimelineFragment extends ListFragment {
	private static final String[] FROM = { StatusContract.Column.USER,
			StatusContract.Column.MESSAGE, StatusContract.Column.CREATED_AT };
	private static final int[] TO = { R.id.text_user, R.id.text_message,
			R.id.text_createdAt };

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Cursor cursor = getActivity().getContentResolver().query(
				StatusContract.CONTENT_URI, null, null, null, null);

		SimpleCursorAdapter adapter = new SimpleCursorAdapter(getActivity(),
				R.layout.list_item, cursor, FROM, TO, 0);

		setListAdapter(adapter);
	}
}
