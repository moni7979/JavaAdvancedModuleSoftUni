package midExamPrep;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputDimensions = scanner.nextLine();
        int n = Integer.parseInt(inputDimensions.split(" ")[0]);
        int m = Integer.parseInt(inputDimensions.split(" ")[1]);

        String[][] matrix = new String[n][m];


        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }


        int hunterRow = -1;
        int hunterCol = -1;

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < m; col++) {

                if (matrix[row][col].equals("Y")) {

                    hunterRow = row;
                    hunterCol = col;
                    break;
                }

            }
        }


        List<String> commands = new LinkedList<>();

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {

            if (matrix[hunterRow][hunterCol].equals("X")) {
                break;
            }

            if (command.equals("up")) {

                if (hunterRow - 1 >= 0) {
                    hunterRow--;

                    if (matrix[hunterRow][hunterCol].equals("T")) {
                        hunterRow++;
                    } else {
                        commands.add(command);
                    }
                }

            } else if (command.equals("down")) {

                if (hunterRow + 1 < n) {
                    hunterRow++;

                    if (matrix[hunterRow][hunterCol].equals("T")) {
                        hunterRow--;
                    } else {
                        commands.add(command);
                    }

                }

            } else if (command.equals("right")) {

                if (hunterCol + 1 < m) {
                    hunterCol++;

                    if (matrix[hunterRow][hunterCol].equals("T")) {
                        hunterCol--;
                    } else {
                        commands.add(command);
                    }
                }

            } else if (command.equals("left")) {

                if (hunterCol - 1 >= 0) {
                    hunterCol--;

                    if (matrix[hunterRow][hunterCol].equals("T")) {
                        hunterCol++;
                    } else {
                        commands.add(command);
                    }
                }

            }


            command = scanner.nextLine();
        }

        if (matrix[hunterRow][hunterCol].equals("X")) {
            System.out.println("I've found the treasure!");



            if (!commands.isEmpty()) {
                System.out.print("The right path is ");
                int commaCounter = 0;

                for (String commandInList : commands) {
                    if (commaCounter < commands.size() - 1) {
                        System.out.print(commandInList + ", ");
                        commaCounter++;
                    } else {
                        System.out.println(commandInList);
                    }
                }
            }

        } else {
            System.out.println("The map is fake!");
        }

    }
}
