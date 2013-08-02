package com.symantec.logclient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.symantec.logcommon.LogManager;

public class MainActivity extends Activity {
	private EditText tag, message;
	private LogManager logManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		logManager = new LogManager(this);

		setContentView(R.layout.activity_main);

		tag = (EditText) findViewById(R.id.tag);
		message = (EditText) findViewById(R.id.message);
	}

	public void onClick(View v) {
		logManager.log(Log.DEBUG, tag.getText().toString(), message.getText()
				.toString());
	}
}
