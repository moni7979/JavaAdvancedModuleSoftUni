package multiDimensionalArr;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int dimension = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        int[][] numberArr = new int[dimension][dimension];

        if (pattern.equals("A")) {
            fillMatrixA(numberArr);
            printMatrix(numberArr);
        } else if (pattern.equals("B")) {
            fillMatrixB(numberArr);
            printMatrix(numberArr);
        }
    }


    public static void fillMatrixA(int[][] numberArr) {
        int startNumber = 1;
        for (int col = 0; col < numberArr.length; col++) {
            for (int row = 0; row < numberArr.length; row++) {
                numberArr[row][col] = startNumber;
                startNumber++;
            }
        }

    }

    public static void fillMatrixB(int[][] numbersArr) {
        int startNumber = 1;
        for (int col = 0; col < numbersArr.length; col++) {

            if ((col + 1) % 2 == 0) {
                for (int row = numbersArr.length - 1; row >= 0; row--) {
                    numbersArr[row][col] = startNumber;
                    startNumber++;
                }

            } else {
                for (int row = 0; row < numbersArr.length; row++) {
                    numbersArr[row][col] = startNumber;
                    startNumber++;
                }
            }
        }
    }

    public static void printMatrix(int[][] numbersArr) {
        for (int row = 0; row < numbersArr.length; row++) {
            for (int col = 0; col < numbersArr.length; col++) {
                System.out.print(numbersArr[row][col] + " ");
            }
            System.out.println();
        }
    }
}
