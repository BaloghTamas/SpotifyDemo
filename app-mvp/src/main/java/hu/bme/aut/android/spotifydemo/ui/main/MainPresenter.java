package hu.bme.aut.android.spotifydemo.ui.main;

import hu.bme.aut.android.spotifydemo.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {

	private static MainPresenter instance = null;

	private MainPresenter() {
	}

	public static MainPresenter getInstance() {
		if (instance == null) {
			instance = new MainPresenter();
		}
		return instance;
	}

	@Override
	public void attachScreen(MainScreen screen) {
		super.attachScreen(screen);
	}

	@Override
	public void detachScreen() {
		super.detachScreen();
	}

	public void showArtistsSearchList(
			String artistSearchTerm) {
		screen.showArtists(artistSearchTerm);
	}
}
