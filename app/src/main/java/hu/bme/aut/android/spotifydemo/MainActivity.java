package hu.bme.aut.android.spotifydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

	public static final String KEY_ARTIST = "KEY_ARTIST";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText etArtist = (EditText) findViewById(R.id.etArtist);

		Button btnShowSongs = (Button) findViewById(R.id.btnShowArtists);
		btnShowSongs.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ArtistsActivity.class);
				intent.putExtra(KEY_ARTIST, etArtist.getText().toString());
				startActivity(intent);
			}
		});
	}
}
