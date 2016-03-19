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

    public String provideRandomJoke() {
        String myRandomJoke = null;

        if (jokeSource != null) {
            Random myRand = new Random();
            myRandomJoke = jokeSource.getJokeAtIndex(myRand.nextInt(jokeSource.getNumberOfJokes()));
        }

        return myRandomJoke;
    }
}
