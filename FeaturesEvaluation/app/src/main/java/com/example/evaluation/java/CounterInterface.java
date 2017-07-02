package com.example.evaluation.java;

/**
 * Created by Ankur on 02-Jul-17.
 */

public interface CounterInterface {
    void incrementCounter();

    void setCounterValue(int value);

    int getCounterValue();

    default void resetCounter(){
        setCounterValue(0);
    }
}
