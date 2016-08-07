package com.lorica.training.java8;

import com.lorica.training.java8.domain.Person;
import com.lorica.training.java8.domain.Student;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex2_Streams {
    /**
     * @return the number of objects in the given stream
     */
    public static <T> Long streamCount(Stream<T> stream) {
        return null;
    }

    /**
     * Using map,
     * @return a stream of person objects initialised with first names from the provided list, but all having
     * the same last name and age
     *
     * Ref: see the Person class
     */
    public static Stream<Person> nTuplets(List<String> firstNames) {
        return null;
    }

    /**
     * Using filter,
     * @return a stream of Students with WAMs same or greater than the provided Double
     */
    public static Stream<Student> minWAMStudents(List<Student> students, Double minWAM) {
        return null;
    }

    /**
     * Using reduce,
     * @return a boolean value indicating whether any of the values in the stream are true
     */
    public static Boolean any(Stream<Boolean> bools) {
        return null;
    }

    /**
     * Using forEach, Print each integer followed by a newline with the provided PrintStream
     *
     * Hint: Test your code using System.out as the PrintStream
     */
    public static void printIntegers(Stream<Integer> stream, PrintStream ps) {
        //todo
    }

    /**
     * Take the given stream, double all the numbers with map, filter to those that are greater than 9,
     * and return the sum of the remaining numbers.
     *
     * At each step, output the stream to the appropriate PrintStream in the format "1 2 3 " using peek.
     */
    public static Integer doubleFilterSum(Stream<Integer> stream, PrintStream ps_map, PrintStream ps_filter) {
        return null;
    }

    /**
     * Using flatMap,
     * @return A list of sin(x) and cos(x) values computed from the given list of values
     *
     * e.g: [1,2,3] -> [sin(1), cos(1), sin(2), cos(2), sin(3), cos(3)]
     *
     * Hint: Lookup the method Stream.of
     */
    public static Stream<Double> sinAndCos(Stream<Double> stream) {
        return null;
    }

    /**
     * Using collect and a standard Collector
     * @return a list of words from the stream
     */
    public static List<String> wordList(Stream<String> stream) {
        return null;
    }

    /**
     * Using Stream.iterate and Stream.limit,
     * @return an infinite stream that generates hailstone numbers starting from a given seed
     *
     * Each hailstone number is given by the formula
     *  0.5 * x ; if x is even
     *  3*x + 1 ; if x is odd
     *  where x is the previous number in the sequence
     *
     *  e.g: 5 -> 16 -> 8 -> 4 -> 2 -> 1 -> ...
     */
    public static Stream<Integer> hailstoneStream(Integer seed) {
    	return null;
        
    }

}
