package org.codingdojo.yatzy2;

import org.codingdojo.YatzyCalculator;
import org.codingdojo.YatzyCategory;
import org.codingdojo.yatzy2.score.calculator.DefaultLosingScoreCalculator;
import org.codingdojo.yatzy2.score.calculator.DiceFrequencies;
import org.codingdojo.yatzy2.score.calculator.ScoreCalculator;

import java.util.Arrays;
import java.util.List;

public record Yatzy2(DefaultLosingScoreCalculator defaultLosingScoreCalculator) implements YatzyCalculator {

    public static final List<Integer> DICE_VALUES = List.of(6, 5, 4, 3, 2, 1);

    @Override
    public List<String> validCategories() {
        return Arrays.stream(YatzyCategory.values()).map(Enum::toString).toList();
    }

    @Override
    public int score(List<Integer> dice, String categoryName) {
        return ScoreCalculator.createScoreCalculators()
            .getOrDefault(YatzyCategory.valueOf(categoryName), this.defaultLosingScoreCalculator)
            .compute(dice, DiceFrequencies.create(dice));
    }

}

