package com.demo.android.downloadservice;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;

public class DownloadIntentService extends IntentService {

	private NotificationManager notificationManager;
	private Builder builder;

	private static final String SERVICE_NAME = DownloadIntentService.class
			.getName();

	public DownloadIntentService() {
		super(SERVICE_NAME);
	}

	@Override
	public void onCreate() {
		super.onCreate();

		this.notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		this.builder = new NotificationCompat.Builder(this);

		builder.setContentTitle("Download Service")
				.setContentText("Download in progress")
				.setSmallIcon(R.drawable.ic_launcher);

	}

	@Override
	protected void onHandleIntent(Intent intent) {
		final DownloadOperation downloadRunnable = new DownloadOperation();

		final Thread downloadThread = new Thread(downloadRunnable);

		downloadThread.start();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	private void showProgressNotification(int progress) {
		builder.setProgress(100, progress, false);

		notificationManager.notify(123, builder.build());
	}

	private void showDoneNotification() {
		builder.setContentText("Download complete").setProgress(0, 0, false);

		notificationManager.notify(123, builder.build());
	}

	class DownloadOperation implements Runnable {

		@Override
		public void run() {

			for (int increment = 0; increment <= 100; increment += 10) {
				showProgressNotification(increment);

				SystemClock.sleep(700);
			}

			showDoneNotification();
		}

	}

}
