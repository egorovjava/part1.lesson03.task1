package com.gmail.egorovsonalexey.lesson3;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        //MyHashMap<Integer, Integer> hm = new MyHashMap<>();
        hm.put(1, 101);
        hm.get(1);

        Set<Map.Entry<Integer, Integer>> es = hm.entrySet();

        for(Map.Entry<Integer, Integer> entry : es) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        hm.put(2, 102);
        System.out.println();

        for(Map.Entry<Integer, Integer> entry : es) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

class SimpleHashClass {
    @Override
    public int hashCode() {
        return 1;
    }
}
