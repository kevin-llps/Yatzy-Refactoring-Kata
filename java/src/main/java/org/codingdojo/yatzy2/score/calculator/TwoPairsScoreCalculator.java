package org.codingdojo.yatzy2.score.calculator;

import java.util.Map;

import static org.codingdojo.yatzy2.Yatzy2.DICE_VALUES;

public class TwoPairsScoreCalculator {

    private TwoPairsScoreCalculator() {
    }

    public static int compute(Map<Integer, Integer> diceFrequencies) {
        long pairCount = getPairCount(diceFrequencies);

        if (pairCount == 2) {
            return DICE_VALUES.stream()
                .filter(i -> diceFrequencies.get(i) >= 2)
                .map(i -> i * 2)
                .reduce(0, Integer::sum);
        }

        return 0;
    }

    private static long getPairCount(Map<Integer, Integer> diceFrequencies) {
        return diceFrequencies.values()
            .stream()
            .filter(frequency -> frequency >= 2)
            .count();
    }

}
