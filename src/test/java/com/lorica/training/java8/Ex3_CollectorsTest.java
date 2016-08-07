package com.lorica.training.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class Ex3_CollectorsTest {

    @Test
    public void testMakeList() {
        assertEquals(Arrays.asList(1, 3, 5, 9), Ex3_Collectors.makeList(Stream.of(1, 3, 5, 9)));
    }

    @Test
    public void testMakeSet() {
        assertEquals(new HashSet<>( Arrays.asList("1","5","9") ) , Ex3_Collectors.makeSet(Stream.of("1", "5", "5", "9")));
    }

    @Test
    public void testCountDoubles() {
        assertEquals( 3, Ex3_Collectors.countDoubles(Stream.of(1.0, 2.0, 3.0)));
    }

    @Test
    public void testJoinInts() {
        assertEquals("1,2,3", Ex3_Collectors.joinInts(Stream.of(1, 2, 3)));
    }

    @Test
    public void calcMean() {
        assertEquals(2.0, Ex3_Collectors.calcMean(Stream.of(1, 2, 3)), 0.001 );
    }

    @Test
    public void calcSum() {
        assertEquals(6L, Ex3_Collectors.calcSum(Stream.of(1, 2, 3)));
    }

    @Test
    public void calcSumOfIntStrings() {
        assertEquals(6L, Ex3_Collectors.calcSumOfIntStrings(Stream.of("1", "2", "3")));
    }

    @Test
    public void linkedListTest() {
        assertEquals(Arrays.asList(1,2,3), Ex3_Collectors.linkedList(Stream.of(1, 2, 3)));
        assertEquals(LinkedList.class, (Ex3_Collectors.linkedList(Stream.of(1, 2, 3)).getClass()));
    }

    @Test
    public void partitionEven() {
        assertEquals(Arrays.asList(2), Ex3_Collectors.partitionEven(Stream.of(1, 2, 3)).get(true));
        assertEquals(Arrays.asList(1,3), Ex3_Collectors.partitionEven(Stream.of(1, 2, 3)).get(false));
    }

    @Test
    public void classifyingObject() {
        assertEquals(Arrays.asList(3,4), Ex3_Collectors.classifyingObject(Stream.of(3, 3.0, 4, true)).get(Integer.class));
        assertEquals(Arrays.asList(3.0), Ex3_Collectors.classifyingObject(Stream.of(3, 3.0, 4, true)).get(Double.class));
        assertEquals(Arrays.asList(true), Ex3_Collectors.classifyingObject(Stream.of(3, 3.0, 4, true)).get(Boolean.class));
    }
}
