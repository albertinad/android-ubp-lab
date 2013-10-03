package com.demo.android.localservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;

public class LocalCounterService extends Service {

	private NotificationManager notificationManager;
	private ThreadGroup threadsGroup = new ThreadGroup("ServiceWorker");

	private static final String TAG = "LocalDownloadService";

	@Override
	public void onCreate() {
		Log.i(TAG, "onCreate");

		this.notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		displayNotificationMessage("Background Service is running");

		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(TAG, "onStartCommand - " + startId);

		final int count = intent.getIntExtra("counter-value", 10);

		new Thread(this.threadsGroup, new ServiceWorker(count),
				"BackgroundService").start();

		return START_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		Log.i(TAG, "onDestroy");

		this.threadsGroup.interrupt();
		this.notificationManager.cancelAll();

		super.onDestroy();
	}

	class ServiceWorker implements Runnable {

		private int counter;

		public ServiceWorker(int counter) {
			this.counter = counter;
		}

		public void run() {
			final String TAG2 = "ServiceWorker:"
					+ Thread.currentThread().getId();

			try {
				for (int i = 0; i < counter; i++) {
					Log.v(TAG2, "sleeping for 10 seconds. counter = " + i);
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				Log.v(TAG2, "sleep interrupted");
			}
		}
	}

	private void displayNotificationMessage(String message) {
		final PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
				new Intent(this, MainActivity.class), 0);

		final Builder builder = new NotificationCompat.Builder(this);

		builder.setContentTitle(getString(R.string.app_name))
				.setContentText(message + " " + System.currentTimeMillis())
				.setSmallIcon(R.drawable.ic_launcher)
				.setContentIntent(contentIntent);

		Notification notification = builder.build();

		notification.flags = Notification.FLAG_NO_CLEAR;

		notificationManager.notify(0, notification);
	}
}
