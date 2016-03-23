/*
 * *
 *  * ****************************************************************************
 *  * Copyright (c) 2016 by Jan Grünewald.
 *  * jan.gruenewald84@googlemail.com
 *  * <p>
 *  * This file is part of 'Build it Bigger'. 'Build it Bigger' was developed as
 *  * part of the Android Developer Nanodegree by Udacity.
 *  * <p>
 *  * 'Build it Bigger' is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  * <p>
 *  * 'Build it Bigger' is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  * <p>
 *  * You should have received a copy of the GNU General Public License
 *  * along with 'Build it Bigger'.  If not, see <http://www.gnu.org/licenses/>.
 *  * ****************************************************************************
 *
 */

package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.gce.backend.jokeApi.JokeApi;

import java.io.IOException;

/**
 * Class PullJokeTask.
 *
 * This task uses the configured GCE-Backend to pull a joke from the server.
 *
 * @author Jan Grünewald
 * @version 1.0.0
 */
public class PullJokeTask extends AsyncTask<Context, Void, String> {
    private static final String LOG_TAG = PullJokeTask.class.getSimpleName();
    private static JokeApi jokeApiService = null;

    private Context context;

    /**
     * Executed on a worker thread, this method will try to query a remote api to pull a joke.
     * (possible pun intended)
     *
     * @param params the context this task is launched on. Used for cb-handling.
     * @return the resulting joke or {code}null{code} if an error occured.
     */
    @Override protected String doInBackground(Context... params) {
        String myResult = null;

        if (params != null && params.length > 0) {
            context = params[0];

            ensureApiServiceInitialized();
            try {
                myResult = jokeApiService.pullJoke().execute().getText();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Unable to retrieve joke from remote api: " + e.getMessage());
                myResult = null;
            }
        }

        return myResult;
    }

    /**
     * Handle the resulting joke (string). This method will be executed on the mainthread.
     *
     * @param s the resulting joke.
     */
    @Override protected void onPostExecute(String s) {
        if (context instanceof MainActivity) {
            ((MainActivity) context).launchJokeIntent(s);
        }
    }

    /**
     * This is a helper method to ensure that the server apiservice (gce-backend) is initialized.
     */
    private void ensureApiServiceInitialized() {
        if (jokeApiService == null && context != null) {
            String myApiUri = context.getString(R.string.gce_api_uri);
            JokeApi.Builder myBuilder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl(context.getString(R.string.gce_api_uri))
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    })
                    .setApplicationName("jokeApi");

            jokeApiService = myBuilder.build();
        }
    }
}
