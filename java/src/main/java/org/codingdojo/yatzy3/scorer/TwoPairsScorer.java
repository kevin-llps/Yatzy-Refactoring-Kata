package org.codingdojo.yatzy3.scorer;

import org.codingdojo.yatzy3.utils.DiceFrequencies;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public record TwoPairsScorer(DiceFrequencies diceFrequencies) implements CategoryScorer {
    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Integer> frequencies = diceFrequencies.frequencies(dice);
        int score = 0;
        if (frequencies.values().stream().filter(f -> f >= 2).toList().size() == 2) {
            score = Stream.of(6, 5, 4, 3, 2, 1)
                .mapToInt(i -> i)
                .filter(i -> frequencies.get(i) >= 2)
                .map(i -> i * 2)
                .sum();
        }
        return score;
    }
}
