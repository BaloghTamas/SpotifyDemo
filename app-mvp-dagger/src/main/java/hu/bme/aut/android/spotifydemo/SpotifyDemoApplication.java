package hu.bme.aut.android.spotifydemo;

import android.app.Application;

import hu.bme.aut.android.spotifydemo.ui.UIModule;

public class SpotifyDemoApplication extends Application {

	public static SpotifyDemoApplicationComponent injector;

	@Override
	public void onCreate() {
		super.onCreate();

		injector =
				DaggerSpotifyDemoApplicationComponent.builder().
						uIModule(
								new UIModule(this)
						).build();
	}
}
