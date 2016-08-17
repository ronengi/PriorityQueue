package com.ronengi;

/**
 * Created by stimpy on 8/17/16.
 */
public class MinPQ<Key extends Comparable<Key>> {

        private Key[] pq;       // pq[i] = ith element on pq, starting with pq[1]
        private int N;          // number of elements on pq


        public MinPQ(int capacity) {
            pq = (Key[]) new Comparable[capacity+1];
            N = 0;
        }

        // public MinPQ(Key[] a) {}


        public void insert(Key x) {
            pq[++N] = x;
            swim(N);
        }


        public Key delMin() {
            Key min = pq[1];
            exch(1, N--);
            sink(1);
            pq[N+1] = null;
            return min;
        }


        public boolean isEmpty() {
            return N == 0;
        }


        public Key min() {
            return pq[1];
        }


        public int size() {
            return N;
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            // for (int i = 1; i <= N; i++) {
            //     sb.append(" [").append(pq[i]).append("] ");
            // }
            // sb.append("\n");


            int l = (int) (Math.log(N) / Math.log(2));
            // sb.append(l).append(" levels\n");
            int before[] = new int[l+2];
            int between[] = new int[l+2];
            int iBefore = 5;
            int iBetween = 10;
            before[l+1] = 0;
            between[l+1] = 3;
            before[l] = 2;
            between[l] = 7;
            for(int i = l-1; i > 0 ; i--) {
                before[i] = before[i+1] + iBefore;
                between[i] = between[i+1] + iBetween;
                iBefore *= 2;
                iBetween *= 2;
            }

            int oldCl = 0;
            for (int i = 1; i <=N; i++) {
                int cl = ((int) (Math.log(i) / Math.log(2))) + 1;
                if (cl > oldCl) {       // next level
                    sb.append("\n");
                    appendSpaces(sb, before[cl]);
                    oldCl = cl;
                }
                if (cl > l) {           // last level
                    sb.append("[").append(pq[i]).append("]");
                    if (i % 2 == 0)     appendSpaces(sb, 1);
                    else                appendSpaces(sb, 3);
                }
                else {
                    sb.append("[").append(pq[i]).append("]");
                    appendSpaces(sb, between[cl]);
                }
            }
            sb.append("\n");
            return sb.toString();
        }

        private void appendSpaces(StringBuilder sb, int spaces) {
            for (int i = 1; i <= spaces; i++)
                sb.append(" ");
        }


        // fix state violation where child is smaller than it's parent
        // k's parent == k/2
        private void swim(int k) {
            while (k > 1  &&  greater(k/2, k)) {
                exch(k, k/2);
                k = k/2;
            }
        }


        // fix state violation where parent is smaller than one or both it's children
        // k's children == 2*k, 2*k + 1
        private void sink(int k) {
            while (2*k <= N ) {
                // set j to be the larger of the 2 children
                int j = 2*k;
                if (j < N  &&  greater(j, j+1))
                    j++;
                if (!greater(k, j))
                    break;
                exch(k, j);
                k = j;
            }

        }


        private boolean greater(int i, int j) {
            return pq[i].compareTo(pq[j]) > 0;
        }


        private void exch(int i, int j) {
            Key tmp = pq[i];
            pq[i] = pq[j];
            pq[j] = tmp;
        }


    }
