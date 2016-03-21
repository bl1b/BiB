/**
 * ***************************************************************************
 * COMINTO GmbH
 * Klosterstr. 49
 * 40211 Düsseldorf
 * Germany
 * <p/>
 * (c) Copyright 2016 by COMINTO GmbH
 * ALL RIGHTS RESERVED
 * <p/>
 * -----------------------------------------------------------------------------
 * <p/>
 * ****************************************************************************
 */
package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * Class PullJokeTaskTest
 * <p>
 * DOCUMENT ME.
 * </p>
 *
 * @author gruenewald
 * @version 1.0.0
 * @since 1.0.0
 */
public class PullJokeTaskTest extends AndroidTestCase {

    @Test
    public void testResponseNotEmpty() throws ExecutionException, InterruptedException {
        PullJokeTask myTask = new PullJokeTask();
        myTask.execute(getContext());
        assertNotNull(myTask.get());
        assertFalse(myTask.get().isEmpty());
    }
}
