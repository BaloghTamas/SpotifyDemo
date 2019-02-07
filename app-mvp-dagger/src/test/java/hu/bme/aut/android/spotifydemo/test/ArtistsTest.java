package hu.bme.aut.android.spotifydemo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.android.spotifydemo.DaggerTestComponent;
import hu.bme.aut.android.spotifydemo.ui.artists.ArtistsPresenter;
import hu.bme.aut.android.spotifydemo.ui.artists.ArtistsScreen;

import static hu.bme.aut.android.spotifydemo.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class ArtistsTest {
    @Inject
    ArtistsPresenter artistsPresenter;
    private ArtistsScreen artistsScreen;

    @Before
    public void setup() {
        DaggerTestComponent injector = setTestInjector();
        injector.inject(this);
        artistsScreen = mock(ArtistsScreen.class);
        artistsPresenter.attachScreen(artistsScreen);
    }

    @Test
    public void testArtists() {
        String query = "AC/DC";
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