package org.codingdojo.yatzy3.scorer;

import org.codingdojo.yatzy3.utils.DiceFrequencies;

import java.util.List;

public record YatzyPointsScorer(DiceFrequencies diceFrequencies) implements CategoryScorer {
    @Override
    public int calculateScore(List<Integer> dice) {
        if (diceFrequencies.frequencies(dice).containsValue(5)) {
            return 50;
        }
        return 0;
    }
}
