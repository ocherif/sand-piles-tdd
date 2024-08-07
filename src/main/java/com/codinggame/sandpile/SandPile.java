package com.codinggame.sandpile;
public class SandPile {
    private static final int THRESHOLD = 4;

    public int[][] stabilize(int[][] pile, int n) {
        int size = pile.length;
        int center = size / 2;

        for (int iteration = 0; iteration < n; iteration++) {
            pile[center][center]++;
            distributeGrains(pile, center, center);
        }
        return pile;
    }
    private void distributeGrains(int[][] pile, int i, int j) {
        int size = pile.length;

        if (pile[i][j] < THRESHOLD) {
            return;
        }

        pile[i][j] -= THRESHOLD;
        if (i > 0) pile[i - 1][j]++;
        if (i < size - 1) pile[i + 1][j]++;
        if (j > 0) pile[i][j - 1]++;
        if (j < size - 1) pile[i][j + 1]++;

        if (i > 0) distributeGrains(pile, i - 1, j);
        if (i < size - 1) distributeGrains(pile, i + 1, j);
        if (j > 0) distributeGrains(pile, i, j - 1);
        if (j < size - 1) distributeGrains(pile, i, j + 1);
    }
}