package multiDimensionalArr;


import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputDim = scanner.nextLine();
        int rowDim = Integer.parseInt(inputDim.split(" ")[0]);
        int colDim = Integer.parseInt(inputDim.split(" ")[1]);

        String[][] matrix = new String[rowDim][colDim];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {

            String[] commandArr = command.split(" ");
            int commandSize = commandArr.length;

            if (command.startsWith("swap") && commandSize == 5) {

                int row1 = Integer.parseInt(commandArr[1]);
                int col1 = Integer.parseInt(commandArr[2]);
                int row2 = Integer.parseInt(commandArr[3]);
                int col2 = Integer.parseInt(commandArr[4]);

                if (row1 >= 0 && row1 < matrix.length && row2 >= 0 && row2 < matrix.length
                    && col1 >= 0 && col1 < matrix.length && col2 >= 0 && col2 < matrix.length) {

                    String firstElement = matrix[row1][col1];
                    String secondElement = matrix[row2][col2];

                    matrix[row1][col1] = secondElement;
                    matrix[row2][col2] = firstElement;

                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }
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
