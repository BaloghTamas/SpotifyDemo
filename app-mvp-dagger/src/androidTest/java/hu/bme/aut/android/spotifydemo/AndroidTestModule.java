package hu.bme.aut.android.spotifydemo;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.android.spotifydemo.di.Network;
import hu.bme.aut.android.spotifydemo.ui.UIModule;
import hu.bme.aut.android.spotifydemo.ui.artists.ArtistsPresenter;
import hu.bme.aut.android.spotifydemo.ui.main.MainPresenter;

@Module
public class AndroidTestModule {

	private final UIModule UIModule;

	public AndroidTestModule(Context context) {

		this.UIModule = new UIModule(context);
	}

	@Provides
	public Context provideContext() {
		return UIModule.provideContext();
	}

	@Provides
	@Singleton
	public MainPresenter provideMainPresenter() {
		return UIModule.provideMainPresenter();
	}

	@Provides
	@Singleton
	public ArtistsPresenter provideArtistsPresenter() {
		return UIModule.provideArtistsPresenter();
	}

	@Provides
	@Singleton
	@Network
	public Executor provideNetworkExecutor() {
		return UIModule.provideNetworkExecutor();
	}

}
