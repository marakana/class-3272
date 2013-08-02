package com.symantec.logcommon;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

public class LogManager {
	private static final Intent LOG_SERVICE_INTENT = new Intent(
			"com.symantec.logcommon.ILogService");
	private Context context;
	private static ILogService logService;

	public LogManager(Context context) {
		this.context = context;

		context.bindService( LOG_SERVICE_INTENT,
				SERVICE_CONNECTION, Context.BIND_AUTO_CREATE);
	}
	
	private static final ServiceConnection SERVICE_CONNECTION = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			logService = ILogService.Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			logService = null;
		}
		
	};

	public void log(int priority, String tag, String message) {
		if(logService==null) return;
		
		try {
			logService.log(priority, tag, message);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
