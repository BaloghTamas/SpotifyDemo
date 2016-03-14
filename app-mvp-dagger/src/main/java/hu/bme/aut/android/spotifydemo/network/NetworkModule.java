package hu.bme.aut.android.spotifydemo.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
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
		return retrofit.create(ArtistsApi.class);
	}
}
