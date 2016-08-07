package com.lorica.training.java8;

import com.lorica.training.java8.domain.Computer;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.lorica.training.java8.domain.Computer.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class Ex4_OptionalTest {

    @Test
    public void testTestMakeOptional() throws Exception {
        assertEquals("10", Ex4_Optional.makeOptional(5).get() );
        assertFalse(Ex4_Optional.makeOptional(3).isPresent());
    }

    @Test
    public void testTestPrependString() throws Exception {
        assertEquals("NUM10", Ex4_Optional.prependString(5).get() );
        assertFalse(Ex4_Optional.makeOptional(3).isPresent());
    }

    @Test
    public void testExtractNumber() throws Exception {
        assertEquals(10, (long) Ex4_Optional.extractNumber(5).get() );
        assertFalse(Ex4_Optional.makeOptional(3).isPresent());
    }

    @Test
    public void testEmptyOn5() throws Exception {
        assertEquals("14", Ex4_Optional.emptyOn5(7).get() );
        assertFalse(Ex4_Optional.emptyOn5(3).isPresent());
        assertTrue(Ex4_Optional.emptyOn5(5).isPresent());
    }

    @Test
    public void testTrueIfAbsent() throws Exception {
        assertTrue(Ex4_Optional.trueIfAbsent(3));
        assertFalse(Ex4_Optional.trueIfAbsent(5));
    }

    @Test
    public void testMissingIfEmpty() throws Exception {
        assertEquals("10", Ex4_Optional.missingIfEmpty(5));
        assertEquals("MISSING", Ex4_Optional.missingIfEmpty(3));
    }

    @Test( expected = IllegalArgumentException.class)
    public void testCrashIfEmpty() throws Exception {
        Ex4_Optional.crashIfEmpty(3);
    }

    @Test
    public void testCrashIfEmptySucceed() throws Exception {
        assertEquals("10", Ex4_Optional.crashIfEmpty(5));
    }


    /////
    ///// Computer tests
    /////


    final CPU intelCPU = new CPU("Intel",1000);

    final USB usb1 = new USB(Optional.of("1.0"));
    final USB usb2 = new USB(Optional.of("2.0"));
    final USB noUSBVersion = new USB(Optional.empty());

    final Soundcard internalCard = new Soundcard(Optional.empty());
    final Soundcard usb1Card = new Soundcard(Optional.of(usb1));
    final Soundcard usb2Card = new Soundcard(Optional.of(usb2));
    final Soundcard noVerCard = new Soundcard(Optional.of(noUSBVersion));

    final Computer internalComp = new Computer(Optional.ofNullable(internalCard), intelCPU);
    final Computer usb1Comp = new Computer(Optional.ofNullable(usb1Card), intelCPU);
    final Computer usb2Comp = new Computer(Optional.ofNullable(usb2Card), intelCPU);
    final Computer noVerComp = new Computer(Optional.ofNullable(noVerCard), intelCPU);

    @Test
    public void testNestedOptionals() throws Exception {
        assertEquals(Optional.of(internalCard), Ex4_Optional.nestedOptionals(Optional.of(internalComp)));
        assertEquals(Optional.empty(), Ex4_Optional.nestedOptionals(Optional.empty()));
    }

    @Test
    public void testGetSoundcardUSBVersion() throws Exception {
        assertEquals("N/A", Ex4_Optional.getSoundcardUSBVersion(internalComp));
        assertEquals("1.0", Ex4_Optional.getSoundcardUSBVersion(usb1Comp));
    }

    @Test
    public void testGetUSBVersionStream() throws Exception {
        assertEquals(Arrays.asList("1.0", "2.0"), Ex4_Optional.getUSBVersionStream(Stream.of(internalComp, usb1Comp, usb2Comp, noVerComp)).collect(Collectors.toList()));
    }
}