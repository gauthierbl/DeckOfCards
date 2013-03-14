package org.lab304.util;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ShufflerTest {
    private static final int RANDOM_SEED = 316;

    private Shuffler shuffler;
    private List<Integer> baselineShuffle;

    @Before
    public void setUp() throws Exception {
        // Seed the random Number generator
        shuffler = new Shuffler(new Random(RANDOM_SEED));

        /**
         *  build our baseline shuffle (our shuffle should work just like the JDK one as they are based on the
         *  same algorithm)
         */
        baselineShuffle = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(baselineShuffle, new Random(RANDOM_SEED));
    }

    @Test
    public void shuffleTest() throws Exception {
        // Our list to shuffle
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);


        shuffler.shuffle(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            assertEquals(baselineShuffle.get(i), numbers.get(i));
        }
    }
}
