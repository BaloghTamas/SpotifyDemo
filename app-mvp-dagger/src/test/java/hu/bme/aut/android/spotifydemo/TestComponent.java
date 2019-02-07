package hu.bme.aut.android.spotifydemo;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.android.spotifydemo.mock.MockNetworkModule;
import hu.bme.aut.android.spotifydemo.test.ArtistsTest;
import hu.bme.aut.android.spotifydemo.test.MainTest;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class})
public interface TestComponent extends SpotifyDemoApplicationComponent {
    void inject(MainTest mainTest);

    void inject(ArtistsTest artistsTest);
}
