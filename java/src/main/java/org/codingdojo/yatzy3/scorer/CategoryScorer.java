package org.codingdojo.yatzy3.scorer;

import org.codingdojo.YatzyCategory;
import org.codingdojo.yatzy3.utils.DiceFrequencies;
import org.codingdojo.yatzy3.utils.DiceUtils;

import java.util.List;

public interface CategoryScorer {
    static CategoryScorer createInstance(String categoryName) {
        YatzyCategory category = YatzyCategory.valueOf(categoryName);

        DiceUtils diceUtils = new DiceUtils();
        DiceFrequencies diceFrequencies = new DiceFrequencies();

        return switch (category) {
            case CHANCE -> new ChanceScorer(diceUtils);
            case YATZY -> new YatzyPointsScorer(diceFrequencies);
            case ONES -> new NumberScorer(1, diceFrequencies);
            case TWOS -> new NumberScorer(2, diceFrequencies);
            case THREES -> new NumberScorer(3, diceFrequencies);
            case FOURS -> new NumberScorer(4, diceFrequencies);
            case FIVES -> new NumberScorer(5, diceFrequencies);
            case SIXES -> new NumberScorer(6, diceFrequencies);
            case PAIR -> new RepeatedCountScorer(2, diceFrequencies);
            case THREE_OF_A_KIND -> new RepeatedCountScorer(3, diceFrequencies);
            case FOUR_OF_A_KIND -> new RepeatedCountScorer(4, diceFrequencies);
            case SMALL_STRAIGHT -> new StraightScorer(1, diceUtils, diceFrequencies);
            case LARGE_STRAIGHT -> new StraightScorer(6, diceUtils, diceFrequencies);
            case TWO_PAIRS -> new TwoPairsScorer(diceFrequencies);
            case FULL_HOUSE -> new FullHouseScorer(diceUtils, diceFrequencies);
        };
    }

    int calculateScore(List<Integer> dice);

}
