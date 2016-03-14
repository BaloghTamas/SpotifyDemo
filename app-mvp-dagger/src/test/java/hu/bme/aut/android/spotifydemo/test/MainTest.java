package hu.bme.aut.android.spotifydemo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import hu.bme.aut.android.spotifydemo.BuildConfig;
import hu.bme.aut.android.spotifydemo.ui.main.MainPresenter;
import hu.bme.aut.android.spotifydemo.ui.main.MainScreen;
import hu.bme.aut.android.spotifydemo.utils.RobolectricDaggerTestRunner;

import static hu.bme.aut.android.spotifydemo.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainTest {

	private MainPresenter mainPresenter;
	private MainScreen mainScreen;

	@Before
	public void setup() throws Exception {
		setTestInjector();
		mainScreen = mock(MainScreen.class);
		mainPresenter = new MainPresenter();
		mainPresenter.attachScreen(mainScreen);
	}

	@Test
	public void testSearch() {
		String artist = "AC/DC";
		mainPresenter.showArtistsSearchList(artist);
		verify(mainScreen).showArtists(artist);
	}


	@After
	public void tearDown() {
		mainPresenter.detachScreen();
	}

}