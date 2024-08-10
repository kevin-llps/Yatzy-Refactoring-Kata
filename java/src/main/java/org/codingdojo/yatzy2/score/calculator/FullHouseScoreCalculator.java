package org.codingdojo.yatzy2.score.calculator;

import java.util.List;
import java.util.Map;

public class FullHouseScoreCalculator {

    private FullHouseScoreCalculator() {
    }

    public static int compute(List<Integer> dice, Map<Integer, Integer> diceFrequencies) {
        if (diceFrequencies.containsValue(2) && diceFrequencies.containsValue(3)) {
            return dice
                .stream()
                .reduce(0, Integer::sum);
        }

        return 0;
    }

}
