/******************************************************************************
 * COMINTO GmbH
 * Klosterstr. 49
 * 40211 Düsseldorf
 * Germany
 * <p>
 * (c) Copyright 2016 by COMINTO GmbH
 * ALL RIGHTS RESERVED
 * <p>
 * -----------------------------------------------------------------------------
 * <p>
 * $Id: $
 ******************************************************************************/
package com.udacity.gradle.builditbigger.jokelib.simple;

import com.udacity.gradle.builditbigger.jokelib.JokelibFactory;
import com.udacity.gradle.builditbigger.jokelib.simple.model.Joke;

import java.util.Random;

/**
 * Class JokeProvider
 * <p>
 * DOCUMENT ME.
 * </p>
 * <p>
 * $ Date: $
 *
 * @author Jan
 * @version $Revision: $
 */
public class JokeProvider {

    private final JokeSource jokeSource;

    public JokeProvider() {
        jokeSource = JokelibFactory.getInstance().provideJokeSource();
    }

    public Joke provideRandomJoke() {
        Joke myRandomJoke = null;

        if (jokeSource != null) {
            myRandomJoke = new Joke();
            Random myRand = new Random();
            myRandomJoke.setText(jokeSource.getJokeAtIndex(myRand.nextInt(jokeSource.getNumberOfJokes() - 1)));
        }

        return myRandomJoke;
    }
}
