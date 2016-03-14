package hu.bme.aut.android.spotifydemo.di;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME) // not needed
public @interface Network {
}
