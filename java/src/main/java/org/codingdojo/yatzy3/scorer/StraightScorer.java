package org.codingdojo.yatzy3.scorer;

import org.codingdojo.yatzy3.utils.DiceFrequencies;
import org.codingdojo.yatzy3.utils.DiceUtils;

import java.util.List;
import java.util.Map;

public record StraightScorer(int straightIncludes,
                             DiceUtils diceUtils,
                             DiceFrequencies diceFrequencies) implements CategoryScorer {

    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Integer> frequencies = diceFrequencies.frequencies(dice);

        if (isStraight(frequencies) && frequencies.get(straightIncludes) != 0) {
            return diceUtils.sum(dice);
        }
        return 0;
    }

    private boolean isStraight(Map<Integer, Integer> frequencies) {
        return frequencies.values().stream().filter(f -> f == 1).toList().size() == 5;
    }

}
