package hu.bme.aut.android.spotifydemo.utils;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;

import hu.bme.aut.android.spotifydemo.AndroidTestComponent;
import hu.bme.aut.android.spotifydemo.AndroidTestModule;
import hu.bme.aut.android.spotifydemo.DaggerAndroidTestComponent;
import hu.bme.aut.android.spotifydemo.DaggerSpotifyDemoApplicationComponent;
import hu.bme.aut.android.spotifydemo.SpotifyDemoApplication;
import hu.bme.aut.android.spotifydemo.SpotifyDemoApplicationComponent;
import hu.bme.aut.android.spotifydemo.ui.UIModule;

public class AndroidTestUtils {

	public static void setTestInjector() {
		Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
		SpotifyDemoApplication app = (SpotifyDemoApplication) instrumentation.getTargetContext()
				.getApplicationContext();

		AndroidTestComponent androidTestComponent = DaggerAndroidTestComponent.builder().androidTestModule(new AndroidTestModule(app)).build();
		app.injector = androidTestComponent;
	}

	public static void setProdutionInjector() {
		Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
		SpotifyDemoApplication app = (SpotifyDemoApplication) instrumentation.getTargetContext()
				.getApplicationContext();

		SpotifyDemoApplicationComponent androidTestComponent = DaggerSpotifyDemoApplicationComponent.builder().uIModule(new UIModule(app)).build();
		app.injector = androidTestComponent;
	}
}
