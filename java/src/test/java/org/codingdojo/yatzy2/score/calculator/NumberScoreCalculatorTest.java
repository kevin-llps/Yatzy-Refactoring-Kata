package org.codingdojo.yatzy2.score.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberScoreCalculatorTest {

    @ParameterizedTest(name = "Expect score {2} for number {0} dice frequencies {1}")
    @MethodSource("provideNumberAndDiceFrequencies")
    void given_number_to_sum_compute_score(int number, Map<Integer, Integer> diceFrequencies, int expectedScore) {
        assertEquals(expectedScore, NumberScoreCalculator.compute(number, diceFrequencies));
    }

    private static Stream<Arguments> provideNumberAndDiceFrequencies() {
        return Stream.of(
            Arguments.of(1, Map.of(6, 0, 5, 1, 4, 1, 3, 1, 2, 1, 1, 1), 1),
            Arguments.of(1, Map.of(6, 0, 5, 1, 4, 1, 3, 0, 2, 1, 1, 2), 2),
            Arguments.of(1, Map.of(6, 1, 5, 1, 4, 1, 3, 0, 2, 2, 1, 0), 0),
            Arguments.of(1, Map.of(6, 0, 5, 0, 4, 0, 3, 0, 2, 2, 1, 4), 4),
            Arguments.of(2, Map.of(6, 1, 5, 0, 4, 0, 3, 1, 2, 2, 1, 1), 4),
            Arguments.of(2, Map.of(6, 0, 5, 0, 4, 0, 3, 0, 2, 5, 1, 0), 10),
            Arguments.of(3, Map.of(6, 0, 5, 0, 4, 0, 3, 2, 2, 2, 1, 1), 6),
            Arguments.of(3, Map.of(6, 0, 5, 0, 4, 0, 3, 4, 2, 1, 1, 0), 12),
            Arguments.of(4, Map.of(6, 0, 5, 2, 4, 3, 3, 0, 2, 0, 1, 0), 12),
            Arguments.of(4, Map.of(6, 0, 5, 3, 4, 2, 3, 0, 2, 0, 1, 0), 8),
            Arguments.of(4, Map.of(6, 0, 5, 4, 4, 1, 3, 0, 2, 0, 1, 0), 4),
            Arguments.of(5, Map.of(6, 0, 5, 2, 4, 3, 3, 0, 2, 0, 1, 0), 10),
            Arguments.of(5, Map.of(6, 0, 5, 3, 4, 2, 3, 0, 2, 0, 1, 0), 15),
            Arguments.of(5, Map.of(6, 0, 5, 4, 4, 1, 3, 0, 2, 0, 1, 0), 20),
            Arguments.of(6, Map.of(6, 0, 5, 2, 4, 3, 3, 0, 2, 0, 1, 0), 0),
            Arguments.of(6, Map.of(6, 1, 5, 2, 4, 2, 3, 0, 2, 0, 1, 0), 6),
            Arguments.of(6, Map.of(6, 3, 5, 2, 4, 0, 3, 0, 2, 0, 1, 0), 18));
    }

}
