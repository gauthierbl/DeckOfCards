package org.lab304.util;

import java.util.Collection;

/**
 * Assertion utility class that assists in validating arguments. Useful for identifying programmer errors early and
 * clearly at runtime.
 */
public final class Assert {

    // Prevent construction.
    private Assert() {
    }

    /**
     * Validates that a collection is not empty.
     *
     * @param collection the collection to check.
     * @param message    an optional message to use in the exception.
     * @throws IllegalArgumentException if the collection is empty.
     */
    public static void isNotEmpty(Collection<?> collection, String message) throws IllegalArgumentException {
        if (isEmpty(collection)) {
            throw new IllegalArgumentException(message);
        }
    }

    private static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
