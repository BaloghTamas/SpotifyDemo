package hu.bme.aut.android.spotifydemo.test;

import android.content.Intent;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import hu.bme.aut.android.spotifydemo.R;
import hu.bme.aut.android.spotifydemo.ui.main.MainActivity;
import hu.bme.aut.android.spotifydemo.utils.EspressoTest;
import hu.bme.aut.android.spotifydemo.utils.EspressoUtils;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static hu.bme.aut.android.spotifydemo.utils.AndroidTestUtils.setTestInjector;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainTest extends EspressoTest<MainActivity> {

	public static final String ARTIST = "AC/DC";
	public static final String ARTIST_ACTIVITY_TITLE = "ArtistsActivity";

	public MainTest() {
		super(MainActivity.class);
	}

	@Before
	public void setUp() throws Exception {
		setTestInjector();
		activityRule.launchActivity(new Intent());
	}

	@Test
	public void testNavigateToArtistActivity() {
		onView(withId(R.id.etArtist)).perform(typeText(ARTIST), closeSoftKeyboard());
		onView(withId(R.id.btnShowArtists)).perform(click());

		EspressoUtils.matchToolbarTitle(ARTIST_ACTIVITY_TITLE);
	}


}