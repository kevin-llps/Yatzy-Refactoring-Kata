package org.codingdojo.yatzy3.scorer;

import org.codingdojo.yatzy3.utils.DiceFrequencies;
import org.codingdojo.yatzy3.utils.DiceUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StraightScorerTest {

    @ParameterizedTest(name = "Expect score {3} for straightIncludes {0} and dice {1}")
    @MethodSource("provideWinningDiceAndDiceFrequencies")
    void given_winning_dice_straight_compute_score(int straightIncludes, List<Integer> dice, Map<Integer, Integer> frequencies, int expectedScore) {
        DiceFrequencies diceFrequencies = mock(DiceFrequencies.class);
        DiceUtils diceUtils = mock(DiceUtils.class);

        StraightScorer straightScorer = new StraightScorer(straightIncludes, diceUtils, diceFrequencies);

        when(diceFrequencies.frequencies(dice)).thenReturn(frequencies);
        when(diceUtils.sum(dice)).thenReturn(expectedScore);

        assertEquals(expectedScore, straightScorer.calculateScore(dice));

        verify(diceFrequencies).frequencies(dice);
        verify(diceUtils).sum(dice);

        verifyNoMoreInteractions(diceFrequencies, diceUtils);
    }

    private static Stream<Arguments> provideWinningDiceAndDiceFrequencies() {
        return Stream.of(
            Arguments.of(1, List.of(1, 2, 3, 4, 5), Map.of(6, 0, 5, 1, 4, 1, 3, 1, 2, 1, 1, 1), 15),
            Arguments.of(1, List.of(2, 3, 4, 5, 1), Map.of(6, 0, 5, 1, 4, 1, 3, 1, 2, 1, 1, 1), 15),
            Arguments.of(6, List.of(6, 2, 3, 4, 5), Map.of(6, 1, 5, 1, 4, 1, 3, 1, 2, 1, 1, 0), 20),
            Arguments.of(6, List.of(2, 3, 4, 5, 6), Map.of(6, 1, 5, 1, 4, 1, 3, 1, 2, 1, 1, 0), 20));
    }

    @ParameterizedTest(name = "Expect score {3} for straightIncludes {0} and dice {1}")
    @MethodSource("provideLosingDiceAndDiceFrequencies")
    void given_losing_dice_straight_compute_score(int straightIncludes, List<Integer> dice, Map<Integer, Integer> frequencies, int expectedScore) {
        DiceFrequencies diceFrequencies = mock(DiceFrequencies.class);
        DiceUtils diceUtils = mock(DiceUtils.class);

        StraightScorer straightScorer = new StraightScorer(straightIncludes, diceUtils, diceFrequencies);

        when(diceFrequencies.frequencies(dice)).thenReturn(frequencies);

        assertEquals(expectedScore, straightScorer.calculateScore(dice));

        verify(diceFrequencies).frequencies(dice);

        verifyNoMoreInteractions(diceFrequencies);
        verifyNoInteractions(diceUtils);
    }

    private static Stream<Arguments> provideLosingDiceAndDiceFrequencies() {
        return Stream.of(
            Arguments.of(1, List.of(1, 2, 2, 4, 5), Map.of(6, 0, 5, 1, 4, 1, 3, 0, 2, 2, 1, 1), 0),
            Arguments.of(6, List.of(1, 2, 2, 4, 5), Map.of(6, 0, 5, 1, 4, 1, 3, 0, 2, 2, 1, 1), 0));
    }

}
