package com.gmail.egorovsonalexey.lesson3;

import java.util.*;

class MyHashMap<K, V> implements Map<K, V> {

    private MyLinkedList<K, V>[] data;
    private int count = 0;

    MyHashMap() {
        int dataSize = (int)Math.pow(2, 16);
        data = new MyLinkedList[dataSize];
    }

    @Override
    public V put(K key, V value) {

        if(key == null) {
            throw new IllegalArgumentException("Key mast be not null.");
        }

        int hash = key.hashCode();
        int index = hash >>> 16;
        if(data[index] == null) {
            data[index] = new MyLinkedList<>();
        }
        MyLinkedList<K, V> bucket = data[index];
        MyLinkedList<K, V>.MyLinkedListItem item = bucket.search(key);
        if(item == null) {
            bucket.append(key, value);
            count++;
            return null;
        }
        else {
            V ret = item.getValue();
            item.setValue(value);
            return ret;
        }
    }

    @Override
    public V remove(Object key) {
        if(key == null) {
            throw new IllegalArgumentException("Key mast be not null.");
        }

        MyLinkedList<K, V> bucket = getBucket(key);
        if(bucket != null) {
            V res = bucket.remove(key);
            if(res != null) {
                count--;
            }
            return res;
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

        if(m == null) {
            return;
        }

        Set<? extends K> keys = m.keySet();
        for(K key : keys) {
            V value = m.get(key);
            put(key, value);
        }
    }

    @Override
    public void clear() {
        Arrays.fill(data, null);
        count = 0;
    }

    @Override
    public Set<K> keySet() {
        HashSet<K> set = new HashSet<>();
        for(MyLinkedList<K, V> bucket : data) {
            if(bucket != null) {
                bucket.keyCopy(set);
            }
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> list = new ArrayList<>();
        for(MyLinkedList<K, V> bucket : data) {
            if(bucket != null) {
                bucket.valueCopy(list);
            }
        }
        return list;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        HashSet<HashMap.Entry<K, V>> set = new HashSet<>();
        for(MyLinkedList<K, V> bucket : data) {
            if(bucket != null) {
                bucket.entryCopy(set);
            }
        }
        return set;
    }

    @Override
    public V get(Object key) {

        if(key == null) {
            throw new IllegalArgumentException("Key mast be not null.");
        }

        MyLinkedList<K, V> bucket = getBucket(key);
        if(bucket != null) {
            MyLinkedList<K, V>.MyLinkedListItem item = bucket.search(key);
            if (item != null) {
                return item.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean containsKey(Object key) {

        if(key == null) {
            throw new IllegalArgumentException("Key mast be not null.");
        }

        MyLinkedList<K, V> bucket = getBucket(key);
        if(bucket != null) {
            MyLinkedList<K, V>.MyLinkedListItem item = bucket.search(key);
            if(item != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {

        if (value == null) {
            throw new IllegalArgumentException("Key has a wrong type.");
        }

        for (MyLinkedList<K, V> bucket : data) {
            if (bucket != null && bucket.searchValue(value)) {
                return true;
            }
        }
        return false;
    }

    private MyLinkedList<K, V> getBucket(Object key) {

        if(key == null) {
            throw new IllegalArgumentException("Key mast be not null.");
        }

        int hash = key.hashCode();
        int index = hash >>> 16;
        return data[index];
    }
}


