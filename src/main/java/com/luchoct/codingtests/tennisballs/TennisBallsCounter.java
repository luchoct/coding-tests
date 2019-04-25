package com.luchoct.codingtests.tennisballs;

public class TennisBallsCounter {
    public static int playGame(final int currentRounds, final float currentProbability, final int numBalls) {
        final float probabilityToGetBlue = currentProbability + ((float)1/numBalls);
        if (probabilityToGetBlue >= 0.5) {
            return currentRounds;
        } else {
            return playGame(currentRounds + 1, probabilityToGetBlue, numBalls + 1);
        }
    }

    public static void main(final String[] args) {
        System.out.println(TennisBallsCounter.playGame(1, 0, 100));
    }
}
