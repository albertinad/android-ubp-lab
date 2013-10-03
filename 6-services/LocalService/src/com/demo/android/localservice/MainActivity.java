package com.demo.android.localservice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnCounterService;
	private Button btnCounterIntentService;

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.btnCounterIntentService = (Button) findViewById(R.id.btn_counter_intent_service);
		this.btnCounterService = (Button) findViewById(R.id.btn_counter_service);

		this.btnCounterService.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startCounterService();
			}

		});

		this.btnCounterIntentService.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startCounterIntentService();
			}

		});
	}

	private void startCounterService() {
		final Intent intent = new Intent(this, LocalCounterService.class);
		intent.putExtra("counter-value", 150);

		startService(intent);
	}

	private void startCounterIntentService() {
		final Intent intent = new Intent(this, LocalCounterIntentService.class);
		intent.putExtra("counter-value", 150);

		startService(intent);
	}

	@Override
	protected void onDestroy() {
		final Intent intent = new Intent(this, LocalCounterService.class);
		final boolean isStopped = stopService(intent);

		Log.d(TAG, "Service stopped " + isStopped);

		super.onDestroy();
	}
}
