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
