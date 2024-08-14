package org.codingdojo.yatzy3.scorer;

import org.codingdojo.yatzy3.utils.DiceFrequencies;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public record RepeatedCountScorer(int count, DiceFrequencies diceFrequencies) implements CategoryScorer {

    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Integer> frequencies = diceFrequencies.frequencies(dice);
        for (int i : Arrays.asList(6, 5, 4, 3, 2, 1)) {
            if (frequencies.get(i) >= count) {
                return i * count;
            }
        }
        return 0;
    }
}
