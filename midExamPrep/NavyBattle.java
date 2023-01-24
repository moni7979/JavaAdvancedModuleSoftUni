package midExamPrep;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] battlefield = new String[n][n];

        for (int row = 0; row < n; row++) {
            battlefield[row] = scanner.nextLine().split("");
        }


        int currentRow = -1;
        int currentCol = -1;

        for (int rowSearch = 0; rowSearch < n; rowSearch++) {

            for (int colSearch = 0; colSearch < n; colSearch++) {

                if (battlefield[rowSearch][colSearch].equals("S")) {
                    currentRow = rowSearch;
                    currentCol = colSearch;
                    break;

                }
            }
        }

        int currentHits = 0;
        int cruiserHits = 0;
        String command = scanner.nextLine();
        while (true) {



            battlefield[currentRow][currentCol] = "-";
            if (command.equals("up")) {

                currentRow--;

            } else if (command.equals("down")) {

                currentRow++;

            } else if (command.equals("left")) {

                currentCol--;

            } else if (command.equals("right")) {

                currentCol++;

            }


            if (battlefield[currentRow][currentCol].equals("-")) {
                battlefield[currentRow][currentCol] = "S";

            } else if (battlefield[currentRow][currentCol].equals("*")) {
                battlefield[currentRow][currentCol] = "S";
                currentHits++;
                if (currentHits == 3) {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", currentRow, currentCol);
                    break;
                }

            } else if (battlefield[currentRow][currentCol].equals("C")) {
                battlefield[currentRow][currentCol] = "S";
                cruiserHits++;

                if (cruiserHits == 3) {
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }

            command = scanner.nextLine();
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(battlefield[row][col] + "");

            }
            System.out.println();
        }
    }
}
