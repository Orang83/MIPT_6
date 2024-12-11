package com.example.mipt_2;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.mipt_2.utils.TextCounter;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testGetCharsCount() {
        assertEquals(5, TextCounter.getCharsCount("Hello"));
        assertEquals(0, TextCounter.getCharsCount(""));
    }

    @Test
    public void testGetWordCount() {
        assertEquals(3, TextCounter.getWordCount("Hello world here"));
        assertEquals(1, TextCounter.getWordCount("Single"));
        assertEquals(0, TextCounter.getWordCount(""));
    }
}