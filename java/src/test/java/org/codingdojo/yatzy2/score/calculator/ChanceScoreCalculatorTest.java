package org.codingdojo.yatzy2.score.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChanceScoreCalculatorTest {

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbers")
    void chance_scores_sum_of_all_dices(List<Integer> dice, int expectedScore) {
        assertEquals(expectedScore, ChanceScoreCalculator.compute(dice));
    }

    private static Stream<Arguments> provideDiceNumbers() {
        return Stream.of(
            Arguments.of(List.of(2, 3, 4, 5, 1), 15),
            Arguments.of(List.of(3, 3, 4, 5, 1), 16));
    }

}
