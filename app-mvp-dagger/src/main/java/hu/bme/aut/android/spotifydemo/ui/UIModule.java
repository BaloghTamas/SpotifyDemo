package hu.bme.aut.android.spotifydemo.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.android.spotifydemo.di.Network;
import hu.bme.aut.android.spotifydemo.ui.artists.ArtistsPresenter;
import hu.bme.aut.android.spotifydemo.ui.main.MainPresenter;

@Module
public class UIModule {
	private Context context;

	public UIModule(Context context) {
		this.context = context;
	}

	@Provides
	public Context provideContext() {
		return context;
	}

	@Provides
	@Singleton
	public MainPresenter provideMainPresenter() {
		return new MainPresenter();
	}

	@Provides
	@Singleton
	public ArtistsPresenter provideArtistsPresenter() {
		return new ArtistsPresenter();
	}

	@Provides
	@Singleton
	@Network
	public Executor provideNetworkExecutor() {
		return Executors.newFixedThreadPool(1);
	}
}
