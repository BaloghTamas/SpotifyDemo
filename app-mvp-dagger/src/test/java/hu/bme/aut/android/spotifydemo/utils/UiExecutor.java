package hu.bme.aut.android.spotifydemo.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

public class UiExecutor implements Executor {

	private Handler mHandler;

	public UiExecutor() {
		mHandler = new Handler(Looper.getMainLooper());
	}

	@Override
	public void execute(@NonNull Runnable command) {
		mHandler.post(command);
	}
}
