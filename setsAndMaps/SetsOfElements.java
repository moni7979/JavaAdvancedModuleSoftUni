package setsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int nFirst = Integer.parseInt(input.split(" ")[0]);
        int mSecond = Integer.parseInt(input.split(" ")[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 1; i <= nFirst + mSecond; i++) {
            if (i <= nFirst) {
                int forFirst = Integer.parseInt(scanner.nextLine());
                firstSet.add(forFirst);

            } else {
                int forSecond = Integer.parseInt(scanner.nextLine());
                secondSet.add(forSecond);

            }
        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
