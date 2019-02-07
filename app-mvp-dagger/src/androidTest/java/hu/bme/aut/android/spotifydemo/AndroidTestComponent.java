package hu.bme.aut.android.spotifydemo;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.android.spotifydemo.mock.MockNetworkModule;

@Singleton
@Component(modules = {MockNetworkModule.class, AndroidTestModule.class})
public interface AndroidTestComponent extends SpotifyDemoApplicationComponent {
}
