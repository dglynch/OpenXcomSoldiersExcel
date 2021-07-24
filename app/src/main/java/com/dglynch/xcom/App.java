package com.dglynch.xcom;

public class App {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("arguments should be input and output file names");
        }
    }
}
