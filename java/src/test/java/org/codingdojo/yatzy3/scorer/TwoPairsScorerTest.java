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
class TwoPairsScorerTest {

    @InjectMocks
    private TwoPairsScorer twoPairsScorer;

    @Mock
    private DiceFrequencies diceFrequencies;

    @ParameterizedTest(name = "Expect score {2} for dice {1}")
    @MethodSource("provideDiceFrequencies")
    void two_pairs_compute_score(List<Integer> dice, Map<Integer, Integer> frequencies, int expectedScore) {
        when(diceFrequencies.frequencies(dice)).thenReturn(frequencies);

        assertEquals(expectedScore, twoPairsScorer.calculateScore(dice));

        verify(diceFrequencies).frequencies(dice);
        verifyNoMoreInteractions(diceFrequencies);
    }

    private static Stream<Arguments> provideDiceFrequencies() {
        return Stream.of(
            Arguments.of(List.of(3, 3, 5, 4, 5), Map.of(6, 0, 5, 2, 4, 1, 3, 2, 2, 0, 1, 0), 16),
            Arguments.of(List.of(3, 3, 5, 5, 5), Map.of(6, 0, 5, 3, 4, 0, 3, 2, 2, 0, 1, 0), 16),
            Arguments.of(List.of(1, 1, 2, 3, 4), Map.of(6, 0, 5, 0, 4, 1, 3, 1, 2, 1, 1, 2), 0));
    }

}
