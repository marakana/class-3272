package com.symantec.yamba;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class StatusActivity extends Activity implements OnClickListener {
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
		Log.d("StatusActivity", "onClicked with status: "+status);
	}


}
