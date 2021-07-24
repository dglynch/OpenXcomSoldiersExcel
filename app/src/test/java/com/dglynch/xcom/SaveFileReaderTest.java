package com.dglynch.xcom;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class SaveFileReaderTest {
    @Test
    void readSoldiersHasExpectedSoldier() throws IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("filename.sav")) {
            List<Soldier> soldiers = SaveFileReader.readSoldiers(inputStream);
            assertThat(soldiers, hasItem(hasProperty("name", equalTo("Lindsay Collins"))));
        }
    }

    @Test
    void readSoldiersHasExpectedSize() throws IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("filename.sav")) {
            List<Soldier> soldiers = SaveFileReader.readSoldiers(inputStream);
            assertThat(soldiers, hasSize(30));
        }
    }
}
