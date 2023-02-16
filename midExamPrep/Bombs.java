package midExamPrep;

import java.util.*;

public class Bombs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] bombEffects = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] bombCasings = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queueEffects = new ArrayDeque<>();
        ArrayDeque<Integer> stackCasings = new ArrayDeque<>();

        for (int bombEffect : bombEffects) {
            queueEffects.offer(bombEffect);
        }

        for (int bombCasing : bombCasings) {
            stackCasings.push(bombCasing);
        }

        Map<String, Integer> bombMap = new TreeMap<>();


        bombMap.put("Datura Bombs", 0);
        bombMap.put("Cherry Bombs", 0);
        bombMap.put("Smoke Decoy Bombs", 0);

        boolean isFilled = false;
        while (!queueEffects.isEmpty() && !stackCasings.isEmpty()) {

            int currentEffect = queueEffects.peek();
            int currentCasing = stackCasings.peek();

            if (currentEffect + currentCasing == 40) {

                int currentCount = bombMap.get("Datura Bombs");
                bombMap.put("Datura Bombs", currentCount + 1);

                queueEffects.poll();
                stackCasings.pop();

            } else if (currentEffect + currentCasing == 60) {

                int currentCount = bombMap.get("Cherry Bombs");
                bombMap.put("Cherry Bombs", currentCount + 1);

                queueEffects.poll();
                stackCasings.pop();

            } else if (currentEffect + currentCasing == 120) {

                int currentCount = bombMap.get("Smoke Decoy Bombs");
                bombMap.put("Smoke Decoy Bombs", currentCount + 1);

                queueEffects.poll();
                stackCasings.pop();

            } else {

                currentCasing -= 5;
                stackCasings.pop();
                stackCasings.push(currentCasing);
            }

            if (bombMap.get("Datura Bombs") >= 3
                    && bombMap.get("Cherry Bombs") >= 3
                    && bombMap.get("Smoke Decoy Bombs") >= 3) {
                isFilled = true;
                break;
            }

        }

        if (isFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (queueEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            int countForComma = 0;
            for (int bombEffect : queueEffects) {
                if (countForComma != queueEffects.size() - 1) {
                    System.out.print(bombEffect + ", ");
                    countForComma++;

                } else {
                    System.out.print(bombEffect);
                }
            }
            System.out.println();
        }

        if (stackCasings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            int countForComma = 0;
            for (int bombCasing : stackCasings) {
                if (countForComma != stackCasings.size() - 1) {
                    System.out.print(bombCasing + ", ");
                    countForComma++;

                } else {
                    System.out.print(bombCasing);
                }
            }
            System.out.println();
        }




        for (Map.Entry<String, Integer> entry : bombMap.entrySet()) {

            System.out.printf(entry.getKey() + ": " + entry.getValue());
            System.out.println();

        }


    }
}
