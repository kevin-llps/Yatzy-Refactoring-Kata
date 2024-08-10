package org.codingdojo.yatzy2.score.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StraightScoreCalculatorTest {

    @ParameterizedTest(name = "Expect score {2} for dice {0} and frequencies {1}")
    @MethodSource("provideDiceAndDiceFrequencies")
    void straight_compute_score(int firstDiceStraight, List<Integer> dice, Map<Integer, Integer> diceFrequencies, int expectedScore) {
        assertEquals(expectedScore, StraightScoreCalculator.compute(firstDiceStraight, dice, diceFrequencies));
    }

    private static Stream<Arguments> provideDiceAndDiceFrequencies() {
        return Stream.of(
            Arguments.of(6, List.of(1, 2, 3, 4, 5), Map.of(6, 0, 5, 1, 4, 1, 3, 1, 2, 1, 1, 1), 15),
            Arguments.of(6, List.of(2, 3, 4, 5, 1), Map.of(6, 0, 5, 1, 4, 1, 3, 1, 2, 1, 1, 1), 15),
            Arguments.of(6, List.of(1, 2, 2, 4, 5), Map.of(6, 0, 5, 1, 4, 1, 3, 0, 2, 2, 1, 1), 0),
            Arguments.of(1, List.of(6, 2, 3, 4, 5), Map.of(6, 1, 5, 1, 4, 1, 3, 1, 2, 1, 1, 0), 20),
            Arguments.of(1, List.of(2, 3, 4, 5, 6), Map.of(6, 1, 5, 1, 4, 1, 3, 1, 2, 1, 1, 0), 20),
            Arguments.of(1, List.of(1, 2, 2, 4, 5), Map.of(6, 0, 5, 1, 4, 1, 3, 0, 2, 2, 1, 1), 0));
    }

}
