package com.symantec.fib;

public class FibLib {

	// Java version
	public static long fibJ(long n) {
//		if(n>30) {
//			throw new IllegalArgumentException("Can't run for n>30");
//		}
		if(n==0) return 0;
		if(n==1) return 1;
		return fibJ(n-1) + fibJ(n-2);
	}
	
	// Native version
	static {
		System.loadLibrary("Fib");
	}
	public static native long fibN(long n);
	
	public static native void log(int priority, String tag, String message);
}
