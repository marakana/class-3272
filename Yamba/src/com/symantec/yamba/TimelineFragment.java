package com.symantec.yamba;

import android.app.ListFragment;
import android.os.Bundle;

public class TimelineFragment extends ListFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getActivity().getContentResolver().query(StatusContract.CONTENT_URI,
				null, null, null, null);
	}
}
