package hu.bme.aut.android.spotifydemo;


import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

	public static void setTestInjector() {
		ShadowLog.stream = System.out;
		SpotifyDemoApplication application = (SpotifyDemoApplication) RuntimeEnvironment.application;
		SpotifyDemoApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
		application.injector = injector;
	}
}
