package com.ronengi;

/**
 * Created by stimpy on 8/14/16.
 *
 * 1. Unordered fixed-size array implementation
 *
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;       // pq[i] = ith element on pq
    private int N;          // number of elements on pq


    public MaxPQ() {
        int capacity = 100;
        pq = (Key[]) new Comparable[capacity];
    }

    // public MaxPQ(Key[] a) {}


    void insert(Key x) {
        pq[N++] = x;
    }


    Key delMax() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (less(max, i))
                max = i;
        }
        exch(max, N-1);
        return pq[--N];
    }


    boolean isEmpty() {
        return N == 0;
    }


    Key max() { return null; }

    int size() { return 0; }


}
