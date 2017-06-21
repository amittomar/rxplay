package com.example;

/**
 * Created by tomar on 21/06/17.
 */
public class ThreadUtil {
    public static String getCurrentThreadNAme() {
        return Thread.currentThread().getName();
    }

    public static void wait(Object monitor) throws InterruptedException {
        monitor.wait();
    }
}
