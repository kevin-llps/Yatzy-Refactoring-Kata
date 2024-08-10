package org.codingdojo.yatzy2.score.calculator;

import java.util.Map;

import static org.codingdojo.yatzy2.Yatzy2.DICE_VALUES;

public class DuplicatedDiceNumberScoreCalculator {

    private DuplicatedDiceNumberScoreCalculator() {
    }

    public static int compute(int duplicationCount, Map<Integer, Integer> diceFrequencies) {
        return DICE_VALUES.stream()
            .filter(i -> diceFrequencies.get(i) >= duplicationCount)
            .map(i -> i * duplicationCount)
            .findAny()
            .orElse(0);
    }

}
