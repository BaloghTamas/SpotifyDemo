package hu.bme.aut.android.spotifydemo.interactor.artists;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import hu.bme.aut.android.spotifydemo.SpotifyDemoApplication;
import hu.bme.aut.android.spotifydemo.interactor.artists.event.GetArtistsEvent;
import hu.bme.aut.android.spotifydemo.model.ArtistsResult;
import hu.bme.aut.android.spotifydemo.network.ArtistsApi;
import retrofit2.Call;
import retrofit2.Response;

public class ArtistsInteractor {

	@Inject
	ArtistsApi artistsApi;

	public ArtistsInteractor() {
		SpotifyDemoApplication.injector.inject(this);
	}

	public void getArtists(String artistQuery) {
		Call<ArtistsResult> artistsQueryCall = artistsApi.getArtists(artistQuery, "artist", 0, 3);
		GetArtistsEvent event = new GetArtistsEvent();
		try {
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
