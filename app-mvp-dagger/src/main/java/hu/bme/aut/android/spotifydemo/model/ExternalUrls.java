package hu.bme.aut.android.spotifydemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExternalUrls {

	@SerializedName("spotify")
	@Expose
	private String spotify;

	/**
	 * @return The spotify
	 */
	public String getSpotify() {
		return spotify;
	}

	/**
	 * @param spotify The spotify
	 */
	public void setSpotify(String spotify) {
		this.spotify = spotify;
	}
}