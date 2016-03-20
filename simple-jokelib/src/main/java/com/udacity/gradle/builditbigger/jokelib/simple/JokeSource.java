/******************************************************************************
 * COMINTO GmbH
 * Klosterstr. 49
 * 40211 Düsseldorf
 * Germany
 * <p>
 * (c) Copyright 2016 by Jan Grünewald
 * ALL RIGHTS RESERVED
 * <p>
 * -----------------------------------------------------------------------------
 * <p>
 ******************************************************************************/
package com.udacity.gradle.builditbigger.jokelib.simple;

/**
 * Class JokeSource
 * <p>
 * A plain and stupid source of jokes.
 * </p>
 * <p>
 * $ Date: $
 *
 * @author Jan
 * @version $Revision: $
 */
public class JokeSource {

    private final String[] jokes = {
            "There are 10 kinds of people in the world: Those that know binary & those that don't",
            "Two bytes meet. The first byte asks, \"Are you ill?\"\nThe second byte replies, \"No, just feeling a bit off.\"",
            "Software is like sex: It's better when it's free.",
            "Q: how many programmers does it take to change a light bulb?\nA: none, that's a hardware problem",
            "\"Knock, knock.\"\n\"Who's there?\"\n\"very long pause...\"\n\"Java.\"",
            "A physicist, an engineer and a programmer were in a car driving over a steep alpine pass when the brakes failed. The car was getting faster and faster, they were struggling to get round the corners and once or twice only the feeble crash barrier saved them from crashing down the side of the mountain. They were sure they were all going to die, when suddenly they spotted an escape lane. They pulled into the escape lane, and came safely to a halt.\n" +
                    "The physicist said \"We need to model the friction in the brake pads and the resultant temperature rise, see if we can work out why they failed\".\n" +
                    "The engineer said \"I think I've got a few spanners in the back. I'll take a look and see if I can work out what's wrong\".\n" +
                    "The programmer said \"Why don't we get going again and see if it's reproducible?\"",
            "Q:\"Whats the object-oriented way to become wealthy?\"\n" +
                    "A:Inheritance",
            "A SQL query goes into a bar, walks up to two tables and asks,\"Can I join you?\"",
            "A man flying in a hot air balloon suddenly realizes he's lost. He reduces height and spots a man down below. He lowers the balloon further and shouts to get directions, \"Excuse me, can you tell me where I am?\"\n" +
                    "The man below says:\"Yes. You're in a hot air balloon, hovering 30 feet above this field.\" \"You must work in Information Technology,\" says the balloonist.\n" +
                    "\"I do\" replies the man.\"How did you know?\" \"Well,\" says the balloonist,\"everything you have told me is technically correct, but It's of no use to anyone.\"\n" +
                    "The man below replies, \"You must work in management.\" \"I do,\" replies the balloonist,\"But how'd you know?\" \"Well\",\n" +
                    "says the man,\"you don't know where you are or where you're going, but you expect me to be able to help. You're in the same position you were before we met, but now it's my fault.\"",
            "Programming in C is like fast dancing on a newly-waxed dancefloor by people carrying razors.",
            "Program,noun: A magic spell cast upon a computer to enable it to turn input into error messages.",
            "If Java is the answer, it must have been a really verbose question.",
            "Software developers like to solve problems.\n" +
                    "If there are no problems handily available, they will create their own problems.",
            "To understand what recursion is, you must first understand recursion.",
            "Unix is user friendly.It's just very particular about who its friends are."
    };

    /**
     * Returns the number of available jokes.
     *
     * @return the number of jokes
     */
    public int getNumberOfJokes() {
        return jokes.length;
    }

    /**
     * Fetches a joke at a given index.
     *
     * @param index the index of the joke to return.
     * @return a string containing the joke or {code}null{code} when the index is out of range.
     */
    public String getJokeAtIndex(int index) {
        String myJoke = null;

        if (index > 0 && index < getNumberOfJokes()) {
            myJoke = jokes[index];
        }

        return myJoke;
    }
}
