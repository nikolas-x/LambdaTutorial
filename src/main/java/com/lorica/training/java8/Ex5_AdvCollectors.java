package com.lorica.training.java8;

import com.lorica.training.java8.domain.Computer;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Explores more advanced usage of Java8 collectors, you need a good understanding of Lambdas and a basic
 * understanding of Collectors
 */
public class Ex5_AdvCollectors {

    /**
     * @return a map of CPU -> Number of CPUs of that type
     *
     * Hint: Use groupingBy, but try adding a "downstream" collector
     */
    public static Map<Computer.CPU,Long> countCPUs(Stream<Computer> computers) {
        return null;
    }

    /**
     * @return a map of CPU -> Set of computers that have that type
     */
    public static Map<Computer.CPU,Set<Computer>> groupComputers(Stream<Computer> computers) {
        return null;
    }

    /**
     * @return a map of CPU -> TreeMap of computers that have that type
     */
    public static LinkedHashMap<Computer.CPU,Set<Computer>> groupComputersLinkedHashMap(Stream<Computer> computers) {
        return null;
    }

    /**
     * @return the product (result of all numbs multiplied together) of the stream of integers using Collectors::reduce
     *
     * (Note, you can also use Stream::reduce to do the same thing, but use the collector approach here)
     */
    public static Long product(Stream<Long> longs) {
        return null;
    }

    /**
     * @return a map of CPU brand -> Set of Mhz of that Brand
     *
     * Hint: Use groupingBy, and try nesting Collectors::mapping downstream
     */
    public static Map<String,Set<Integer>> groupByBrand(Stream<Computer> computers) {

        computers.collect(Collectors.groupingBy( c -> c.getCpu().getBrand(), Collectors.mapping( c -> c.getCpu().getMhz(), Collectors.toSet())));

        return null;
    }

    /**
     * @return a map of CPU brand -> LinkedList of Mhz of that brand
     *
     * Hint: Use groupingBy and try Collectors::toCollection
     */
    public static Map<String,LinkedList<Integer>> groupByBrandLinkedList(Stream<Computer> computers) {
        return null;
    }

    /**
     * The stream consists of a Pair (Map.Entry) of a purchase date and the computer which was purchased
     *
     * @return a map of the purchases, grouped firstly by the purchase year, with a nested map of the purchase month
     *      to the List of computers purchased in that month
     *
     * Hint: This is all about nesting collectors together. To keep track of where you are up to, place lambdas
     * on separate lines, indented as appropriate.
     */
    public static Map<Integer,Map<Integer,List<Computer>>> groupByYearMonth(Stream<Map.Entry<LocalDate, Computer>> computers) {
        return null;
    }
}
