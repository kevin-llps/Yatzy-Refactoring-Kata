package org.codingdojo.yatzy1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Yatzy1Test {

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbers")
    void chance_scores_sum_of_all_dices(int[] dice, int expectedScore) {

        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).chance();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideDiceNumbers() {
        return Stream.of(
            Arguments.of(new int[]{2, 3, 4, 5, 1}, 15),
            Arguments.of(new int[]{3, 3, 4, 5, 1}, 16));
    }

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideYatzyDiceNumbers")
    void given_dice_numbers_yatzy_compute_score(int[] dice, int expectedScore) {
        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).yatzy();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideYatzyDiceNumbers() {
        return Stream.of(
            Arguments.of(new int[]{6, 6, 6, 6, 3}, 0),
            Arguments.of(new int[]{2, 4, 4, 4, 4}, 0),
            Arguments.of(new int[]{2, 2, 1, 2, 2}, 0),
            Arguments.of(new int[]{4, 4, 4, 4, 4}, 50),
            Arguments.of(new int[]{6, 6, 6, 6, 6}, 50));
    }

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbersToSumAllOnes")
    void sum_all_dice_ones(int[] dice, int expectedScore) {
        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).ones();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideDiceNumbersToSumAllOnes() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 1),
            Arguments.of(new int[]{1, 2, 1, 4, 5}, 2),
            Arguments.of(new int[]{6, 2, 2, 4, 5}, 0),
            Arguments.of(new int[]{1, 2, 1, 1, 1}, 4));
    }

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbersToSumAllTwos")
    void sum_all_dice_twos(int[] dice, int expectedScore) {
        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).twos();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideDiceNumbersToSumAllTwos() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 2, 6}, 4),
            Arguments.of(new int[]{2, 2, 2, 2, 2}, 10),
            Arguments.of(new int[]{1, 1, 3, 4, 5}, 0));
    }

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbersToSumAllThrees")
    void sum_all_dice_threes(int[] dice, int expectedScore) {
        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).threes();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideDiceNumbersToSumAllThrees() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 2, 3}, 6),
            Arguments.of(new int[]{2, 3, 3, 3, 3}, 12),
            Arguments.of(new int[]{1, 2, 2, 4, 5}, 0));
    }

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbersToSumAllFours")
    void sum_all_dice_fours(int[] dice, int expectedScore) {
        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).fours();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideDiceNumbersToSumAllFours() {
        return Stream.of(
            Arguments.of(new int[]{4, 4, 4, 5, 5}, 12),
            Arguments.of(new int[]{4, 4, 5, 5, 5}, 8),
            Arguments.of(new int[]{4, 5, 5, 5, 5}, 4),
            Arguments.of(new int[]{1, 2, 3, 3, 5}, 0));
    }

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbersToSumAllFives")
    void sum_all_dice_fives(int[] dice, int expectedScore) {
        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).fives();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideDiceNumbersToSumAllFives() {
        return Stream.of(
            Arguments.of(new int[]{4, 4, 4, 5, 5}, 10),
            Arguments.of(new int[]{4, 4, 5, 5, 5}, 15),
            Arguments.of(new int[]{4, 5, 5, 5, 5}, 20),
            Arguments.of(new int[]{1, 2, 3, 4, 1}, 0));
    }

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbersToSumAllSixes")
    void sum_all_dice_sixes(int[] dice, int expectedScore) {
        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).sixes();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideDiceNumbersToSumAllSixes() {
        return Stream.of(
            Arguments.of(new int[]{4, 4, 4, 5, 5}, 0),
            Arguments.of(new int[]{4, 4, 6, 5, 5}, 6),
            Arguments.of(new int[]{6, 5, 6, 6, 5}, 18));
    }

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbersToSumPair")
    void sum_all_pairs(int[] dice, int expectedScore) {
        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).onePair();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideDiceNumbersToSumPair() {
        return Stream.of(
            Arguments.of(new int[]{3, 4, 3, 5, 6}, 6),
            Arguments.of(new int[]{5, 3, 3, 3, 5}, 10),
            Arguments.of(new int[]{5, 3, 6, 6, 5}, 12),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 0));
    }

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbersToSumAllTwoPairs")
    void sum_all_two_pairs(int[] dice, int expectedScore) {
        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).twoPairs();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideDiceNumbersToSumAllTwoPairs() {
        return Stream.of(
            Arguments.of(new int[]{3, 3, 5, 4, 5}, 16),
            Arguments.of(new int[]{3, 3, 5, 5, 5}, 16),
            Arguments.of(new int[]{3, 3, 3, 3, 1}, 0));
    }

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbersToSumAllThreeOfSameKind")
    void sum_all_three_of_same_kind(int[] dice, int expectedScore) {
        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).threeOfSameKind();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideDiceNumbersToSumAllThreeOfSameKind() {
        return Stream.of(
            Arguments.of(new int[]{3, 3, 3, 4, 5}, 9),
            Arguments.of(new int[]{5, 3, 5, 4, 5}, 15),
            Arguments.of(new int[]{3, 3, 3, 3, 5}, 9),
            Arguments.of(new int[]{3, 3, 4, 5, 6}, 0));
    }

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbersToSumAllFourOfSameKind")
    void sum_all_four_of_same_kind(int[] dice, int expectedScore) {
        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).fourOfSameKind();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideDiceNumbersToSumAllFourOfSameKind() {
        return Stream.of(
            Arguments.of(new int[]{3, 3, 3, 3, 5}, 12),
            Arguments.of(new int[]{5, 5, 5, 4, 5}, 20),
            Arguments.of(new int[]{3, 3, 3, 3, 3}, 12),
            Arguments.of(new int[]{2, 2, 2, 5, 5}, 0));
    }

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbersOnSmallStraight")
    void given_dice_numbers_small_straight_compute_score(int[] dice, int expectedScore) {
        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).smallStraight();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideDiceNumbersOnSmallStraight() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 15),
            Arguments.of(new int[]{2, 3, 4, 5, 1}, 15),
            Arguments.of(new int[]{1, 2, 6, 4, 5}, 0));
    }

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbersOnLargeStraight")
    void given_dice_numbers_large_straight_compute_score(int[] dice, int expectedScore) {
        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).largeStraight();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideDiceNumbersOnLargeStraight() {
        return Stream.of(
            Arguments.of(new int[]{6, 2, 3, 4, 5}, 20),
            Arguments.of(new int[]{2, 3, 4, 5, 6}, 20),
            Arguments.of(new int[]{1, 2, 2, 4, 5}, 0));
    }

    @ParameterizedTest(name = "Expect score {1} for dice {0}")
    @MethodSource("provideDiceNumbersOnFullHouse")
    void sum_all_dices_on_full_house(int[] dice, int expectedScore) {
        int actualScore = new Yatzy1(dice[0], dice[1], dice[2], dice[3], dice[4]).fullHouse();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> provideDiceNumbersOnFullHouse() {
        return Stream.of(
            Arguments.of(new int[]{6, 2, 2, 2, 6}, 18),
            Arguments.of(new int[]{1, 1, 2, 2, 2}, 8),
            Arguments.of(new int[]{2, 3, 4, 5, 6}, 0));
    }

}
