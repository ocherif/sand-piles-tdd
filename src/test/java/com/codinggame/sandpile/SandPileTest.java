package com.codinggame.sandpile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SandPileTest {
    private SandPile sandPile;

    @BeforeEach
    void setUp() {
        sandPile = new SandPile();
    }

    @Test
    public void testStabilize(){
        int[][] pile = new int[][]{
                {2, 1, 3},
                {3, 2, 1},
                {1, 3, 2}
        };

        int[][] result = sandPile.stabilize(pile, 1);

        String expected = "[[2, 1, 3], [3, 3, 1], [1, 3, 2]]";

        assertThat(Arrays.deepToString(result)).isEqualTo(expected);
    }
}
