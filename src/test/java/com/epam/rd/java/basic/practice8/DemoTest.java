package com.epam.rd.java.basic.practice8;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DemoTest {

    private static final String LINE_SEP = System.lineSeparator();

    @Test
    public void demoMainShouldPrintCorrectOutput() {
        String expected = "=========================== Part 1" + LINE_SEP +
                "[ivanov, petrov, obama]" + LINE_SEP +
                "=========================== Part 2" + LINE_SEP +
                "[teamA, teamB, teamC]" + LINE_SEP +
                "=========================== Part 3" + LINE_SEP +
                "[teamA]" + LINE_SEP +
                "~~~~~" + LINE_SEP +
                "[teamA, teamB]" + LINE_SEP +
                "~~~~~" + LINE_SEP +
                "[teamA, teamB, teamC]" + LINE_SEP +
                "~~~~~" + LINE_SEP +
                "=========================== Part 4" + LINE_SEP +
                "[teamB, teamC]" + LINE_SEP +
                "=========================== Part 5" + LINE_SEP +
                "[teamB, teamX]" + LINE_SEP;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Demo.main(null);

        Assert.assertEquals(expected, outContent.toString());
    }

}