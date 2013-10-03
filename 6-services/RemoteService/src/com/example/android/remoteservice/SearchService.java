package com.example.android.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class SearchService extends Service {

	private static final String TAG = "MainActivity";

	@Override
	public void onCreate() {
		Log.i(TAG, "onCreate");
		super.onCreate();
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.i(TAG, "onBind");

		return binder;
	}

	@Override
	public void onDestroy() {
		Log.i(TAG, "onDestroy");

		super.onDestroy();
	}

	private RemoteServiceInterface.Stub binder = new RemoteServiceInterface.Stub() {

		@Override
		public String search(String query) throws RemoteException {
			Log.v(TAG, "search() called for " + query);

			return "Your query is " + query + " at "
					+ System.currentTimeMillis();
		}
	};

}
