package hu.bme.aut.android.spotifydemo.ui.main;

import javax.inject.Inject;

import hu.bme.aut.android.spotifydemo.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    public MainPresenter() {
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
