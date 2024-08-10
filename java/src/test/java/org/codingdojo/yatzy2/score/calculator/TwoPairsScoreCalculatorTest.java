package org.codingdojo.yatzy2.score.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoPairsScoreCalculatorTest {

    @ParameterizedTest(name = "Expect score {1} for dice frequencies {0}")
    @MethodSource("provideDiceFrequencies")
    void two_pairs_compute_score(Map<Integer, Integer> diceFrequencies, int expectedScore) {
        assertEquals(expectedScore, TwoPairsScoreCalculator.compute(diceFrequencies));
    }

    private static Stream<Arguments> provideDiceFrequencies() {
        return Stream.of(
            Arguments.of(Map.of(6, 0, 5, 2, 4, 1, 3, 2, 2, 0, 1, 0), 16),
            Arguments.of(Map.of(6, 0, 5, 3, 4, 0, 3, 2, 2, 0, 1, 0), 16),
            Arguments.of(Map.of(6, 0, 5, 1, 4, 0, 3, 2, 2, 0, 1, 0), 0));
    }

}
