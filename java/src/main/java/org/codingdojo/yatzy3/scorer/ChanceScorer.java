package org.codingdojo.yatzy3.scorer;

import org.codingdojo.yatzy3.utils.DiceUtils;

import java.util.List;

public record ChanceScorer(DiceUtils diceUtils) implements CategoryScorer {

    @Override
    public int calculateScore(List<Integer> dice) {
        return diceUtils.sum(dice);
    }
}
