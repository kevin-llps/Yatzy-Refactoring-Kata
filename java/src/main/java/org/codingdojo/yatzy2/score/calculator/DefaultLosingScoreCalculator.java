package org.codingdojo.yatzy2.score.calculator;

import java.util.List;
import java.util.Map;

public class DefaultLosingScoreCalculator implements ScoreCalculator {

    @Override
    public int compute(List<Integer> dice, Map<Integer, Integer> diceFrequencies) {
        return 0;
    }

}
