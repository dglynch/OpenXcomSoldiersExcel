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
