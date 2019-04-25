package com.luchoct.codingtests.mincost;

import org.junit.Assert;
import org.junit.Test;

public class MinimumCostPathCalculatorTest {
    @Test
    public void getMinimumCost() {
        final int[][] matrix = new int [][] {
            {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3}};
        Assert.assertEquals(11, MinimumCostCalculator.getMinimumCost(matrix, 0, 0, 2, 2));
    }
}