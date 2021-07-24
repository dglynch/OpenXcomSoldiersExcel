package com.dglynch.xcom;

import java.io.*;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("arguments should be input and output file names");
        }
        String inputFileName = args[0];
        String outputFileName = args[1];
        List<Soldier> soldiers;
        try (InputStream inputStream = new FileInputStream(inputFileName)) {
            soldiers = SaveFileReader.readSoldiers(inputStream);
        }
        try (OutputStream outputStream = new FileOutputStream(outputFileName)) {
            ExcelFileWriter.writeSoldiers(soldiers, outputStream);
        }
    }
}
