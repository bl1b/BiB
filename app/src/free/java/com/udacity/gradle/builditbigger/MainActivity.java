package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.joketeller.JokeActivity;


public class MainActivity extends AppCompatActivity {

    InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context me = this;

        // Ad-related stuff (only applies on MainActivity of "free"-flavor)
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                new PullJokeTask().execute(me);
            }
        });
        requestNewInterstitial();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        // old
//        Toast.makeText(this, JokelibFactory.getInstance().provideJokeProvider().provideRandomJoke(), Toast.LENGTH_LONG).show();
        // new: use pull joke task and kick off intent
//        new PullJokeTask().execute(this);
        // newer: kick off an ad before showing a joke
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            new PullJokeTask().execute(this);
        }
    }

    public void launchJokeIntent(String jokeText) {
        Intent jokeIntent = new Intent(getApplicationContext(), JokeActivity.class);
        jokeIntent.putExtra(JokeActivity.EXTRA_JOKE, jokeText);
        startActivity(jokeIntent);
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(getString(R.string.ad_test_device_id))
                .build();

        if (interstitialAd != null) {
            interstitialAd.loadAd(adRequest);
        }
    }
}
