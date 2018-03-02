package hu.bme.aut.android.spotifydemo.mock;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.android.spotifydemo.network.ArtistsApi;
import hu.bme.aut.android.spotifydemo.network.TokenApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {

	@Provides
	@Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

	}

	@Provides
	@Singleton
    public ArtistsApi provideArtistsApi(Retrofit.Builder retrofitBuilder) {
        return new MockArtistApi();
	}


    @Provides
    @Singleton
    public TokenApi provideTokenApi(Retrofit.Builder retrofitBuilder) {
        return new MockTokenApi();
    }

}
