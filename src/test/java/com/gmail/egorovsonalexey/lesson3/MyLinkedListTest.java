package com.gmail.egorovsonalexey.lesson3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    @Test
    public void myLinkedListTest() {
        MyLinkedList<Integer, Integer> myList = new MyLinkedList<>();
        for(Integer i = 0; i < 10; i++) {
            myList.append(i, 100 + i);
        }

        MyLinkedList.MyLinkedListItem item = myList.search(5);
        assert (Integer)item.getValue() == 105;

        myList.remove(5);
        item = myList.search(5);
        assertNull(item);

        myList.remove(0);
        item = myList.search(0);
        assertNull(item);

        Integer res = myList.remove(9);
        assertNotNull(res);
        item = myList.search(9);
        assertNull(item);

        res = myList.remove(9);
        assertNull(res);
    }
}
