package hu.bme.aut.android.spotifydemo;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.android.spotifydemo.interactor.InteractorModule;
import hu.bme.aut.android.spotifydemo.mock.MockNetworkModule;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class})
public interface TestComponent extends SpotifyDemoApplicationComponent {
}
