package com.lorica.training.java8;

import com.lorica.training.java8.domain.Person;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.*;

public class Ex1_Lambads {

    /**
     * @return a function that doubles whichever integer is supplied
     *
     * Hint: Use Lambda notation, you don't need to do this as an anonymous class
     */
    public static Function<Integer,Integer> doublingFunction()
    {
        return i -> i*2;
    }

    /**
     * @return a BiFunction that calculates the product of two integers
     *
     * Hint: When using lambdas with more than one lambda parameter, you need to wrap all of them in brackets...
     */
    public static BiFunction<Integer,Integer,Integer> productFunction()
    {
        return (a,b) -> a*b;
    }

    /**
     * @return a function that converts a string to an integer.
     *
     * Hint: You don't need to actually implement this, use the method-reference syntax to return the parseInt
     * method on the Integer class
     */
    public static Function<String,Integer> parsingFunction()
    {
        return Integer::parseInt;
    }

    /**
     * @return a predicate (function that always returns a boolean) that is satisfied if the supplied integer is even
     */
    public static Predicate<Integer> isEvenPred()
    {
        return i -> i % 2 == 0;
    }

    /**
     * @return a BiPredicate (predicate with two args) that is satifised if the first number is evenly divisible
     * by the second
     *
     * Hint: When using lambdas with more than one lambda parameter, you need to wrap all of them in brackets...
     */
    public static BiPredicate<Integer,Integer> isDivisibleByPred()
    {
        return (a,b) -> a % b == 0;
    }

    /**
     * @return a Comparator that compares people by their first-name, then their second name.
     *
     * Hint: Use the Comparator.comparing method to extract a string (which is itself Comparable). You'll need
     * to chain this with the "thenComparing" method...
     */
    public static Comparator<Person> personComparator()
    {
        return Comparator.comparing(Person::getFirstName).thenComparing(Person::getSecondName);
    }

    /**
     * @return a Comparator that compares people by their first-name, then their second name, then their age.
     *      If their age is null, they should be ranked AFTER all other people who have specified an age.
     *
     * Hint: Use the output from the personComparator() solution, and explore the use of Comparator.nullsLast()
     */
    public static Comparator<Person> personComparatorWithAge()
    {
        return personComparator().thenComparing(Comparator.nullsLast(Comparator.comparing(Person::getAge)));
    }

    /**
     * @return a supplier of Lists that delivers LinkedList implementations
     *
     * Hint: See if you can use a constructor method reference
     */
    public static Supplier<List> linkedListSupplier()
    {
        return LinkedList::new;
    }

    /**
     * @return a consumer that write integers to a new line in the supplied printstream
     *
     * Note a consumer is like a function that returns void.
     *
     * Bonus: Use a method reference
     */
    public static Consumer<Integer> intWriter(PrintStream ps)
    {
        return ps::println;
    }
}
