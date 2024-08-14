package org.codingdojo.yatzy3.scorer;

import org.codingdojo.yatzy3.scorer.FullHouseScorer;
import org.codingdojo.yatzy3.utils.DiceFrequencies;
import org.codingdojo.yatzy3.utils.DiceUtils;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FullHouseScorerTest {

    @InjectMocks
    private FullHouseScorer fullHouseScorer;

    @Mock
    private DiceUtils diceUtils;

    @Mock
    private DiceFrequencies diceFrequencies;

    @ParameterizedTest(name = "Expect score {2} for dice {0} and frequencies {1}")
    @MethodSource("provideWinningDiceAndDiceFrequencies")
    void given_winning_dice_full_house_compute_score(List<Integer> dice, Map<Integer, Integer> frequencies, int expectedScore) {

        when(diceFrequencies.frequencies(dice)).thenReturn(frequencies);
        when(diceUtils.sum(dice)).thenReturn(expectedScore);

        assertEquals(expectedScore, fullHouseScorer.calculateScore(dice));

        verify(diceFrequencies).frequencies(dice);
        verify(diceUtils).sum(dice);

        verifyNoMoreInteractions(diceFrequencies, diceUtils);
    }

    private static Stream<Arguments> provideWinningDiceAndDiceFrequencies() {
        return Stream.of(
            Arguments.of(
                List.of(6, 2, 2, 2, 6),
                Map.of(6, 2, 5, 0, 4, 0, 3, 0, 2, 3, 1, 0),
                18),
            Arguments.of(
                List.of(1, 1, 2, 2, 2),
                Map.of(6, 0, 5, 0, 4, 0, 3, 0, 2, 3, 1, 2),
                8));
    }

    @ParameterizedTest(name = "Expect score {2} for dice {0} and frequencies {1}")
    @MethodSource("provideLosingDiceAndDiceFrequencies")
    void given_losing_dice_full_house_compute_score(List<Integer> dice, Map<Integer, Integer> frequencies, int expectedScore) {

        when(diceFrequencies.frequencies(dice)).thenReturn(frequencies);

        assertEquals(expectedScore, fullHouseScorer.calculateScore(dice));

        verify(diceFrequencies).frequencies(dice);

        verifyNoMoreInteractions(diceFrequencies);
        verifyNoInteractions(diceUtils);
    }

    private static Stream<Arguments> provideLosingDiceAndDiceFrequencies() {
        return Stream.of(
            Arguments.of(
                List.of(2, 3, 4, 5, 6),
                Map.of(6, 1, 5, 1, 4, 1, 3, 1, 2, 1, 1, 1),
                0));
    }

}
