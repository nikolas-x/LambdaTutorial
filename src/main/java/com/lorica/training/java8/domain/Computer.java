package com.lorica.training.java8.domain;

import javax.annotation.Nonnull;
import java.util.Optional;

public class Computer {
    private @Nonnull Optional<Soundcard> sc;
    private @Nonnull CPU cpu;

    public Computer(@Nonnull Optional<Soundcard> sc, @Nonnull CPU cpu) {
        this.sc = sc;
        this.cpu = cpu;
    }

    @Nonnull
    public Optional<Soundcard> getSoundCard() {
        return sc;
    }

    public Computer.CPU getCpu() {
        return cpu;
    }


    public static class Soundcard {
        @Nonnull private Optional<USB> usb;

        @Nonnull
        public Optional<USB> getUsb() {
            return usb;
        }

        public Soundcard(@Nonnull Optional<USB> usb) {
            this.usb = usb;
        }
    }

    public static class CPU {
        @Nonnull private String brand;
        @Nonnull private int mhz;

        public CPU(@Nonnull String brand, int mhz) {
            this.brand = brand;
            this.mhz = mhz;
        }

        @Nonnull
        public String getBrand() {
            return brand;
        }

        public int getMhz() {
            return mhz;
        }
    }

    public static class USB {
        @Nonnull private Optional<String> version;

        public USB(@Nonnull Optional<String> version) {
            this.version = version;
        }

        @Nonnull
        public Optional<String> getVersion() {
            return version;
        }
    }
}
