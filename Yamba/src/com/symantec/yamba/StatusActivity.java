package com.symantec.yamba;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.marakana.android.yamba.clientlib.YambaClient;
import com.marakana.android.yamba.clientlib.YambaClientException;

public class StatusActivity extends Activity implements OnClickListener {
	private static final String TAG = "StatusActivity";
	private Button buttonTweet;
	private EditText editStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        
        buttonTweet = (Button) findViewById(R.id.button_tweet);
        editStatus = (EditText) findViewById(R.id.edit_status);
        
        buttonTweet.setOnClickListener( this );
    }

	@Override
	public void onClick(View v) {
		String status = editStatus.getText().toString();
		
		YambaClient yamba = new YambaClient("student","password");
		try {
			yamba.postStatus(status);
		} catch (YambaClientException e) {
			Log.e(TAG, "Failed to post");
			e.printStackTrace();
		}
		
		Log.d(TAG, "onClicked with status: "+status);
	}


}
