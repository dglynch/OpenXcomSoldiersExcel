package com.dglynch.xcom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("arguments should be input and output file names");
        }
        String inputFileName = args[0];
        String outputFileName = args[1];
        InputStream inputStream = new FileInputStream(inputFileName);
    }
}
