package midExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] milligramsCaffeine = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] energyDrinks = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stackCaffeine = new ArrayDeque<>();
        ArrayDeque<Integer> queueDrinks = new ArrayDeque<>();

        for (int milligram : milligramsCaffeine) {
            stackCaffeine.push(milligram);
        }

        for (int drink : energyDrinks) {
            queueDrinks.offer(drink);
        }

        final int MAX_CAFFEINE = 300;
        int caffeineConsumed = 0;


        boolean isDrinkAll = true;
        while (!queueDrinks.isEmpty()) {

            //FIXME
            //не се ъпдейтва условието

            int currentCaffeine = 0;
            int currentDrink = 0;

            if (!stackCaffeine.isEmpty()) {
                currentCaffeine = stackCaffeine.peek();
            }
            if (!queueDrinks.isEmpty()) {
               currentDrink  = queueDrinks.peek();
            }

            int product = currentDrink * currentCaffeine;

            if (product + caffeineConsumed <= MAX_CAFFEINE) {

                caffeineConsumed += product;
                if (!stackCaffeine.isEmpty()) {
                    stackCaffeine.pop();
                }
                queueDrinks.poll();

            } else {

                stackCaffeine.pop();
                int currentDrinkToRemove = queueDrinks.peek();
                queueDrinks.poll();
                queueDrinks.offer(currentDrinkToRemove);

                if (caffeineConsumed - 30 >= 0) {
                    caffeineConsumed -= 30;
                } else {
                    caffeineConsumed = 0;
                }

                isDrinkAll = false;
                break;
            }


        }

        if (!isDrinkAll) {
            System.out.print("Drinks left: ");

            for (int drink : queueDrinks) {

                int commaCounter = 0;
                if (commaCounter < queueDrinks.size() - 1) {
                    System.out.print(drink + ", ");
                    commaCounter++;

                } else {
                    System.out.println(drink);
                }

            }

        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", caffeineConsumed);

    }
}
