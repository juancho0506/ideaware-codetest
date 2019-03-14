package com.ideaware.codetest.ideawarecodetest;

import com.ideaware.codetest.ideawarecodetest.Exercise1.Exercise1;

public class IT {

    private static Exercise1 exercise1 = new Exercise1();


    public static void main(String[] args) {
        try {
            exercise1.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
