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
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

	}

	@Provides
	@Singleton
    public ArtistsApi provideArtistsApi(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(NetworkConfig.ENDPOINT_ADDRESS).build().create(ArtistsApi.class);
    }


    @Provides
    @Singleton
    public TokenApi provideTokenApi(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(NetworkConfig.TOKEN_ENDPOINT_ADDRESS).build().create(TokenApi.class);
    }

}
