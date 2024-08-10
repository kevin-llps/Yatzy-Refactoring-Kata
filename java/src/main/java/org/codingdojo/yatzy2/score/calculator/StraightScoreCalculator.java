package org.codingdojo.yatzy2.score.calculator;

import java.util.List;
import java.util.Map;

public class StraightScoreCalculator {

    private StraightScoreCalculator() {
    }

    public static int compute(int firstDiceStraight, List<Integer> dice, Map<Integer, Integer> diceFrequencies) {
        if (hasStraight(diceFrequencies) && diceFrequencies.get(firstDiceStraight) == 0) {
            return dice
                .stream()
                .reduce(0, Integer::sum);
        }

        return 0;
    }

    private static boolean hasStraight(Map<Integer, Integer> diceFrequencies) {
        return diceFrequencies.values()
            .stream()
            .filter(frequency -> frequency == 1)
            .count() == 5;
    }

}
