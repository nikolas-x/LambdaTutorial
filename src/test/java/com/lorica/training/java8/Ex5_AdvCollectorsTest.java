package com.lorica.training.java8;

import com.lorica.training.java8.domain.Computer;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Ex5_AdvCollectorsTest {

    static final Computer.CPU intelCPU1000 = new Computer.CPU("Intel",1000);
    static final Computer.CPU intelCPU2000 = new Computer.CPU("Intel",2000);
    static final Computer.CPU amdCPU1800 = new Computer.CPU("AMD",1800);
    static final Computer.CPU amdCPU2200 = new Computer.CPU("AMD",2200);

    static final Computer intel1000 = new Computer(Optional.empty(), intelCPU1000 );
    static final Computer intel1000_2 = new Computer(Optional.empty(), intelCPU1000 );
    static final Computer intel2000 = new Computer(Optional.empty(), intelCPU2000 );
    static final Computer amd1800 = new Computer(Optional.empty(), amdCPU1800 );

    @Test
    public void testCountCPUs() {
        assertEquals(2L, (long) Ex5_AdvCollectors.countCPUs(Stream.of(intel1000, intel2000, intel1000_2)).get(intelCPU1000));
        assertEquals(1L, (long) Ex5_AdvCollectors.countCPUs(Stream.of(intel1000, intel2000, intel1000_2)).get(intelCPU2000));
    }

    @Test
    public void testGroupComputers() {
        final Computer[] computers = {intel1000, intel2000, intel1000_2};
        assertEquals(new HashSet<>(Arrays.asList(intel1000, intel1000_2)), Ex5_AdvCollectors.groupComputers(Stream.of(computers)).get(intelCPU1000));
        assertEquals(new HashSet<>(Arrays.asList(intel2000)), Ex5_AdvCollectors.groupComputers(Stream.of(computers)).get(intelCPU2000));
    }

    @Test
    public void testGroupComputersLinkedHashMap() {
        final Computer[] computers = {intel1000, intel2000, intel1000_2};
        assertEquals(new HashSet<>(Arrays.asList(intel1000, intel1000_2)), Ex5_AdvCollectors.groupComputersLinkedHashMap(Stream.of(computers)).get(intelCPU1000));
        assertEquals(new HashSet<>(Arrays.asList(intel2000)), Ex5_AdvCollectors.groupComputersLinkedHashMap(Stream.of(computers)).get(intelCPU2000));
        assertEquals(LinkedHashMap.class, Ex5_AdvCollectors.groupComputersLinkedHashMap(Stream.of(computers)).getClass());
    }

    @Test
    public void testGroupByBrand() {
        final Computer[] computers = {intel1000, intel2000, amd1800};
        assertEquals(new HashSet<>(Arrays.asList(1000,2000)), Ex5_AdvCollectors.groupByBrand(Stream.of(computers)).get("Intel"));
        assertEquals(new HashSet<>(Arrays.asList(1800)), Ex5_AdvCollectors.groupByBrand(Stream.of(computers)).get("AMD"));
    }

    @Test
    public void testGroupByBrandLinkedList() {
        final Computer[] computers = {intel1000, intel2000, amd1800};
        assertEquals(Arrays.asList(1000,2000), Ex5_AdvCollectors.groupByBrandLinkedList(Stream.of(computers)).get("Intel"));
        assertEquals(Arrays.asList(1800), Ex5_AdvCollectors.groupByBrandLinkedList(Stream.of(computers)).get("AMD"));
        assertEquals(LinkedList.class, Ex5_AdvCollectors.groupByBrandLinkedList(Stream.of(computers)).get("AMD").getClass());
    }

    @Test
    public void testProduct() {
        assertEquals(60, (long) Ex5_AdvCollectors.product(Stream.of(3L,4L,5L)));
    }

    @Test
    public void testGroupByYearMonth() {
        Map<LocalDate,Computer> computers = new HashMap<>();
        computers.put(LocalDate.of(2013, 4, 5), intel1000);
        computers.put(LocalDate.of(2014, 4, 5), intel1000_2);
        computers.put(LocalDate.of(2014, 4, 6), intel2000);
        computers.put(LocalDate.of(2014, 6, 5), amd1800);

        final Map<Integer, Map<Integer, List<Computer>>> result = Ex5_AdvCollectors.groupByYearMonth(computers.entrySet().stream());

        assertEquals(Arrays.asList(intel1000), result.get(2013).get(4));
        assertTrue(result.get(2014).get(4).contains(intel1000_2));
        assertTrue(result.get(2014).get(4).contains(intel2000));
        assertEquals(Arrays.asList(amd1800), result.get(2014).get(6));
    }

}
