package hu.bme.aut.android.spotifydemo.interactor.artists;

import org.greenrobot.eventbus.EventBus;

import hu.bme.aut.android.spotifydemo.interactor.artists.event.GetArtistsEvent;
import hu.bme.aut.android.spotifydemo.model.ArtistsResult;
import hu.bme.aut.android.spotifydemo.model.Token;
import hu.bme.aut.android.spotifydemo.network.ArtistsApi;
import hu.bme.aut.android.spotifydemo.network.NetworkConfig;
import hu.bme.aut.android.spotifydemo.network.TokenApi;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static hu.bme.aut.android.spotifydemo.network.NetworkConfig.AUTH_PREFIX;
import static hu.bme.aut.android.spotifydemo.network.NetworkConfig.TOKEN_AUTHORISATION;
import static hu.bme.aut.android.spotifydemo.network.NetworkConfig.TOKEN_CLIENT_CREDENTIALS;
import static hu.bme.aut.android.spotifydemo.network.NetworkConfig.TOKEN_ENDPOINT_ADDRESS;

public class ArtistsInteractor {


    private final TokenApi tokenApi;
    private ArtistsApi artistsApi;

    public ArtistsInteractor() {
        // Dagger would be very useful here!
        Retrofit retrofitArtist = new Retrofit.Builder()
                .baseUrl(NetworkConfig.ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        artistsApi = retrofitArtist.create(ArtistsApi.class);


        Retrofit retrofitToken = new Retrofit.Builder()
                .baseUrl(TOKEN_ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tokenApi = retrofitToken.create(TokenApi.class);
    }

    public void getArtists(String artistQuery) {
        Call<Token> tokenQueryCAll = tokenApi.getToken(TOKEN_CLIENT_CREDENTIALS, TOKEN_AUTHORISATION);

        GetArtistsEvent event = new GetArtistsEvent();
        try {
            Response<Token> tokenResponse = tokenQueryCAll.execute();
            String authToken = AUTH_PREFIX + tokenResponse.body().getAccessToken();

            Call<ArtistsResult> artistsQueryCall = artistsApi.getArtists(authToken, artistQuery, "artist", 0, 3);

            Response<ArtistsResult> response = artistsQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setArtists(response.body().getArtists().getItems());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

}
