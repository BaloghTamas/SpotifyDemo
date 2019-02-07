package hu.bme.aut.android.spotifydemo.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import hu.bme.aut.android.spotifydemo.R;
import hu.bme.aut.android.spotifydemo.SpotifyDemoApplication;
import hu.bme.aut.android.spotifydemo.ui.artists.ArtistsActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {

	public static final String KEY_ARTIST = "KEY_ARTIST";
	@Inject
	MainPresenter mainPresenter;
	private EditText etArtist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SpotifyDemoApplication.injector.inject(this);

        etArtist = findViewById(R.id.etArtist);

        Button btnShowSongs = findViewById(R.id.btnShowArtists);
		btnShowSongs.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mainPresenter.showArtistsSearchList(etArtist.getText().toString());
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		mainPresenter.attachScreen(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		mainPresenter.detachScreen();
	}

	@Override
	public void showArtists(String artistSearchTerm) {
		Intent intent = new Intent(MainActivity.this, ArtistsActivity.class);
		intent.putExtra(KEY_ARTIST, artistSearchTerm);
		startActivity(intent);
	}
}
