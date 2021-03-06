package com.wordcounter.codeclan.wordcounterhw;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.lang.String.join;

/**
 * Created by user on 12/18/17.
 */

public class WordCounter {


    public WordCounter(){

    }

    public String getWordCount(String sentence){
       String removedPunctuation = sentence.replaceAll("[^a-zA-Z0-9'\\s]+"," ").toLowerCase();
        String[] result = removedPunctuation.split(" ");
        return "The result is " + result.length;
    }

    public String countWordOccurence(String sentence){
        Map <String, Integer> wordCount = new HashMap<>();
        String removedPunctuation = sentence.replaceAll("[^a-zA-Z0-9'\\s]+"," ").toLowerCase();
            String[] separatedWords = removedPunctuation.split(" ");
                for (String word : separatedWords){
                    if (wordCount.containsKey(word) && !word.equals("")){
                        int count = Integer.parseInt(String.valueOf(wordCount.get(word)));
                        wordCount.put(word, count + 1);
                    }
                    else if (!word.equals("")){
                        wordCount.put(word, 1);
                    }
                }
              HashMap<String,Integer> wordCountHashMap = new HashMap<String, Integer>(wordCount);
                sortValues(wordCountHashMap);
        ArrayList<String> resultArray = sortValues(wordCountHashMap);
        StringBuilder result = new StringBuilder();
        for (String s : resultArray)
        {
            result.append(s);
            result.append("\n");
        }
            return result.toString();
//        return String.join("\n", resultArray);
            }


    public ArrayList<String> sortValues(HashMap<String, Integer> map){
        Object[] a = map.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Integer>) o2).getValue()
                        .compareTo(((Map.Entry<String, Integer>) o1).getValue());
            }
        });
        ArrayList<String> resultArray = new ArrayList<>();
        for (Object e : a) {
            resultArray.add(((Map.Entry<String, Integer>) e).getKey() + " : "
                    + ((Map.Entry<String, Integer>) e).getValue());
        }
        return resultArray;
         }




    }
