package com.wordcounter.codeclan.wordcounterhw;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 12/18/17.
 */

public class WordCounterTest {

    WordCounter wordCounter;

    @Before
    public void before(){
        wordCounter = new WordCounter();
    }


    @Test
    public void canCountWords(){
        assertEquals("The result is 4", wordCounter.getWordCount("I have a cat"));
    }

    @Test
    public void canSeeWordOccurences(){
        assertEquals("frog : 4\n" +
                "how : 3\n" +
                "tea : 2\n", wordCounter.countWordOccurence("how how how tea tea frog frog frog frog"));
    }

}
