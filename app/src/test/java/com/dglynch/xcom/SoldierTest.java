package com.dglynch.xcom;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class SoldierTest {
    @Test
    void getPromotionScoreWithPsiTraining() {
        Soldier soldier = new Soldier(0, "John Doe", "Some Bbase", "Squaddie", 50,
                49, 48, 40, 51, 52, 53, 54, 55,
                56, 57, 4, 3);
        assertThat(soldier.getPromotionScore(), is(equalTo(1421)));
    }

    @Test
    void getPromotionScoreWithoutPsiTraining() {
        Soldier soldier = new Soldier(0, "John Doe", "Some Bbase", "Squaddie", 50,
                49, 48, 40, 51, 52, 53, 54, 55,
                0, 57, 4, 3);
        assertThat(soldier.getPromotionScore(), is(equalTo(1254)));
    }
}
