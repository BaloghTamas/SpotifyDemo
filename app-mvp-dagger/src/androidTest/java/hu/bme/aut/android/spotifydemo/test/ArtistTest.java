package hu.bme.aut.android.spotifydemo.test;

import android.content.Intent;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import hu.bme.aut.android.spotifydemo.ui.artists.ArtistsActivity;
import hu.bme.aut.android.spotifydemo.ui.main.MainActivity;
import hu.bme.aut.android.spotifydemo.utils.ElapsedTimeIdlingResource;
import hu.bme.aut.android.spotifydemo.utils.EspressoTest;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static hu.bme.aut.android.spotifydemo.utils.AndroidTestUtils.setTestInjector;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ArtistTest extends EspressoTest<ArtistsActivity> {

	public static final String ARTIST = "AC/DC";

	public ArtistTest() {
		super(ArtistsActivity.class);
	}

	@Before
	public void setUp() throws Exception {
		setTestInjector();
		Intent intentWithArtist = new Intent();
		intentWithArtist.putExtra(MainActivity.KEY_ARTIST, ARTIST);
		activityRule.launchActivity(intentWithArtist);
	}

	@Test
	public void testSearch() {
		onView(withId(hu.bme.aut.android.spotifydemo.R.id.etArtist)).check(matches(withText(ARTIST)));

		ElapsedTimeIdlingResource.waitFor(2000, new ElapsedTimeIdlingResource.Listener() {
			@Override
			public void inIdle() {
				onView(allOf(withId(hu.bme.aut.android.spotifydemo.R.id.tvName), withText(ARTIST))).check(matches(isDisplayed()));
			}
		});
	}


}