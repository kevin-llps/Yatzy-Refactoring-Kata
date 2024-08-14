package org.codingdojo.yatzy3.scorer;

import org.codingdojo.yatzy3.utils.DiceFrequencies;
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
class YatzyPointsScorerTest {

    @InjectMocks
    private YatzyPointsScorer yatzyPointsScorer;

    @Mock
    private DiceFrequencies diceFrequencies;

    @ParameterizedTest(name = "Expect score {2} for dice {0}")
    @MethodSource("provideDiceFrequencies")
    void given_dice_frequencies_yatzy_compute_score(List<Integer> dice, Map<Integer, Integer> frequencies, int expectedScore) {

        when(diceFrequencies.frequencies(dice)).thenReturn(frequencies);

        assertEquals(expectedScore, yatzyPointsScorer.calculateScore(dice));

        verify(diceFrequencies).frequencies(dice);
        verifyNoMoreInteractions(diceFrequencies);
    }

    private static Stream<Arguments> provideDiceFrequencies() {
        return Stream.of(
            Arguments.of(List.of(4, 4, 4, 4, 4), Map.of(6, 0, 5, 0, 4, 5, 3, 0, 2, 0, 1, 0), 50),
            Arguments.of(List.of(6, 6, 6, 6, 6), Map.of(6, 5, 5, 0, 4, 0, 3, 0, 2, 0, 1, 0), 50),
            Arguments.of(List.of(6, 6, 6, 6, 3), Map.of(6, 4, 5, 0, 4, 0, 3, 1, 2, 0, 1, 0), 0));
    }

}
