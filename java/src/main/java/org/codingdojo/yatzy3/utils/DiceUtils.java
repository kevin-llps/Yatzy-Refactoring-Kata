package org.codingdojo.yatzy3.utils;

import java.util.List;

public class DiceUtils {

    public int sum(List<Integer> dice) {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }

}
