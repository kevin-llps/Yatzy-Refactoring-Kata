package org.codingdojo.yatzy2.score.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FullHouseScoreCalculatorTest {

    @ParameterizedTest(name = "Expect score {2} for dice {0} and frequencies {1}")
    @MethodSource("provideDiceAndDiceFrequencies")
    void full_house_compute_score(List<Integer> dice, Map<Integer, Integer> diceFrequencies, int expectedScore) {
        assertEquals(expectedScore, FullHouseScoreCalculator.compute(dice, diceFrequencies));
    }

    private static Stream<Arguments> provideDiceAndDiceFrequencies() {
        return Stream.of(
            Arguments.of(
                List.of(6, 2, 2, 2, 6),
                Map.of(6, 2, 5, 0, 4, 0, 3, 0, 2, 3, 1, 0),
                18),
            Arguments.of(
                List.of(2, 3, 4, 5, 6),
                Map.of(6, 1, 5, 1, 4, 1, 3, 1, 2, 1, 1, 1),
                0));
    }

}
