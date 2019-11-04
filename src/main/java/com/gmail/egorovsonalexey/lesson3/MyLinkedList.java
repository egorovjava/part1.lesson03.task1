package com.gmail.egorovsonalexey.lesson3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class MyLinkedList<K, V> {

    private MyLinkedList<K, V>.MyLinkedListItem tail;

    void append(K k, V v) {
        MyLinkedListItem item = new MyLinkedListItem(k, v);
        if(tail != null) {
            tail.next = item;
            item.previous = tail;
        }
        tail = item;
    }

    V remove(Object o) {
        MyLinkedListItem searched = tail;
        while(searched != null && !searched.key.equals(o)) {
            searched = searched.previous;
        }

        if(searched != null) {

            if(searched.previous != null) {
                searched.previous.next = searched.next;
            }

            if(searched.next != null) {
                searched.next.previous = searched.previous;
            }
            else {
                tail = searched.previous;
            }
            return searched.value;
        }
        else {
            return null;
        }
    }

    MyLinkedList<K, V>.MyLinkedListItem search(Object key) {
        MyLinkedList<K, V>.MyLinkedListItem searched = tail;
        while(searched != null && !searched.key.equals(key)) {
            searched = searched.previous;
        }

        return searched;
    }

    boolean searchValue(Object value) {
        MyLinkedListItem searched = tail;
        while(searched != null) {
            if(searched.value.equals(value)) {
                return true;
            }
            searched = searched.previous;
        }
        return false;
    }

    void push(K key) {
        MyLinkedListItem item = new MyLinkedListItem(key, null);
        if(tail != null) {
            tail.next = item;
        }
        item.previous = tail;
        tail = item;
    }

    K pop() {
        if(tail != null) {
            K ret = tail.key;
            if(tail.previous != null) {
                tail.previous.next = null;
            }
            tail = tail.previous;
            return ret;
        }
        else {
            return null;
        }
    }

    boolean isEmpty() {
        return tail == null;
    }

    void keyCopy(Collection<K> list) {
        MyLinkedListItem item = tail;
        while(item != null) {
            list.add(item.key);
            item = item.previous;
        }
    }

    void valueCopy(Collection<V> list) {
        MyLinkedListItem item = tail;
        while(item != null) {
            list.add(item.value);
            item = item.previous;
        }
    }

    void entryCopy(Collection<Map.Entry<K, V>> list) {
        MyLinkedListItem item = tail;
        while(item != null) {
            list.add(new HashMap.SimpleEntry<>(item.key, item.value));
            item = item.previous;
        }
    }

    class MyLinkedListItem {

        private MyLinkedListItem next;
        private MyLinkedListItem previous;
        private K key;
        private V value;

        MyLinkedListItem(K k, V v) {
            key = k;
            value = v;
        }

        V getValue() {
            return value;
        }

        void setValue(V o) {
            value = o;
        }
    }
}
