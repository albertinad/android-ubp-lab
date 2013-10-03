package com.demo.android.localservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

public class LocalCounterIntentService extends IntentService {

	private static final String TAG = "LocalCounterIntentService";

	private final static String className = LocalCounterIntentService.class
			.getName();

	public LocalCounterIntentService() {
		super(className);
	}

	@Override
	public void onCreate() {
		Log.i(TAG, "onCreate");
		super.onCreate();
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.i(TAG, "onHandleIntent");

		final String TAG2 = "IntentService:" + Thread.currentThread().getId();

		final int count = intent.getIntExtra("counter-value", 10);

		for (int i = 0; i < count; i++) {
			Log.v(TAG2, "sleeping for 10 seconds. counter = " + i);

			SystemClock.sleep(100);
		}
	}

	@Override
	public void onDestroy() {
		Log.i(TAG, "onDestroy");
		super.onDestroy();
	}

}
