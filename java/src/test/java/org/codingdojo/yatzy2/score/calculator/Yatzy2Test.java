package org.codingdojo.yatzy2.score.calculator;

import org.codingdojo.YatzyCategory;
import org.codingdojo.yatzy2.Yatzy2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.codingdojo.YatzyCategory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class Yatzy2Test {

    @InjectMocks
    private Yatzy2 yatzy2;

    @Mock
    private DefaultLosingScoreCalculator defaultLosingScoreCalculator;

    @Test
    void should_get_valid_categories() {
        List<String> expectedValidCategories = List.of(
            CHANCE.name(),
            YATZY.name(),
            ONES.name(),
            TWOS.name(),
            THREES.name(),
            FOURS.name(),
            FIVES.name(),
            SIXES.name(),
            PAIR.name(),
            THREE_OF_A_KIND.name(),
            FOUR_OF_A_KIND.name(),
            SMALL_STRAIGHT.name(),
            LARGE_STRAIGHT.name(),
            TWO_PAIRS.name(),
            FULL_HOUSE.name());

        assertEquals(expectedValidCategories, yatzy2.validCategories());

        verifyNoInteractions(defaultLosingScoreCalculator);
    }

    @Test
    void should_compute_score() {
        List<Integer> dice = List.of(2, 3, 4, 5, 1);
        Map<Integer, Integer> diceFrequencies = Map.of(6, 0, 5, 1, 4, 1, 3, 1, 2, 1, 1, 1);
        int expectedScore = 15;

        ScoreCalculator scoreCalculator = mock(ScoreCalculator.class);
        Map<YatzyCategory, ScoreCalculator> scoreCalculatorByCategory = mock(Map.class);

        try (MockedStatic<ScoreCalculator> scoreCalculatorMockedStatic = Mockito.mockStatic(ScoreCalculator.class);
             MockedStatic<DiceFrequencies> diceFrequenciesMockedStatic = Mockito.mockStatic(DiceFrequencies.class)) {

            scoreCalculatorMockedStatic.when(ScoreCalculator::createScoreCalculators).thenReturn(scoreCalculatorByCategory);
            diceFrequenciesMockedStatic.when(() -> DiceFrequencies.create(dice)).thenReturn(diceFrequencies);

            when(scoreCalculatorByCategory.getOrDefault(eq(CHANCE), any())).thenReturn(scoreCalculator);
            when(scoreCalculator.compute(dice, diceFrequencies)).thenReturn(expectedScore);

            assertEquals(expectedScore, yatzy2.score(dice, CHANCE.name()));

            scoreCalculatorMockedStatic.verify(ScoreCalculator::createScoreCalculators);
            diceFrequenciesMockedStatic.verify(() -> DiceFrequencies.create(dice));

            scoreCalculatorMockedStatic.verifyNoMoreInteractions();
            diceFrequenciesMockedStatic.verifyNoMoreInteractions();
        }

        verifyNoInteractions(defaultLosingScoreCalculator);
    }

}
