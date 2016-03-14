package hu.bme.aut.android.spotifydemo.utils;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;

public class ElapsedTimeIdlingResource implements IdlingResource {
	public static final long WAITING_TIME = 500;
	private final long startTime;
	private final long waitingTime;
	private ResourceCallback resourceCallback;

	public ElapsedTimeIdlingResource(long waitingTime) {
		this.startTime = System.currentTimeMillis();
		this.waitingTime = waitingTime;
	}


	public static void waitFor(long time, Listener listener) {
		IdlingResource idlingResource = new ElapsedTimeIdlingResource(WAITING_TIME);
		Espresso.registerIdlingResources(idlingResource);
		listener.inIdle();
		Espresso.unregisterIdlingResources(idlingResource);
	}


	public static void waitFor(Listener listener) {
		waitFor(WAITING_TIME, listener);
	}

	@Override
	public String getName() {
		return ElapsedTimeIdlingResource.class.getName() + ":" + waitingTime;
	}

	@Override
	public boolean isIdleNow() {
		long elapsed = System.currentTimeMillis() - startTime;
		boolean idle = (elapsed >= waitingTime);
		if (idle) {
			resourceCallback.onTransitionToIdle();
		}
		return idle;
	}

	@Override
	public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
		this.resourceCallback = resourceCallback;
	}


	public interface Listener {
		void inIdle();
	}
}