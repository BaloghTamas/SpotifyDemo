package hu.bme.aut.android.spotifydemo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import hu.bme.aut.android.spotifydemo.BuildConfig;
import hu.bme.aut.android.spotifydemo.ui.artists.ArtistsPresenter;
import hu.bme.aut.android.spotifydemo.ui.artists.ArtistsScreen;
import hu.bme.aut.android.spotifydemo.utils.RobolectricDaggerTestRunner;

import static hu.bme.aut.android.spotifydemo.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ArtistsTest {

	private ArtistsPresenter artistsPresenter;
	private ArtistsScreen artistsScreen;
	private String query;

	@Before
	public void setup() throws Exception {
		setTestInjector();
		artistsScreen = mock(ArtistsScreen.class);
		artistsPresenter = new ArtistsPresenter();
		artistsPresenter.attachScreen(artistsScreen);
	}

	@Test
	public void testArtists() {
		query = "AC/DC";
		artistsPresenter.refreshArtists(query);

		ArgumentCaptor<List> artistCaptor = ArgumentCaptor.forClass(List.class);
		verify(artistsScreen).showArtists(artistCaptor.capture());
		assertTrue(artistCaptor.getValue().size() > 0);
	}


	@After
	public void tearDown() {
		artistsPresenter.detachScreen();
	}

}