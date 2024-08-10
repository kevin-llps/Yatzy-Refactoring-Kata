package org.codingdojo.yatzy2.score.calculator;

import java.util.Map;

public class NumberScoreCalculator {

    private NumberScoreCalculator() {
    }

    public static int compute(Integer number, Map<Integer, Integer> diceFrequencies) {
        return diceFrequencies.get(number) * number;
    }

}
