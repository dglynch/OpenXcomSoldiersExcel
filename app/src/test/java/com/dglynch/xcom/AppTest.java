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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AppTest {
    @TempDir
    File tempDir;

    private static final String[] ZERO_ARGUMENTS = {};
    private static final String[] ONE_ARGUMENT = {"filename.sav"};
    private static final String[] INVALID_INPUT_FILE_NAME = {"src/test/resources/invalid.sav", "filename.xlsx"};

    @Test
    void mainThrowsExceptionWhenZeroArguments() {
        assertThrows(IllegalArgumentException.class, () -> App.main(ZERO_ARGUMENTS));
    }

    @Test
    void mainThrowsExceptionWhenOneArgument() {
        assertThrows(IllegalArgumentException.class, () -> App.main(ONE_ARGUMENT));
    }

    @Test
    void mainDoesNotThrowExceptionWhenTwoValidArguments() {
        String[] twoValidArguments = {"src/test/resources/filename.sav", tempDir.getPath() + "/filename.xlsx"};
        assertDoesNotThrow(() -> App.main(twoValidArguments));
    }

    @Test
    void mainThrowsExceptionWhenInvalidInputFileName() {
        assertThrows(FileNotFoundException.class, () -> App.main(INVALID_INPUT_FILE_NAME));
    }
}
