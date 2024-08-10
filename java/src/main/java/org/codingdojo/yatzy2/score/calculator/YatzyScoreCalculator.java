package org.codingdojo.yatzy2.score.calculator;

import java.util.Map;

public class YatzyScoreCalculator {

    private YatzyScoreCalculator() {
    }

    public static int compute(Map<Integer, Integer> diceFrequencies) {
        if (diceFrequencies.containsValue(5)) {
            return 50;
        }

        return 0;
    }

}
