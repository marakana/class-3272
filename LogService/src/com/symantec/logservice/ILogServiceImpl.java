package com.symantec.logservice;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;

import com.symantec.logcommon.ILogService;
import com.symantec.logcommon.LogMessage;

public class ILogServiceImpl extends ILogService.Stub {
	private static int PREMIMUM_CUTOFF = 15;
	private Context context;

	public ILogServiceImpl(Context context) {
		super();
		this.context = context;
	}

	@Override
	public void log(int priority, String tag, String message)
			throws RemoteException {
		if (message.length() > PREMIMUM_CUTOFF)
			checkPremiumPermissions();

		Log.d(tag, message);
	}

	@Override
	public void logIt(LogMessage msg) throws RemoteException {
		if (msg.getMessage().length() > PREMIMUM_CUTOFF)
			checkPremiumPermissions();

		Log.d(msg.getTag(), msg.getMessage());
	}

	private static final String PREMIUM_SERVICE = "com.symantec.permission.LOG_SERVICE_PREMIUM";

	private void checkPremiumPermissions() {
		if (context.checkCallingOrSelfPermission(PREMIUM_SERVICE) != PackageManager.PERMISSION_GRANTED) {
			throw new SecurityException("You don't have " + PREMIUM_SERVICE);
		}
	}
}
