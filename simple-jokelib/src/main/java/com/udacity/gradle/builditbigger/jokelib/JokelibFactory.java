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
package com.udacity.gradle.builditbigger.jokelib;

import com.udacity.gradle.builditbigger.jokelib.simple.JokeProvider;
import com.udacity.gradle.builditbigger.jokelib.simple.JokeSource;

/**
 * Class JokelibFactory
 * <p>
 * DOCUMENT ME.
 * </p>
 * <p>
 * $ Date: $
 *
 * @author Jan
 * @version $Revision: $
 */
public class JokelibFactory {
    private JokeProvider jokeProvider;
    private JokeSource jokeSource;

    private static JokelibFactory instance;

    /**
     * Private constructor for the JokelibFactory
     */
    private JokelibFactory() {
        jokeProvider = null;
        jokeSource = null;
    }

    /**
     * Returns the singleton instance of this factory.
     *
     * @return an instance of JokelibFactory.
     */
    public static JokelibFactory getInstance() {
        if (instance == null) {
            instance = new JokelibFactory();
        }

        return instance;
    }

    public JokeSource provideJokeSource() {
        if (jokeSource == null) {
            jokeSource = new JokeSource();
        }

        return jokeSource;
    }

    public JokeProvider provideJokeProvider() {
        if (jokeProvider == null) {
            jokeProvider = new JokeProvider();
        }

        return jokeProvider;
    }
}
