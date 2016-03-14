package hu.bme.aut.android.spotifydemo.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.android.spotifydemo.interactor.artists.ArtistsInteractor;

@Module
public class InteractorModule {
	@Provides
	public ArtistsInteractor provideArtistsInteractor() {
		return new ArtistsInteractor();
	}
}
