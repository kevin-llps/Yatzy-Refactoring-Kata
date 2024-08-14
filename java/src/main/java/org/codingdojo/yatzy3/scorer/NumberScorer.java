package org.codingdojo.yatzy3.scorer;

import org.codingdojo.yatzy3.utils.DiceFrequencies;

import java.util.List;

public record NumberScorer(int number, DiceFrequencies diceFrequencies) implements CategoryScorer {

    @Override
    public int calculateScore(List<Integer> dice) {
        return diceFrequencies.frequencies(dice).get(number) * number;
    }
}
