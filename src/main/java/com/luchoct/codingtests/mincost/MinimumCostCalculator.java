package com.luchoct.codingtests.mincost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MinimumCostCalculator {
    private static final String DIGIT_SEPARATOR = ",";

    private static int minimum(final int value1, final int value2) {
        return (value1 < value2) ? value1 : value2;
    }

    static int getMinimumCost(final int[][] matrix, final int fromRow, final int fromColumn, final int toRow, final int toColumn) {

        //Last element
        if ((fromRow == toRow) && (fromColumn == toColumn)) {
            return matrix[fromRow][fromColumn];
        //Last row
        } else if (fromRow == toRow) {
            return matrix[fromRow][fromColumn] + getMinimumCost(matrix, fromRow, fromColumn + 1, toRow, toColumn);
        //Last column
        } else if (fromColumn == toColumn) {
            return matrix[fromRow][fromColumn] + getMinimumCost(matrix, fromRow + 1, fromColumn, toRow, toColumn);
        } else {
            return matrix[fromRow][fromColumn] + minimum(
                    getMinimumCost(matrix, fromRow, fromColumn + 1, toRow, toColumn),
                    getMinimumCost(matrix,fromRow + 1, fromColumn, toRow, toColumn)
            );
        }
    }

    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        final InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        final BufferedReader in = new BufferedReader(reader);

        final int size = Integer.parseInt(in.readLine());

        final int[][] matrixToCheck = new int[size][size];
        int numRow = 0;
        String line;
        while ((line = in.readLine()) != null) {
            final String[] lineValues = line.split(MinimumCostCalculator.DIGIT_SEPARATOR);
            for (int column = 0; column < size; column++) {
                matrixToCheck[numRow][column] = Integer.parseInt(lineValues[column]);
            }
            numRow++;
        }
        System.out.println(getMinimumCost(matrixToCheck, 0, 0, size - 1, size - 1));
    }
}