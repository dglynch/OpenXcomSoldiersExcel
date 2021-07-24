/*
    Copyright 2021 Dan Lynch

    This file is part of OpenXcom Soldiers Excel.

    OpenXcom Soldiers Excel is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by the Free
    Software Foundation, either version 3 of the License, or (at your option) any
    later version.

    This program is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
    FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
    details.

    You should have received a copy of the GNU General Public License along with
    this program; if not, see <http://www.gnu.org/licenses>.
*/

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
