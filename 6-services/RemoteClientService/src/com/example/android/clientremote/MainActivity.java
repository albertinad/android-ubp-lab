package com.example.android.clientremote;

import com.example.android.remoteservice.RemoteServiceInterface;
import com.example.android.searchlibrary.SearchService;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public class MainActivity extends Activity {

	private Button btnService;
	private RemoteServiceInterface serviceInterface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.btnService = (Button) findViewById(R.id.btn_service);
		this.btnService.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				try {
					if (serviceInterface != null) {
						final String result = serviceInterface.search("hi!");

						Toast.makeText(getApplicationContext(), result,
								Toast.LENGTH_SHORT).show();
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}

			}

		});

		connectService();
	}

	@Override
	protected void onDestroy() {
		disconnectService();

		super.onDestroy();
	}

	private void connectService() {
		final Intent intent = new Intent(SearchService.SEARCH_SERVICE);
		bindService(intent, connector, Context.BIND_AUTO_CREATE);
	}

	private void disconnectService() {
		if (serviceInterface != null) {
			unbindService(connector);
		}
	}

	private ServiceConnection connector = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			serviceInterface = RemoteServiceInterface.Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			serviceInterface = null;
		}

	};
}
