package com.symantec.logcommon;

interface ILogService {
	void log( int priority, String tag, String message );
}