package com.ideaware.codetest.ideawarecodetest.Exercise2;

import org.junit.Before;
import org.junit.Test;

public class Exercise2Test {

    private Exercise2 exercise2;

    @Before
    public void setup() {
        exercise2 = new Exercise2();
    }

    @Test
    public void testEmptyArray() {
        final String[] elements = {};

        exercise2.findFirstLetterAIndexAndPrint(elements);
    }

    @Test
    public void testValidArray() {
        final String[] elements = {"United States", "England", "Germany", "Netherlands", "Slovenia"};
        exercise2.findFirstLetterAIndexAndPrint(elements);
    }

    @Test
    public void testNoACharInArrayElements() {
        final String[] elements = {"United", "Turtle", "Hello", "The Hell!", "Test"};
        exercise2.findFirstLetterAIndexAndPrint(elements);
    }
}