package com.example.doreturn;

/**
 * @author manhdt14
 * created in 10/28/2023 11:28 PM
 */
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public void printSum(int a, int b) {
        System.out.println("Sum: " + add(a, b));
    }
}
