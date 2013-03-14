package org.lab304.util;

import java.util.List;
import java.util.Random;

/**
 * Provides a way to shuffle objects. This implements a Fisher-Yates shuffle.
 */
public class Shuffler {

    Random randomNumberGenerator;

    /**
     * A constructor that allows inputting you own random number source.
     *
     * @param randomNumberGenerator a random number source.
     */
    public Shuffler(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    /**
     * Default constructor.
     */
    public Shuffler() {
        this(new Random());
    }

    /**
     * Shuffle elements in a List. This modifies the given list.
     *
     * @param objectsToShuffle  The List to shuffle. This object wil be modified
     * @param <T>               The type of object that will be shuffled
     */
    public <T> void shuffle(List<T> objectsToShuffle) {
        Assert.isNotEmpty(objectsToShuffle, "shuffle(...):objectsToShuffle must not be empty!");

        // start at back and work forward
        for (int i = objectsToShuffle.size() - 1; i > 1; i--) {

            // generate a random index from our current to the front
            int randomIndex = randomNumberGenerator.nextInt(i + 1);

            // swap our current element with the element at random index.
            T temp = objectsToShuffle.get(i);
            objectsToShuffle.set(i, objectsToShuffle.get(randomIndex));
            objectsToShuffle.set(randomIndex, temp);

        }
    }
}
