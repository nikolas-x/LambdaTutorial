package com.lorica.training.java8;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Explores basic use of stream collectors
 */
public class Ex3_Collectors {

    /**
     * Collects all integers as a list
     */
    public static List<Integer> makeList( Stream<Integer> ints ) {
        return ints.collect(Collectors.toList());
    }

    /**
     * Collects the stream of Strings as a Set of strings
     */
    public static Set<String> makeSet( Stream<String> strings ) {
        return null;
    }

    /**
     * Count the number of doubles in the stream without using the Stream::count method
     *
     * Hint: See Collectors::counting
     */
    public static long countDoubles( Stream<Double> dbls ) {
        return 0;
    }

    /**
     * Collect the stream of integers as a comma separated string.
     *
     * e.g. [5,6,7] should return "5,6,7"
     *
     * Hint: See Collectors::joining
     */
    public static String joinInts( Stream<Integer> ints ) {
        return null;
    }

    /**
     * Calculate the mean of a the stream of integers
     *
     * Hint: See Collectors::summarizingInt
     */
    public static double calcMean( Stream<Integer> ints ) {
        return 0;
    }

    /**
     * Calculate the sum of a stream of integers
     *
     * Hint: See Collectors::summingLong
     */
    public static long calcSum( Stream<Integer> ints ) {
        return 0;
    }

    /**
     * Calculate the sum of a stream of integers encoded as String
     *
     * Hint: You don't need to call Stream::map before going to the collector
     */
    public static long calcSumOfIntStrings( Stream<String> strings ) {
        return 0;
    }

    /**
     * Return the stream of integers as a LinkedList
     *
     * Hint: see Collectors::toCollection
     */
    public static LinkedList<Integer> linkedList( Stream<Integer> integers ) {
        return null;
    }

    /**
     * Partition the stream of integers into those which are even, and those which are odd
     *
     * Represent the result as a Map<Boolean,List<Integer>>, where the true entry in the map is the even numbers,
     * and the false entry in the map is the odd numbers
     *
     * Hint: See Collectors::partitioningBy
     */
    public static Map<Boolean,List<Integer>> partitionEven( Stream<Integer> ints ) {
        return null;
    }

    /**
     * Group the stream of Objects by their class, constructing a list of objects of each class
     *
     * Hint: See Collectors::groupingBy
     */
    public static Map<Class,List<Object>> classifyingObject( Stream<Object> objects ) {
        return null;
    }

}
