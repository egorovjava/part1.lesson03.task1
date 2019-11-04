package com.gmail.egorovsonalexey.lesson3;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MyHashMapTest {

    private MyHashMap<Integer, Integer> getTestHashMap() {
        MyHashMap<Integer, Integer> hm = new MyHashMap<>();
        for(int i = 0; i < 10; i++) {
            hm.put(i, i + 100);
        }
        return hm;
    }

    @Test
    public void myHashMapTest() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();

        assert map.get(1) == null;
        assert !map.containsKey(1);

        for(int i = 0; i < 10; i++) {
            assert map.size() == i;
            map.put(i, i + 100);
        }

        int count = map.size();

        Integer val = map.get(5);
        assert val == 105;

        map.remove(5);
        assert map.size() == count - 1;
        boolean res = map.containsKey(5);
        Assert.assertFalse(res);
    }

    @Test
    public void putTest() {
        MyHashMap<Integer, Integer> hm = new MyHashMap<>();
        hm.put(10, 1000);
        assert hm.get(10) == 1000;
        hm.put(5, 1005);
        assert hm.get(5) == 1005;
    }


    @Test
    public void putAllTest() {
        HashMap<Integer, Integer> vals = new HashMap<>();
        for(int i = 0; i < 10; i++) {
            vals.put(i, i + 100);
        }

        MyHashMap<Integer, Integer> hm = new MyHashMap<>();
        hm.putAll(vals);
        for(int i = 0; i < 10; i++) {
            assert hm.get(i).equals(vals.get(i));
        }
    }

    @Test
    public void clearTest() {
        MyHashMap<Integer, Integer> hm = getTestHashMap();

        hm.clear();
        assert hm.size() == 0;
        Assert.assertNull(hm.get(0));
    }

    @Test
    public void keySetTest() {
        MyHashMap<Integer, Integer> hm = getTestHashMap();

        Set<Integer> keys = hm.keySet();
        assert keys.size() == hm.size();
        for(Integer key : keys) {
            assert hm.containsKey(key);
        }
    }

    @Test
    public void valuesSet() {
        MyHashMap<Integer, Integer> hm = getTestHashMap();
        Collection<Integer> list = hm.values();
        assert list.size() == hm.size();
        for(Integer i : list) {
            assert hm.containsValue(i);
        }
    }

    @Test
    public void entrySetTest() {
        MyHashMap<Integer, Integer> hm = getTestHashMap();
        Set<Map.Entry<Integer, Integer>> set = hm.entrySet();
        assert set.size() == hm.size();
        for(Map.Entry<Integer, Integer> e : set) {
            assert hm.get(e.getKey()).equals(e.getValue());
        }
    }

    @Test
    public void containsTest() {
        MyHashMap<Integer, Integer> hm = getTestHashMap();

        Assert.assertTrue(hm.containsKey(0));
        Assert.assertFalse(hm.containsKey(10));
        Assert.assertTrue(hm.containsValue(100));
        Assert.assertFalse(hm.containsValue(110));
    }

    @Test
    public void myHashMapPutTest() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        for(int i = 0; i < 10; i++) {
            map.put(i, i + 100);
        }

        Integer res = map.put(5, 205);
        if(res == null)
            res = 0;
        assert res == 105;
    }

    @Test
    public void myHashMapDeleteTest() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        for(int i = 0; i < 10; i++) {
            map.put(i, i + 100);
        }

        Assert.assertNull(map.remove(10));
    }

    @Test
    public void myHashMapGetTest() {
        MyHashMap<SimpleHashClass, Integer> map = new MyHashMap<>();
        SimpleHashClass key1 = new SimpleHashClass();
        SimpleHashClass key2 = new SimpleHashClass();

        map.put(key1, 1);

        assert map.get(key2) == null;
    }

    @Test
    public void equalsHashTest() {
        MyHashMap<SimpleHashClass, Integer> map = new MyHashMap<>();
        SimpleHashClass key1 = new SimpleHashClass();
        SimpleHashClass key2 = new SimpleHashClass();

        map.put(key1, 1);
        map.put(key2, 2);

        map.remove(key1);
        assert map.size() == 1;

        Assert.assertNull(map.remove(key1));
    }

    @Test
    public void equalsHashTest1() {
        MyHashMap<SimpleHashClass, Integer> map = new MyHashMap<>();
        SimpleHashClass key1 = new SimpleHashClass();
        SimpleHashClass key2 = new SimpleHashClass();

        map.put(key1, 1);
        map.put(key2, 2);

        assert map.get(key2) == 2;
        assert map.get(key1) == 1;

        map.remove(key1);
        assert map.size() == 1;

        map.remove(key2);
        assert map.size() == 0;
    }
}

