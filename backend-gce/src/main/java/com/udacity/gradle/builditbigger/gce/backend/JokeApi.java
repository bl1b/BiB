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

/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.udacity.gradle.builditbigger.gce.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.builditbigger.jokelib.JokelibFactory;
import com.udacity.gradle.builditbigger.jokelib.simple.model.Joke;

/** An endpoint class we are exposing */
@Api(
  name = "jokeApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.gce.builditbigger.gradle.udacity.com",
    ownerName = "backend.gce.builditbigger.gradle.udacity.com",
    packagePath=""
  )
)
public class JokeApi {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "pullJoke")
    public Joke pullJoke() {
        return JokelibFactory.getInstance().provideJokeProvider().provideRandomJoke();
    }

}
