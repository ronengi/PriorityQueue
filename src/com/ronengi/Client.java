package com.ronengi;

/**
 * Created by stimpy on 8/14/16.
 */
public class Client {

    public static void main(String[] args) {
        MaxPQ<String> mpq = new MaxPQ<>(50);
        mpq.insert("T");
        mpq.insert("H");
        mpq.insert("I");
        mpq.insert("S");
        mpq.insert("I");
        mpq.insert("S");
        mpq.insert("A");
        mpq.insert("P");
        mpq.insert("R");
        mpq.insert("I");
        mpq.insert("O");
        mpq.insert("R");
        mpq.insert("I");
        mpq.insert("T");
        mpq.insert("Y");
        mpq.insert("Q");
        mpq.insert("U");
        mpq.insert("E");
        mpq.insert("U");
        mpq.insert("E");

        mpq.insert("O");
        mpq.insert("N");
        mpq.insert("E");
        mpq.insert("M");
        mpq.insert("O");
        mpq.insert("R");
        mpq.insert("E");
        mpq.insert("L");
        mpq.insert("E");
        mpq.insert("V");
        mpq.insert("E");
        mpq.insert("L");

        System.out.println(mpq);
    }

}
