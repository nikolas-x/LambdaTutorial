package com.lorica.training.java8;

import com.lorica.training.java8.domain.Computer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Explores the use of the Java8 Optional class, requires a good understanding of Lambdas and streams
 */
public class Ex4_Optional {

    ////////////////////////////////////////////////////////////////////////////////////
    //////  Support methods
    ////////////////////////////////////////////////////////////////////////////////////

    /**
     * @return an arbitrary mapping of an int to a String. May return null for some inputs.
     */
    @Nullable
    public static String strMapper(int i) {
        if ( i % 3 == 0 ) {
            return null;
        }
        return i*2 + "";
    }


    ////////////////////////////////////////////////////////////////////////////////////
    //////  Tests
    ////////////////////////////////////////////////////////////////////////////////////


    /**
     * In one line return the result from strMapper wrapped as an Optional
     *
     * Hint: Understand the difference between Optional::of and Optional::ofNullable
     */
    @Nonnull
    public static Optional<String> makeOptional(int i) {
        return null;
    }

    /**
     * In one line return the result of strMapper() prepended by "NUM" and wrapped in an optional
     *
     * Hint: See Optional::map
     */
    @Nonnull
    public static Optional<String> prependString(int i) {
        return null;
    }

    /**
     * In one line return the result of strMapper() converted back to a number (if not null),
     * then wrapped in an Optional
     *
     * Hint: See Optional::map, and see if you can do this using a method reference
     */
    @Nonnull
    public static Optional<Integer> extractNumber(int i) {
        return null;
    }

    /**
     * In one line return the Optional wrapped result of strMapper, unless the wrapped number is 5 in which case
     * return empty.
     *
     * Hint: See Optional::Filter
     */
    @Nonnull
    public static Optional<String> emptyOn5( int i ) {
        return null;
    }

    /**
     * In one line, return true if strMapper() returned null, WITHOUT directly comparing to null.
     *
     * Hint: see Optional::isPresent
     */
    public static boolean trueIfAbsent(int i) {
        return false;
    }

    /**
     * In one line, return the result of strMapper(), or 'MISSING' if StringSupplier is null
     *
     * Hint: See Optional::orElse
     */
    @Nonnull
    public static String missingIfEmpty( int i ) {
        return null;
    }

    /**
     * In one line, return the result of strMapper(), throwing an IllegalArgumentException if it is null
     *
     * Hint: See Optional::orElseThrow
     */
    @Nonnull
    public static String crashIfEmpty( int i ) {
        return null;
    }

    /**
     * In one line, return an Optional of the soundcard in the Optional<Computer>
     *
     * Hint: See Optional::flatMap
     */
    @Nonnull
    public static Optional<Computer.Soundcard> nestedOptionals( Optional<Computer> c ) {
        return null;
    }

    /**
     * In one line, return an optional that contains the USB version of the soundcard if it available, "internal"
     * if the card doesn't have USB, or has USB but doesn't have a version
     *
     * Hint: See Optional::flatMap
     */
    @Nonnull
    public static String getSoundcardUSBVersion( Computer c ) {
        return null;
    }

    /**
     * Given a stream of computers, return a stream of the USB versions, if they are available, removing any
     * duplicate entries
     *
     * Hint: See Stream::distinct
     */
    @Nonnull
    public static Stream<String> getUSBVersionStream(Stream<Computer> compStream) {
        return null;
    }
}