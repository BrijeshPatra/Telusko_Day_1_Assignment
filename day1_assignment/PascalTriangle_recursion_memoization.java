package day1_assignment;

import java.util.HashMap;
import java.util.Map;

public class PascalTriangle_recursion_memoization {
    private static Map<String, Integer> memo = new HashMap<>();

    public static int calculateCoefficient(int row, int column) {
        if (column == 0 || column == row) {
            return 1;
        } else {
            String key = row + "," + column;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
            int coefficient = calculateCoefficient(row - 1, column - 1) +
                    calculateCoefficient(row - 1, column);
            memo.put(key, coefficient);
            return coefficient;
        }
    }

    public static void printPascalTriangle(int numRows) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(calculateCoefficient(i, j) + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int numRows = 5;
        printPascalTriangle(numRows);
    }
}