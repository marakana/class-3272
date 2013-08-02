package com.symantec.logservice;

import android.os.RemoteException;
import android.util.Log;

import com.symantec.logcommon.ILogService;

public class ILogServiceImpl extends ILogService.Stub {

	@Override
	public void log(int priority, String tag, String message)
			throws RemoteException {
		Log.d(tag, message);
	}

}
