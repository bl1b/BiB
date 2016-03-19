package com.udacity.gradle.builditbigger.joketeller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    private TextView txtJoke;

    public static final String EXTRA_JOKE = "extra_jokeactivity_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // do not display a title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_joke);

        if (findViewById(R.id.txt_joke) instanceof TextView) {
            txtJoke = (TextView) findViewById(R.id.txt_joke);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        updateJoke();
    }

    private void updateJoke() {

        String myJoke = getIntent().hasExtra(EXTRA_JOKE) ? getIntent().getStringExtra(EXTRA_JOKE) : getString(R.string.activity_joke_defaultjoke);

        if (txtJoke != null) {
            txtJoke.setText(myJoke);
        }
    }
}
