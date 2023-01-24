package multiDimensionalArr;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);

        String[][] matrix = new String[rows][cols];

        char startSymbol = 'a';
        char middleSymbol = 'a';
        char endSymbol = 'a';
        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[0].length; col++) {
                if (col != 0) {
                    middleSymbol = (char) (middleSymbol + 1);
                }

                String startStr = String.valueOf(startSymbol);
                String middleStr = String.valueOf(middleSymbol);
                String endStr = String.valueOf(endSymbol);

                matrix[row][col] = startStr + middleStr + endStr;
            }

            startSymbol = (char) (startSymbol + 1);
            middleSymbol = startSymbol;
            endSymbol = (char) (endSymbol + 1);
        }

        printMatrix(matrix);

    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
