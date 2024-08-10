package org.codingdojo.yatzy2.score.calculator;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultLosingScoreCalculatorTest {

    @Test
    void should_get_default_losing_score() {
        DefaultLosingScoreCalculator defaultLosingScoreCalculator = new DefaultLosingScoreCalculator();

        int actualScore = defaultLosingScoreCalculator.compute(Collections.emptyList(), Collections.emptyMap());

        assertEquals(0, actualScore);
    }

}
