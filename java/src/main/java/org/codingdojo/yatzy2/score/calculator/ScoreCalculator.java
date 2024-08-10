package org.codingdojo.yatzy2.score.calculator;

import org.codingdojo.YatzyCategory;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.codingdojo.YatzyCategory.*;

@FunctionalInterface
public interface ScoreCalculator {

    static Map<YatzyCategory, ScoreCalculator> createScoreCalculators() {
        Map<YatzyCategory, ScoreCalculator> scoreCalculatorByCategories = new EnumMap<>(YatzyCategory.class);

        scoreCalculatorByCategories.put(CHANCE, (dice, diceFrequencies) -> ChanceScoreCalculator.compute(dice));
        scoreCalculatorByCategories.put(YATZY, (dice, diceFrequencies) -> YatzyScoreCalculator.compute(diceFrequencies));
        scoreCalculatorByCategories.put(ONES, (dice, diceFrequencies) -> NumberScoreCalculator.compute(1, diceFrequencies));
        scoreCalculatorByCategories.put(TWOS, (dice, diceFrequencies) -> NumberScoreCalculator.compute(2, diceFrequencies));
        scoreCalculatorByCategories.put(THREES, (dice, diceFrequencies) -> NumberScoreCalculator.compute(3, diceFrequencies));
        scoreCalculatorByCategories.put(FOURS, (dice, diceFrequencies) -> NumberScoreCalculator.compute(4, diceFrequencies));
        scoreCalculatorByCategories.put(FIVES, (dice, diceFrequencies) -> NumberScoreCalculator.compute(5, diceFrequencies));
        scoreCalculatorByCategories.put(SIXES, (dice, diceFrequencies) -> NumberScoreCalculator.compute(6, diceFrequencies));
        scoreCalculatorByCategories.put(PAIR, (dice, diceFrequencies) -> DuplicatedDiceNumberScoreCalculator.compute(2, diceFrequencies));
        scoreCalculatorByCategories.put(TWO_PAIRS, (dice, diceFrequencies) -> TwoPairsScoreCalculator.compute(diceFrequencies));
        scoreCalculatorByCategories.put(THREE_OF_A_KIND, (dice, diceFrequencies) -> DuplicatedDiceNumberScoreCalculator.compute(3, diceFrequencies));
        scoreCalculatorByCategories.put(FOUR_OF_A_KIND, (dice, diceFrequencies) -> DuplicatedDiceNumberScoreCalculator.compute(4, diceFrequencies));
        scoreCalculatorByCategories.put(SMALL_STRAIGHT, (dice, diceFrequencies) -> StraightScoreCalculator.compute(6, dice, diceFrequencies));
        scoreCalculatorByCategories.put(LARGE_STRAIGHT, (dice, diceFrequencies) -> StraightScoreCalculator.compute(1, dice, diceFrequencies));
        scoreCalculatorByCategories.put(FULL_HOUSE, FullHouseScoreCalculator::compute);

        return scoreCalculatorByCategories;
    }

    int compute(List<Integer> dice, Map<Integer, Integer> diceFrequencies);

}
