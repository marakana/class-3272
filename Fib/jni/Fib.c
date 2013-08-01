#include "com_symantec_fib_FibLib.h"

/* This is pure C implementation */
long fib(long n) {
	if (n == 0)
		return 0;
	if (n == 1)
		return 1;
	return fib(n - 1) + fib(n - 2);
}

JNIEXPORT jlong JNICALL Java_com_symantec_fib_FibLib_fibN(JNIEnv *env,
		jclass clazz, jlong n) {
	return (jlong)fib((long)n);
}
