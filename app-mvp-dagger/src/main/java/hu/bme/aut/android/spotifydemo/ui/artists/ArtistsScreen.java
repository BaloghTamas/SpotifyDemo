package hu.bme.aut.android.spotifydemo.ui.artists;

import java.util.List;

import hu.bme.aut.android.spotifydemo.model.Item;

public interface ArtistsScreen {
	void showArtists(List<Item> artists);

	void showNetworkError(String errorMsg);
}
