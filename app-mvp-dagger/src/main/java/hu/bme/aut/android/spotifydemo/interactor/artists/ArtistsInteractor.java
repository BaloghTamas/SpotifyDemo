package hu.bme.aut.android.spotifydemo.interactor.artists;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import hu.bme.aut.android.spotifydemo.SpotifyDemoApplication;
import hu.bme.aut.android.spotifydemo.interactor.artists.event.GetArtistsEvent;
import hu.bme.aut.android.spotifydemo.model.ArtistsResult;
import hu.bme.aut.android.spotifydemo.model.Token;
import hu.bme.aut.android.spotifydemo.network.ArtistsApi;
import hu.bme.aut.android.spotifydemo.network.TokenApi;
import retrofit2.Call;
import retrofit2.Response;

import static hu.bme.aut.android.spotifydemo.network.NetworkConfig.AUTH_PREFIX;
import static hu.bme.aut.android.spotifydemo.network.NetworkConfig.TOKEN_AUTHORISATION;
import static hu.bme.aut.android.spotifydemo.network.NetworkConfig.TOKEN_CLIENT_CREDENTIALS;

public class ArtistsInteractor {

	ArtistsApi artistsApi;
    TokenApi tokenApi;

    @Inject
    public ArtistsInteractor(ArtistsApi artistsApi, TokenApi tokenApi) {
        this.artistsApi = artistsApi;
        this.tokenApi = tokenApi;
		SpotifyDemoApplication.injector.inject(this);
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
