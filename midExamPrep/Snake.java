package midExamPrep;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().split("");
        }


        int snakeRow = -1;
        int snakeCol = -1;


        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (matrix[row][col].equals("S")) {
                    snakeRow = row;
                    snakeCol = col;
                    break;

                    //might have another if to find the lairs(burrows)

                }
            }
        }

        String command = scanner.nextLine();

        int foodQunatity = 0;

        while (true) {

            if (command.equals("up")) {

                if (snakeRow - 1 >= 0) {

                    matrix[snakeRow][snakeCol] = ".";

                    snakeRow--;

                    //check if there is food right after moving
                    if (matrix[snakeRow][snakeCol].equals("*")) {

                        foodQunatity++;
                        matrix[snakeRow][snakeCol] = "S";

                        //check if foodQuantity is enough
                        if (foodQunatity >= 10) {
                            System.out.println("You won! You fed the snake.");
                            break;
                        }

                    }
                    //checks if there is a burrow after moving
                    if (matrix[snakeRow][snakeCol].equals("B")) {
                        matrix[snakeRow][snakeCol] = ".";
                        //i go to the other burrow
                        for (int row = 0; row < n; row++) {
                            for (int col = 0; col < n; col++) {

                                if (matrix[row][col].equals("B")) {
                                    snakeRow = row;
                                    snakeCol = col;

                                    matrix[row][col] = "S";
                                }

                            }

                        }

                    }

                } else {
                    System.out.println("Game over!");
                    matrix[snakeRow][snakeCol] = ".";
                    break;
                }


            } else if (command.equals("down")) {

                //FIXME check the n here

                if (snakeRow + 1 < n) {

                    matrix[snakeRow][snakeCol] = ".";

                    snakeRow++;

                    //check if there is food right after moving
                    if (matrix[snakeRow][snakeCol].equals("*")) {

                        foodQunatity++;
                        matrix[snakeRow][snakeCol] = "S";

                        //check if foodQuantity is enough
                        if (foodQunatity >= 10) {
                            System.out.println("You won! You fed the snake.");
                            break;
                        }

                    }
                    //checks if there is a burrow after moving
                    if (matrix[snakeRow][snakeCol].equals("B")) {
                        matrix[snakeRow][snakeCol] = ".";
                        //i go to the other burrow
                        for (int row = 0; row < n; row++) {
                            for (int col = 0; col < n; col++) {

                                if (matrix[row][col].equals("B")) {
                                    snakeRow = row;
                                    snakeCol = col;

                                    matrix[row][col] = "S";
                                }

                            }

                        }

                    }

                } else {
                    System.out.println("Game over!");
                    matrix[snakeRow][snakeCol] = ".";
                    break;
                }

            } else if (command.equals("left")) {

                if (snakeCol - 1 >= 0) {

                    matrix[snakeRow][snakeCol] = ".";

                    snakeCol--;

                    //check if there is food right after moving
                    if (matrix[snakeRow][snakeCol].equals("*")) {

                        foodQunatity++;
                        matrix[snakeRow][snakeCol] = "S";

                        //check if foodQuantity is enough
                        if (foodQunatity >= 10) {
                            System.out.println("You won! You fed the snake.");
                            break;
                        }

                    }
                    //checks if there is a burrow after moving
                    if (matrix[snakeRow][snakeCol].equals("B")) {
                        matrix[snakeRow][snakeCol] = ".";
                        //i go to the other burrow
                        for (int row = 0; row < n; row++) {
                            for (int col = 0; col < n; col++) {

                                if (matrix[row][col].equals("B")) {
                                    snakeRow = row;
                                    snakeCol = col;

                                    matrix[row][col] = "S";
                                }

                            }

                        }

                    }

                } else {
                    System.out.println("Game over!");
                    matrix[snakeRow][snakeCol] = ".";
                    break;
                }

            } else if (command.equals("right")) {

                //FIXME check for the n here

                if (snakeCol + 1 < n) {

                    matrix[snakeRow][snakeCol] = ".";

                    snakeCol++;

                    //check if there is food right after moving
                    if (matrix[snakeRow][snakeCol].equals("*")) {

                        foodQunatity++;
                        matrix[snakeRow][snakeCol] = "S";

                        //check if foodQuantity is enough
                        if (foodQunatity >= 10) {
                            System.out.println("You won! You fed the snake.");
                            break;
                        }

                    }
                    //checks if there is a burrow after moving
                    if (matrix[snakeRow][snakeCol].equals("B")) {
                        matrix[snakeRow][snakeCol] = ".";
                        //i go to the other burrow
                        for (int row = 0; row < n; row++) {
                            for (int col = 0; col < n; col++) {

                                if (matrix[row][col].equals("B")) {
                                    snakeRow = row;
                                    snakeCol = col;

                                    matrix[row][col] = "S";
                                }

                            }

                        }

                    }

                } else {
                    System.out.println("Game over!");
                    matrix[snakeRow][snakeCol] = ".";
                    break;
                }


            }

            command = scanner.nextLine();

        }

        System.out.printf("Food eaten: %d%n", foodQunatity);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();

        }

    }
}
