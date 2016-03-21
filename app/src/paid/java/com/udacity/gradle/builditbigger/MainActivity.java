package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.gradle.builditbigger.joketeller.JokeActivity;


public class MainActivity extends AppCompatActivity {

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage(getString(R.string.progress_message));
        dialog.setCancelable(false);
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
        dialog.show();
        new PullJokeTask().execute(this);
    }

    public void launchJokeIntent(String jokeText) {
        dialog.dismiss();

        // only show joke-intent when there is a joke to tell
        if (jokeText != null && !jokeText.isEmpty()) {
            Intent jokeIntent = new Intent(getApplicationContext(), JokeActivity.class);
            jokeIntent.putExtra(JokeActivity.EXTRA_JOKE, jokeText);
            startActivity(jokeIntent);
        }
    }
}
