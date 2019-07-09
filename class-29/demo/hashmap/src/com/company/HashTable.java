package com.company;

import java.util.List;

public class HashTable {

    private Node[] map;

    public HashTable(int size) {
        map = new Node[size];
    }

    private int hash(String key) {
        int hashValue = 0;
        char[] letters = key.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            hashValue += letters[i];
        }
        hashValue = (hashValue * 599) % map.length;
        return hashValue;
    }

    public void set(String key, String value) {
        int hashkey = hash(key);

        if (this.map[hashkey] == null) {
            map[hashkey] = new Node(key,value);
        }
        else {
            Node temp = map[hashkey];
            map[hashkey] = new Node(key,value);
            map[hashkey].setNext(temp);
        }


    }
}
