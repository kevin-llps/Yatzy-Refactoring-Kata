package org.codingdojo.yatzy3;

import org.codingdojo.YatzyCalculator;
import org.codingdojo.YatzyCategory;
import org.codingdojo.yatzy3.scorer.CategoryScorer;

import java.util.Arrays;
import java.util.List;

public class Yatzy3 implements YatzyCalculator {
    @Override
    public List<String> validCategories() {
        return Arrays.stream(YatzyCategory.values()).map(Enum::toString).toList();
    }

    @Override
    public int score(List<Integer> dice, String category) {
        return CategoryScorer.createInstance(category).calculateScore(dice);
    }
}
