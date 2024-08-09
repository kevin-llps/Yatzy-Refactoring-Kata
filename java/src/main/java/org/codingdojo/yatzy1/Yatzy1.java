package org.codingdojo.yatzy1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Yatzy1 {

    private static final int MAX_DICES = 5;

    private static final int YATZY_WINNING_SCORE = 50;
    private static final int YATZY_LOSING_SCORE = 0;

    private static final int EXPECTED_FIRST_DICE_ON_SMALL_STRAIGHT = 1;
    private static final int EXPECTED_LAST_DICE_ON_SMALL_STRAIGHT = 5;
    private static final int SCORE_ON_SMALL_STRAIGHT = 15;

    private static final int EXPECTED_FIRST_DICE_ON_LARGE_STRAIGHT = 2;
    private static final int EXPECTED_LAST_DICE_ON_LARGE_STRAIGHT = 6;
    private static final int SCORE_ON_LARGE_STRAIGHT = 20;

    private static final int DEFAULT_LOSING_SCORE = 0;

    private final int[] dice;

    public Yatzy1(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[MAX_DICES];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }

    public int chance() {
        return sum();
    }

    private int sum() {
        return Arrays.stream(dice).sum();
    }

    public int yatzy() {
        long distinctDicesCount = Arrays.stream(dice).distinct().count();

        return distinctDicesCount == 1 ? YATZY_WINNING_SCORE : YATZY_LOSING_SCORE;
    }

    public int ones() {
        return sum(1);
    }

    public int twos() {
        return sum(2);
    }

    public int threes() {
        return sum(3);
    }

    public int fours() {
        return sum(4);
    }

    public int fives() {
        return sum(5);
    }

    public int sixes() {
        return sum(6);
    }

    private int sum(int diceNumberToSum) {
        return Arrays.stream(dice)
            .filter(d -> d == diceNumberToSum)
            .sum();
    }

    public int onePair() {
        return getPairs(2)
            .stream()
            .max(Comparator.comparingInt(d -> d))
            .orElse(DEFAULT_LOSING_SCORE) * 2;
    }

    public int twoPairs() {
        List<Integer> pairs = getPairs(2);

        if (pairs.size() == 2) {
            return pairs.stream().reduce(0, Integer::sum) * 2;
        }

        return DEFAULT_LOSING_SCORE;
    }

    public int threeOfSameKind() {
        return getPairs(3)
            .stream()
            .findAny()
            .orElse(DEFAULT_LOSING_SCORE) * 3;
    }

    public int fourOfSameKind() {
        return getPairs(4)
            .stream()
            .findAny()
            .orElse(DEFAULT_LOSING_SCORE) * 4;
    }

    private List<Integer> getPairs(int requiredOccurrences) {
        return Stream.of(dice[0], dice[1], dice[2], dice[3], dice[4])
            .collect(Collectors.groupingBy(d -> d, Collectors.counting()))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() >= requiredOccurrences)
            .map(Map.Entry::getKey)
            .toList();
    }

    public int smallStraight() {
        return getScoreOnStraight(
            EXPECTED_FIRST_DICE_ON_SMALL_STRAIGHT,
            EXPECTED_LAST_DICE_ON_SMALL_STRAIGHT,
            SCORE_ON_SMALL_STRAIGHT);
    }

    public int largeStraight() {
        return getScoreOnStraight(
            EXPECTED_FIRST_DICE_ON_LARGE_STRAIGHT,
            EXPECTED_LAST_DICE_ON_LARGE_STRAIGHT,
            SCORE_ON_LARGE_STRAIGHT);
    }

    private int getScoreOnStraight(int expectedFirstDice, int expectedLastDice, int scoreOnStraight) {
        int[] distinctDices = Arrays.stream(dice)
            .distinct()
            .sorted()
            .toArray();

        return (distinctDices.length == MAX_DICES
            && distinctDices[0] == expectedFirstDice
            && distinctDices[MAX_DICES - 1] == expectedLastDice) ? scoreOnStraight : DEFAULT_LOSING_SCORE;
    }

    public int fullHouse() {
        Set<Integer> distinctDices = Stream.of(dice[0], dice[1], dice[2], dice[3], dice[4])
            .collect(Collectors.groupingBy(d -> d, Collectors.counting()))
            .keySet();

        return distinctDices.size() == 2 ? chance() : DEFAULT_LOSING_SCORE;
    }

}
