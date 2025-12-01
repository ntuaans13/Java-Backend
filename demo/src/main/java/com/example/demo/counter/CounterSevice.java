package com.example.demo.counter;

import org.springframework.stereotype.Service;

@Service
public class CounterService {
    private int counter = 0;
    
    public int increment() {
        counter++;
        return counter;
    }

    public int decrement() {
        counter--;
        return counter;
    }

    public int getCounter() {
        return counter;
    }

    public void resetCounter() {
        counter = 0;
    }
}