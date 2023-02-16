package midExamPrep;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] matrix = new String[n][n];

        fillMatrix(scanner, n, matrix);

        int rowDilinger = -1;
        int colDilinger = -1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col].equals("D")) {
                    rowDilinger = row;
                    colDilinger = col;
                }
            }
        }

        int money = 0;
        for (String position : commands) {

            if (position.equals("left")) {
                if (colDilinger - 1 >= 0) {
                    matrix[rowDilinger][colDilinger] = "+";
                    colDilinger--;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }

            } else if (position.equals("right")) {
                if (colDilinger + 1 < matrix.length) {
                    matrix[rowDilinger][colDilinger] = "+";
                    colDilinger++;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }

            } else if (position.equals("up")) {
                if (rowDilinger - 1 >= 0) {
                    matrix[rowDilinger][colDilinger] = "+";
                    rowDilinger--;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }

            } else if (position.equals("down")) {
                if (rowDilinger + 1 < matrix.length) {
                    matrix[rowDilinger][colDilinger] = "+";
                    rowDilinger++;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            }

            String currentSymbol = matrix[rowDilinger][colDilinger];
            int moneyToAdd = 0;
            if (currentSymbol.equals("$")) {
                matrix[rowDilinger][colDilinger] = "D";
                moneyToAdd = rowDilinger * colDilinger;
                System.out.printf("You successfully stole %d$.%n", moneyToAdd);
                money += moneyToAdd;

            } else if (currentSymbol.equals("P")) {
                matrix[rowDilinger][colDilinger] = "#";
                System.out.printf("You got caught with %d$, and you are going to jail.%n", money);
                printMatrix(n, matrix);
                return;
            } else if (currentSymbol.equals("+")) {
                matrix[rowDilinger][colDilinger] = "D";
            }

        }

        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", money);
        printMatrix(n, matrix);

    }

    private static void printMatrix(int n, String[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();

        }
    }


    private static void fillMatrix(Scanner scanner, int n, String[][] matrix) {
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }
    }
}
