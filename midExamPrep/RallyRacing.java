package midExamPrep;

import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String racingNumber = scanner.nextLine();

        String[][] matrix = new String[n][n];
        for (int row = 0; row < n; row++) {

            matrix[row] = scanner.nextLine().split(" ");

        }

        int carRow = 0;
        int carCol = 0;

        int carKm = 0;

        boolean isFinished = false;

        String command = scanner.nextLine();
        while (!command.equals("End")) {


            if (command.equals("left")) {



                carCol--;
                if (matrix[carRow][carCol].equals(".")) {
                    carKm += 10;

                } else if (matrix[carRow][carCol].equals("T")) {

                    matrix[carRow][carCol] = ".";
                    for (int row = 0; row < n; row++) {
                        for (int col = 0; col < n; col++) {

                            if (matrix[row][col].equals("T")) {

                                carRow = row;
                                carCol = col;
                                matrix[row][col] = ".";
                                carKm += 30;
                                break;

                            }

                        }
                    }

                } else if (matrix[carRow][carCol].equals("F")) {

                    carKm += 10;
                    isFinished = true;
                    matrix[carRow][carCol] = "C";
                    break;

                }

            } else if (command.equals("right")) {


                carCol++;
                if (matrix[carRow][carCol].equals(".")) {
                    carKm += 10;

                } else if (matrix[carRow][carCol].equals("T")) {

                    matrix[carRow][carCol] = ".";
                    for (int row = 0; row < n; row++) {
                        for (int col = 0; col < n; col++) {

                            if (matrix[row][col].equals("T")) {

                                carRow = row;
                                carCol = col;
                                matrix[row][col] = ".";
                                carKm += 30;
                                break;

                            }

                        }
                    }

                } else if (matrix[carRow][carCol].equals("F")) {

                    carKm += 10;
                    isFinished = true;
                    matrix[carRow][carCol] = "C";
                    break;

                }

            } else if (command.equals("up")) {


                carRow--;
                if (matrix[carRow][carCol].equals(".")) {
                    carKm += 10;

                } else if (matrix[carRow][carCol].equals("T")) {

                    matrix[carRow][carCol] = ".";
                    for (int row = 0; row < n; row++) {
                        for (int col = 0; col < n; col++) {

                            if (matrix[row][col].equals("T")) {

                                carRow = row;
                                carCol = col;
                                matrix[row][col] = ".";
                                carKm += 30;
                                break;

                            }

                        }
                    }

                } else if (matrix[carRow][carCol].equals("F")) {

                    carKm += 10;
                    isFinished = true;
                    matrix[carRow][carCol] = "C";
                    break;

                }

            } else if (command.equals("down")) {


                carRow++;
                if (matrix[carRow][carCol].equals(".")) {
                    carKm += 10;

                } else if (matrix[carRow][carCol].equals("T")) {

                    matrix[carRow][carCol] = ".";
                    for (int row = 0; row < n; row++) {
                        for (int col = 0; col < n; col++) {

                            if (matrix[row][col].equals("T")) {

                                carRow = row;
                                carCol = col;
                                matrix[row][col] = ".";
                                carKm += 30;
                                break;

                            }

                        }
                    }

                } else if (matrix[carRow][carCol].equals("F")) {

                    carKm += 10;
                    isFinished = true;
                    matrix[carRow][carCol] = "C";
                    break;

                }

            } else {
                throw new IllegalArgumentException("Invalid direction!");
            }


            command = scanner.nextLine();
        }

        matrix[carRow][carCol] = "C";
        if (isFinished == true) {
            System.out.printf("Racing car %s finished the stage!%n", racingNumber);

        } else {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }

        System.out.printf("Distance covered %d km.%n", carKm);

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                System.out.print(matrix[row][col]);

            }
            System.out.println();

        }

    }
}
