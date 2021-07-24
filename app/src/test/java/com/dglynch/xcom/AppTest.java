package com.dglynch.xcom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AppTest {
    private static final String[] ZERO_ARGUMENTS = {};
    private static final String[] ONE_ARGUMENT = {"filename.sav"};
    private static final String[] TWO_ARGUMENTS = {"filename.sav", "filename.xlsx"};

    @Test
    void mainThrowsExceptionWhenZeroArguments() {
        assertThrows(IllegalArgumentException.class, () -> App.main(ZERO_ARGUMENTS));
    }

    @Test
    void mainThrowsExceptionWhenOneArgument() {
        assertThrows(IllegalArgumentException.class, () -> App.main(ONE_ARGUMENT));
    }

    @Test
    void mainDoesNotThrowExceptionWhenTwoArguments() {
        assertDoesNotThrow(() -> App.main(TWO_ARGUMENTS));
    }
}
