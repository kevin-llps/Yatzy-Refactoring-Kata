package org.codingdojo.yatzy3.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiceUtilsTest {

    @Test
    void should_sum_all_dice() {
        List<Integer> dice = List.of(2, 3, 4, 5, 1);
        int expectedScore = 15;

        DiceUtils diceUtils = new DiceUtils();

        assertEquals(expectedScore, diceUtils.sum(dice));
    }

}
