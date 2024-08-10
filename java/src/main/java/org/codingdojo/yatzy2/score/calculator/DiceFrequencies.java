package org.codingdojo.yatzy2.score.calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.codingdojo.yatzy2.Yatzy2.DICE_VALUES;

public class DiceFrequencies {

    private DiceFrequencies() {
    }

    public static Map<Integer, Integer> create(List<Integer> dice) {
        Map<Integer, Integer> diceFrequencies = new HashMap<>();

        for (int i : DICE_VALUES) {
            diceFrequencies.put(i, 0);
        }
        
        for (int die : dice) {
            diceFrequencies.put(die, diceFrequencies.get(die) + 1);
        }

        return diceFrequencies;
    }

}
