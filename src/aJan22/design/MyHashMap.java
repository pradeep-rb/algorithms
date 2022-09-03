package aJan22.design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashMap {
 int keySpace = 2069;
     List<Bucket> hashTable = new ArrayList<>(keySpace);

     class Pair {
         public int key;
         public int value;

         public  Pair(int key, int value) {
             this.key = key;
             this.value = value;
         }
     }

     class Bucket {
         List<Pair>  bEntries;

         public  Bucket() {
             bEntries = new LinkedList<>();
         }

         public Pair getEntry(int key) {
             for(Pair pair: bEntries) {
                 if(key  == pair.key) {
                     return pair;
                 }
             }

             return null;
         }

         public void putValue(int key, int value) {
             Pair pair = getEntry(key);
             if(pair != null) {
                 pair.value = value;
             }
             else {
                 bEntries.add(new Pair(key, value));
             }
         }

         public int getValue(int key) {
             Pair pair = getEntry(key);
             return  pair != null ? pair.value : -1;

         }

         public void removeValue(int key) {
             Pair pair = getEntry(key);
             if(pair != null) {
                 bEntries.remove(pair);
             }
         }

     }

     private  Bucket getBucket(int key) {
         return  hashTable.get( key % keySpace);
     }



    /** Initialize your data structure here. */
    public MyHashMap() {
        for (int i = 0; i < keySpace; i++) {
            hashTable.add( new Bucket());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        getBucket(key).putValue(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return  getBucket(key).getValue(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        getBucket(key).removeValue(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */