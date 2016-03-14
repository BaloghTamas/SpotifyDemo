package hu.bme.aut.android.spotifydemo.mock;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.android.spotifydemo.network.ArtistsApi;
import hu.bme.aut.android.spotifydemo.network.NetworkConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {


	@Provides
	@Singleton
	public Retrofit provideRetrofit() {
		return new Retrofit.Builder()
				.baseUrl(NetworkConfig.ENDPOINT_ADDRESS)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}

	@Provides
	@Singleton
	public ArtistsApi provideArtistsApi(Retrofit retrofit) {
		return new MockArtistApi();
	}

}
