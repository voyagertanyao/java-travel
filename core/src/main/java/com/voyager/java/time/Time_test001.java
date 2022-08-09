package com.voyager.java.time;

import java.time.Instant;

public class Time_test001 {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now.getEpochSecond());
        System.out.println(now.getNano());
    }
}
