package hu.bme.aut.android.spotifydemo.ui.artists;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import hu.bme.aut.android.spotifydemo.interactor.artists.ArtistsInteractor;
import hu.bme.aut.android.spotifydemo.interactor.artists.event.GetArtistsEvent;
import hu.bme.aut.android.spotifydemo.model.Item;
import hu.bme.aut.android.spotifydemo.ui.Presenter;

public class ArtistsPresenter extends Presenter<ArtistsScreen> {

	private static ArtistsPresenter instance = null;
	private Executor networkExecutor;
	private ArtistsInteractor artistsInteractor;
	private List<Item> prevResult = null;

	private ArtistsPresenter() {
		networkExecutor = Executors.newFixedThreadPool(1);
		artistsInteractor = new ArtistsInteractor();
	}

	public static ArtistsPresenter getInstance() {
		if (instance == null) {
			instance = new ArtistsPresenter();
		}
		return instance;
	}

	@Override
	public void attachScreen(ArtistsScreen screen) {
		super.attachScreen(screen);
		EventBus.getDefault().register(this);
	}

	@Override
	public void detachScreen() {
		EventBus.getDefault().unregister(this);
		super.detachScreen();
	}

	public void refreshArtists(final String artistQuery) {
		networkExecutor.execute(new Runnable() {
			@Override
			public void run() {
				artistsInteractor.getArtists(artistQuery);
			}
		});
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEventMainThread(final GetArtistsEvent event) {
		if (event.getThrowable() != null) {
			event.getThrowable().printStackTrace();
			if (screen != null) {
				screen.showNetworkError(event.getThrowable().getMessage());
			}
		} else {
			if (screen != null) {
				prevResult = event.getArtists();
				screen.showArtists(event.getArtists());
			}
		}
	}


	public List<Item> getPrevResult() {
		return prevResult;
	}

}
