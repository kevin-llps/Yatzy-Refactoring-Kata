package org.codingdojo.yatzy2.score.calculator;

import java.util.List;

public class ChanceScoreCalculator {

    private ChanceScoreCalculator() {
    }

    public static int compute(List<Integer> dice) {
        return dice.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

}
