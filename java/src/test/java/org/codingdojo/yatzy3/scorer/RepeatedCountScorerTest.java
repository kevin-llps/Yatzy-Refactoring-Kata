package org.codingdojo.yatzy3.scorer;

import org.codingdojo.yatzy3.scorer.RepeatedCountScorer;
import org.codingdojo.yatzy3.utils.DiceFrequencies;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RepeatedCountScorerTest {

    @ParameterizedTest(name = "Expect score {3} for count {0} and dice {1}")
    @MethodSource("provideRepeatedCountAndDiceFrequencies")
    void given_repeated_count_compute_score(int count, List<Integer> dice, Map<Integer, Integer> frequencies, int expectedScore) {
        DiceFrequencies diceFrequencies = mock(DiceFrequencies.class);

        RepeatedCountScorer repeatedCountScorer = new RepeatedCountScorer(count, diceFrequencies);

        when(diceFrequencies.frequencies(dice)).thenReturn(frequencies);

        assertEquals(expectedScore, repeatedCountScorer.calculateScore(dice));

        verify(diceFrequencies).frequencies(dice);
        verifyNoMoreInteractions(diceFrequencies);
    }

    private static Stream<Arguments> provideRepeatedCountAndDiceFrequencies() {
        return Stream.of(
            Arguments.of(4, List.of(3, 3, 3, 3, 5), Map.of(6, 0, 5, 1, 4, 0, 3, 4, 2, 0, 1, 0), 12),
            Arguments.of(4, List.of(5, 5, 5, 4, 5), Map.of(6, 0, 5, 4, 4, 1, 3, 0, 2, 0, 1, 0), 20),
            Arguments.of(4, List.of(3, 3, 3, 3, 3), Map.of(6, 0, 5, 0, 4, 0, 3, 5, 2, 0, 1, 0), 12),
            Arguments.of(3, List.of(3, 3, 3, 4, 5), Map.of(6, 0, 5, 1, 4, 1, 3, 3, 2, 0, 1, 0), 9),
            Arguments.of(3, List.of(5, 3, 5, 4, 5), Map.of(6, 0, 5, 3, 4, 1, 3, 1, 2, 0, 1, 0), 15),
            Arguments.of(3, List.of(3, 3, 3, 3, 5), Map.of(6, 0, 5, 1, 4, 0, 3, 4, 2, 0, 1, 0), 9),
            Arguments.of(2, List.of(3, 4, 3, 5, 6), Map.of(6, 1, 5, 1, 4, 1, 3, 2, 2, 0, 1, 0), 6),
            Arguments.of(2, List.of(5, 3, 3, 3, 5), Map.of(6, 0, 5, 2, 4, 0, 3, 3, 2, 0, 1, 0), 10),
            Arguments.of(2, List.of(5, 3, 6, 6, 5), Map.of(6, 2, 5, 2, 4, 0, 3, 1, 2, 0, 1, 0), 12),
            Arguments.of(2, List.of(1, 2, 3, 4, 5), Map.of(6, 0, 5, 1, 4, 1, 3, 1, 2, 1, 1, 1), 0));
    }

}
