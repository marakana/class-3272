package com.symantec.logcommon;

import com.symantec.logcommon.LogMessage;

interface ILogService {
	void log( int priority, String tag, String message );
	void logIt( in LogMessage msg );
}