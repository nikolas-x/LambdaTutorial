package com.lorica.training.java8;

import com.lorica.training.java8.domain.Person;
import com.lorica.training.java8.domain.Student;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.lorica.training.java8.Ex2_Streams.*;
import static org.junit.Assert.*;

public class Ex2_StreamsTest {

    @Test
    public void testDoubleFilterSum() {
        OutputStream os_map = new ByteArrayOutputStream();
        OutputStream os_filter = new ByteArrayOutputStream();

        PrintStream ps_map = new PrintStream(os_map);
        PrintStream ps_filter = new PrintStream(os_filter);

        Stream<Integer> s = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream();

        assertEquals((long)90, (long)doubleFilterSum(s, ps_map, ps_filter));
        assertEquals("2 4 6 8 10 12 14 16 18 20 ", os_map.toString());
        assertEquals("10 12 14 16 18 20 ", os_filter.toString());

    }

    @Test
    public void testHailstoneSequence() {
        Stream<Integer> hs = hailstoneStream(5);
        assertEquals(hs.limit(6).collect(Collectors.toList()), Arrays.asList(5, 16, 8, 4, 2, 1));
    }

    @Test
    public void testStreamCount() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(10L, (long) streamCount(stream));
    }

    @Test
    public void testNTuplets() {
        List<String> names = Arrays.asList("A", "B", "C", "D", "E");
        assertEquals(names, nTuplets(names).map(Person::getFirstName).collect(Collectors.toList()));
    }

    @Test
    public void testMinWAMStudents() {
        List<Double> WAMS = Arrays.asList(50.0, 55.0, 60.0, 65.0, 70.0, 75.0, 80.0, 85.0, 90.0);

        Stream<Student> students = minWAMStudents(WAMS.stream()
                .map(x -> new Student("Jane", "Doe", 20, x))
                .collect(Collectors.toList())
                , 67.5);

        assertEquals(students
                .map(Student::getWAM)
                .collect(Collectors.toList())
                , WAMS.stream()
                .filter(x -> x >= 67.5)
                .collect(Collectors.toList()));
    }

    @Test
    public void testAny() {
        assertFalse(any(Stream.of(false, false, false, false, false)));
        assertTrue(any(Stream.of(false, false, false, true, false, false)));
    }

    @Test
    public void testPrintIntegers() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);

        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8);
        printIntegers(stream, ps);

        assertEquals("1\n2\n3\n4\n5\n6\n7\n8\n", os.toString());
    }

    @Test
    public void testSinAndCos() {
        Stream<Double> stream = Stream.of(Math.PI, Math.PI/2.0);

        List<Double> ans = Arrays.asList(0.0, -1.0, 1.0, 0.0);
        List<Double> res = sinAndCos(stream).collect(Collectors.toList());

        for (int i = 0; i < res.size(); i++) {
            assertEquals(ans.get(i), res.get(i), 0.01);
        }
    }
}
