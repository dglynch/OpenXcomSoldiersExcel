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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class SoldierTest {
    @Test
    void getPromotionScoreWithPsiTraining() {
        Soldier soldier = new Soldier(0, "John Doe", "Some Bbase", "Squaddie", 4, 3,
                0, false, 50, 49, 48, 40, 51, 52, 53,
                57, 54, 55, 56);
        assertThat(soldier.getPromotionScore(), is(equalTo(1421)));
    }

    @Test
    void getPromotionScoreWithoutPsiTraining() {
        Soldier soldier = new Soldier(0, "John Doe", "Some Bbase", "Squaddie", 4, 3,
                0, false, 50, 49, 48, 40, 51, 52, 53,
                57, 54, 55, 0);
        assertThat(soldier.getPromotionScore(), is(equalTo(1254)));
    }
}
