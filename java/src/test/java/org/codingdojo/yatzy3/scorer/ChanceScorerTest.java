package org.codingdojo.yatzy3.scorer;

import org.codingdojo.yatzy3.scorer.ChanceScorer;
import org.codingdojo.yatzy3.utils.DiceUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChanceScorerTest {

    @InjectMocks
    private ChanceScorer chanceScorer;

    @Mock
    private DiceUtils diceUtils;

    @Test
    void chance_scores_sum_of_all_dices() {
        List<Integer> dice = List.of(2, 3, 4, 5, 1);
        int expectedScore = 15;

        when(diceUtils.sum(dice)).thenReturn(expectedScore);

        assertEquals(expectedScore, chanceScorer.calculateScore(dice));

        verify(diceUtils).sum(dice);
        verifyNoMoreInteractions(diceUtils);
    }

}
