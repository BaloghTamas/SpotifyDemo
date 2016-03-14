package hu.bme.aut.android.spotifydemo.interactor.artists.event;

import java.util.List;

import hu.bme.aut.android.spotifydemo.model.Item;

public class GetArtistsEvent {
	private int code;
	private List<Item> artists;
	private Throwable throwable;

	//<editor-fold desc="Constructors|Getters|Setters">

	public GetArtistsEvent() {
	}

	public GetArtistsEvent(int code, List<Item> artists, Throwable throwable) {
		this.code = code;
		this.artists = artists;
		this.throwable = throwable;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<Item> getArtists() {
		return artists;
	}

	public void setArtists(List<Item> artists) {
		this.artists = artists;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	//</editor-fold>
}
