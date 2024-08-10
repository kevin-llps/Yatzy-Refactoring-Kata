package org.codingdojo.yatzy2.score.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyScoreCalculatorTest {

    @ParameterizedTest(name = "Expect score {1} for dice frequencies {0}")
    @MethodSource("provideDiceFrequencies")
    void given_dice_frequencies_yatzy_compute_score(Map<Integer, Integer> diceFrequencies, int expectedScore) {
        assertEquals(expectedScore, YatzyScoreCalculator.compute(diceFrequencies));
    }

    private static Stream<Arguments> provideDiceFrequencies() {
        return Stream.of(
            Arguments.of(Map.of(6, 0, 5, 0, 4, 5, 3, 0, 2, 0, 1, 0), 50),
            Arguments.of(Map.of(6, 5, 5, 0, 4, 0, 3, 0, 2, 0, 1, 0), 50),
            Arguments.of(Map.of(6, 4, 5, 0, 4, 0, 3, 1, 2, 0, 1, 0), 0));
    }

}
