package org.codingdojo.yatzy2.score.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DuplicatedDiceNumberScoreCalculatorTest {

    @ParameterizedTest(name = "Expect score {1} for dice frequencies {0}")
    @MethodSource("provideDiceFrequencies")
    void given_duplicated_dice_number_compute_score(int duplicatedDiceNumber, Map<Integer, Integer> diceFrequencies, int expectedScore) {
        assertEquals(expectedScore, DuplicatedDiceNumberScoreCalculator.compute(duplicatedDiceNumber, diceFrequencies));
    }

    private static Stream<Arguments> provideDiceFrequencies() {
        return Stream.of(
            Arguments.of(4, Map.of(6, 0, 5, 1, 4, 0, 3, 4, 2, 0, 1, 0), 12),
            Arguments.of(4, Map.of(6, 0, 5, 4, 4, 1, 3, 0, 2, 0, 1, 0), 20),
            Arguments.of(4, Map.of(6, 0, 5, 0, 4, 0, 3, 5, 2, 0, 1, 0), 12),
            Arguments.of(3, Map.of(6, 0, 5, 1, 4, 1, 3, 3, 2, 0, 1, 0), 9),
            Arguments.of(3, Map.of(6, 0, 5, 3, 4, 1, 3, 1, 2, 0, 1, 0), 15),
            Arguments.of(3, Map.of(6, 0, 5, 1, 4, 0, 3, 4, 2, 0, 1, 0), 9),
            Arguments.of(2, Map.of(6, 1, 5, 1, 4, 1, 3, 2, 2, 0, 1, 0), 6),
            Arguments.of(2, Map.of(6, 0, 5, 2, 4, 0, 3, 3, 2, 0, 1, 0), 10),
            Arguments.of(2, Map.of(6, 2, 5, 2, 4, 0, 3, 1, 2, 0, 1, 0), 12),
            Arguments.of(2, Map.of(6, 0, 5, 1, 4, 1, 3, 1, 2, 1, 1, 1), 0));
    }

}
