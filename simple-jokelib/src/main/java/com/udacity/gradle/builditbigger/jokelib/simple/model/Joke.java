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

package com.udacity.gradle.builditbigger.jokelib.simple.model;

/**
 * Class Joke.
 *
 * A POJO for jokes.
 *
 * @author Jan Grünewald
 * @version 1.0.0
 */
public class Joke {
    private String text;

    /**
     * Default constructor for the joke POJO.
     */
    public Joke() {
        text = null;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
