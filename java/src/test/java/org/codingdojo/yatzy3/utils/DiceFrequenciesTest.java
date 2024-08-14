package org.codingdojo.yatzy3.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiceFrequenciesTest {

    @ParameterizedTest(name = "Expect frequencies {0} for dice {1}")
    @MethodSource("provideDiceNumbers")
    void should_get_frequencies(Map<Integer, Integer> expectedFrequencies, List<Integer> dice) {
        DiceFrequencies diceFrequencies = new DiceFrequencies();

        assertEquals(expectedFrequencies, diceFrequencies.frequencies(dice));
    }

    private static Stream<Arguments> provideDiceNumbers() {
        return Stream.of(
            Arguments.of(Map.of(6, 1, 5, 1, 4, 1, 3, 1, 2, 1, 1, 1), List.of(6, 5, 4, 3, 2, 1)),
            Arguments.of(Map.of(1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1), List.of(1, 2, 3, 4, 5, 6)),
            Arguments.of(Map.of(6, 0, 5, 0, 4, 5, 3, 0, 2, 0, 1, 0), List.of(4, 4, 4, 4, 4)),
            Arguments.of(Map.of(6, 5, 5, 0, 4, 0, 3, 0, 2, 0, 1, 0), List.of(6, 6, 6, 6, 6)),
            Arguments.of(Map.of(6, 4, 5, 0, 4, 0, 3, 1, 2, 0, 1, 0), List.of(6, 6, 6, 6, 3)));
    }

}
