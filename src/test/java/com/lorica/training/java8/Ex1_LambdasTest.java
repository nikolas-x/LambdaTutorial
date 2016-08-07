package com.lorica.training.java8;

import com.lorica.training.java8.domain.Person;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.lorica.training.java8.Ex1_Lambads.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Ex1_LambdasTest {
    @Test
    public void testDoublingFunction() {
        List<Integer> x = Arrays.asList(1,2,3,4,5);
        List<Integer> y = Arrays.asList(2,4,6,8,10);

        assertEquals(y, x.stream().map(doublingFunction()).collect(Collectors.toList()));

    }


    @Test
    public void testProductFunction() {
        List<Integer> x = Arrays.asList(1,2,3,4,5,6);
        List<Integer> y = Arrays.asList(2,3,4,5,6,7);
        List<Integer> z = Arrays.asList(2,6,12,20,30,42);


        for (int i = 0; i < x.size(); i++) {
            assertEquals(z.get(i), productFunction().apply(x.get(i), y.get(i)));
        }
    }

    @Test
    public void testParsingFunction() {
        assertEquals((Integer) 5, parsingFunction().apply("5"));

        List<String> x = Arrays.asList("1", "2", "3", "4", "5", "9999");
        List<Integer> y = Arrays.asList(1, 2, 3, 4, 5, 9999);

        assertEquals(y, x.stream().map(parsingFunction()).collect(Collectors.toList()));
    }

    @Test
    public void testIsEvenPred() {
        List<Integer> x = Arrays.asList(2,4,6,8,10);
        List<Integer> y = new ArrayList<Integer>(x);
        y.add(1);
        y.add(3);
        y.add(5);
        y.add(7);
        y.add(9);

        assertEquals(x, x.stream().filter(isEvenPred()).collect(Collectors.toList()));
        assertEquals(x, y.stream().filter(isEvenPred()).collect(Collectors.toList()));

        assertTrue(x.stream()
                        .map(a -> isEvenPred().test(a))
                        .reduce(Boolean.TRUE, (a, b) -> a && b)
        );

    }

    @Test
    public void testIsDivisibleByPred() {
        List<Integer> x = Arrays.asList(1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60);

        assertTrue(x.stream()
                        .map(a -> isDivisibleByPred().test(60, a))
                        .reduce(true, (a, b) -> a && b)
        );
    }

    @Test
    public void testPersonComparator() {

        List<Person> people = Arrays.asList(
                new Person("Aaron A.", "Aaronson", 21),
                new Person("Aaron A.", "Baronson", 20),
                new Person("Aaron B.", "Aaronson", 20),
                new Person("Aaron B.", "Baronson", 20),
                new Person("Aaron C.", "Aaronson", 20)
        );

        List<Person> shuffledPeople = new ArrayList<Person>(people);
        Comparator<Person> comp = personComparator();

        IntStream.rangeClosed(1, 8).forEach(x -> {
            Collections.shuffle(shuffledPeople);
            shuffledPeople.sort(comp);
            assertEquals(shuffledPeople, people);
        });

    }

    @Test
    public void testPersonComparatorWithAge() {
        List<Person> people = Arrays.asList(
                new Person("Aaron A.", "Aaronson", 20),
                new Person("Aaron A.", "Aaronson", 21),
                new Person("Aaron A.", "Aaronson", null),
                new Person("Aaron A.", "Baronson", 20),
                new Person("Aaron A.", "Baronson", 21),
                new Person("Aaron A.", "Baronson", null),
                new Person("Aaron B.", "Aaronson", 20),
                new Person("Aaron B.", "Aaronson", 21),
                new Person("Aaron B.", "Aaronson", null),
                new Person("Aaron B.", "Baronson", 20),
                new Person("Aaron B.", "Baronson", 21),
                new Person("Aaron B.", "Baronson", null),
                new Person("Aaron C.", "Aaronson", 20),
                new Person("Aaron C.", "Aaronson", 21),
                new Person("Aaron C.", "Aaronson", null)
        );

        List<Person> shuffledPeople = new ArrayList<Person>(people);
        Comparator<Person> comp = personComparatorWithAge();

        IntStream.rangeClosed(1, 8).forEach(x -> {
            Collections.shuffle(shuffledPeople);
            shuffledPeople.sort(comp);
            assertEquals(shuffledPeople, people);
        });
    }

    @Test
    public void testLinkedListSupplier() {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> l2 = l.stream().collect(Collectors.toCollection(linkedListSupplier()));

        assertEquals(l, l2);
    }

    @Test
    public void testIntWriter() {

        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);

        Consumer<Integer> c = intWriter(ps);
        Arrays.asList(1, 2, 3, 4, 5, 6).forEach(c);

        String expected = "1\n2\n3\n4\n5\n6\n";
        assertEquals(expected, os.toString());
    }
}
