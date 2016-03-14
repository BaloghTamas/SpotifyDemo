package hu.bme.aut.android.spotifydemo.mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.android.spotifydemo.model.Artists;
import hu.bme.aut.android.spotifydemo.model.ArtistsResult;
import hu.bme.aut.android.spotifydemo.model.Image;
import hu.bme.aut.android.spotifydemo.model.Item;
import hu.bme.aut.android.spotifydemo.network.ArtistsApi;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class MockArtistApi implements ArtistsApi {
	@Override
	public Call<ArtistsResult> getArtists(@Query("query") String artist, @Query("type") String type, @Query("offset") int offset, @Query("limit") int limit) {
		final ArtistsResult artistsResult = new ArtistsResult();
		Artists artists = new Artists();

		List<Item> items = new ArrayList<Item>();

		Item item = new Item();
		item.setName("AC/DC");
		item.setPopularity(99);

		List<Image> images = new ArrayList<Image>();
		Image image = new Image();
		image.setUrl("https://i.scdn.co/image/a16c5d95ede008ec905d6ca6d1b5abbf39ad4566");
		image.setWidth(1000);
		image.setHeight(1500);
		images.add(image);

		item.setImages(images);
		items.add(item);

		artists.setItems(items);
		artistsResult.setArtists(artists);

		Call<ArtistsResult> call = new Call<ArtistsResult>() {
			@Override
			public Response<ArtistsResult> execute() throws IOException {
				return Response.success(artistsResult);
			}

			@Override
			public void enqueue(Callback<ArtistsResult> callback) {

			}

			@Override
			public boolean isExecuted() {
				return false;
			}

			@Override
			public void cancel() {

			}

			@Override
			public boolean isCanceled() {
				return false;
			}

			@Override
			public Call<ArtistsResult> clone() {
				return null;
			}

			@Override
			public Request request() {
				return null;
			}
		};

		return call;
	}


}
