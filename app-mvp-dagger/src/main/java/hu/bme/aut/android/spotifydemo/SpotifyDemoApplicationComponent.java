package hu.bme.aut.android.spotifydemo;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.android.spotifydemo.interactor.artists.ArtistsInteractor;
import hu.bme.aut.android.spotifydemo.network.NetworkModule;
import hu.bme.aut.android.spotifydemo.ui.UIModule;
import hu.bme.aut.android.spotifydemo.ui.artists.ArtistsFragment;
import hu.bme.aut.android.spotifydemo.ui.artists.ArtistsPresenter;
import hu.bme.aut.android.spotifydemo.ui.main.MainActivity;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface SpotifyDemoApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(ArtistsFragment artistsFragment);

    void inject(ArtistsInteractor artistsInteractor);

    void inject(ArtistsPresenter artistsPresenter);
}
