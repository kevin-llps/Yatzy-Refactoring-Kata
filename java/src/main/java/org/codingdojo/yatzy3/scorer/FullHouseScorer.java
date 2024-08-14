package org.codingdojo.yatzy3.scorer;

import org.codingdojo.yatzy3.utils.DiceFrequencies;
import org.codingdojo.yatzy3.utils.DiceUtils;

import java.util.List;
import java.util.Map;

public record FullHouseScorer(DiceUtils diceUtils, DiceFrequencies diceFrequencies) implements CategoryScorer {
    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Integer> frequencies = diceFrequencies.frequencies(dice);

        if (frequencies.containsValue(2) && frequencies.containsValue(3)) {
            return diceUtils.sum(dice);
        }

        return 0;
    }
}
