package org.codingdojo.yatzy3;

import org.codingdojo.yatzy3.scorer.CategoryScorer;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.codingdojo.YatzyCategory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class Yatzy3Test {

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

        Yatzy3 yatzy3 = new Yatzy3();

        assertEquals(expectedValidCategories, yatzy3.validCategories());
    }

    @Test
    void should_compute_score() {
        List<Integer> dice = List.of(2, 3, 4, 5, 1);
        int expectedScore = 15;

        Yatzy3 yatzy3 = new Yatzy3();

        CategoryScorer categoryScorer = mock(CategoryScorer.class);

        try (MockedStatic<CategoryScorer> categoryScorerMockedStatic = Mockito.mockStatic(CategoryScorer.class)) {

            categoryScorerMockedStatic.when(() -> CategoryScorer.createInstance(CHANCE.name())).thenReturn(categoryScorer);
            when(categoryScorer.calculateScore(dice)).thenReturn(expectedScore);

            assertEquals(expectedScore, yatzy3.score(dice, CHANCE.name()));

            categoryScorerMockedStatic.verify(() -> CategoryScorer.createInstance(CHANCE.name()));
            verify(categoryScorer).calculateScore(dice);

            categoryScorerMockedStatic.verifyNoMoreInteractions();
        }

        verifyNoMoreInteractions(categoryScorer);
    }

}
