package midExamPrep;

import java.util.*;


public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Map<String, Integer> advancedMaterials = new LinkedHashMap<>();

        int[] liquids = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ingredients = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int liquid : liquids) {
            queue.offer(liquid);
        }

        for (int ingredient : ingredients) {
            stack.push(ingredient);
        }


        advancedMaterials.put("Biscuit", 0);
        advancedMaterials.put("Cake", 0);
        advancedMaterials.put("Pie", 0);
        advancedMaterials.put("Pastry", 0);

        while (!queue.isEmpty()) {

            //FIXME евентуално while

            int currentElementQueue = 0;
            int currentElementStack = 0;

                currentElementQueue = queue.peek();


            if (!stack.isEmpty()) {
                currentElementStack = stack.peek();
            }


            if (currentElementQueue + currentElementStack == 25) {


                int currentCount = advancedMaterials.get("Biscuit");
                advancedMaterials.put("Biscuit", currentCount + 1);


                queue.poll();
                stack.pop();

            } else if (currentElementQueue + currentElementStack == 50) {

                int currentCount = advancedMaterials.get("Cake");
                advancedMaterials.put("Cake", currentCount + 1);

                queue.poll();
                stack.pop();

            } else if (currentElementQueue + currentElementStack == 75) {

                int currentCount = advancedMaterials.get("Pastry");
                advancedMaterials.put("Pastry", currentCount + 1);

                queue.poll();
                stack.pop();

            } else if (currentElementQueue + currentElementStack == 100) {

                int currentCount = advancedMaterials.get("Pie");
                advancedMaterials.put("Pie", currentCount + 1);

                queue.poll();
                stack.pop();

            } else {

                queue.poll();
                currentElementStack += 3;
                stack.pop();
                stack.push(currentElementStack);
            }

        }

        //First Line Output
        if (advancedMaterials.get("Biscuit") != 0
                && advancedMaterials.get("Cake") != 0
                && advancedMaterials.get("Pastry") != 0
                && advancedMaterials.get("Pie") != 0) {

            System.out.println("Great! You succeeded in cooking all the food!");

        } else {

            System.out.println("What a pity! You didn't have enough materials to cook everything.");

        }

        //Second Line Output
        if (!queue.isEmpty()) {

            for (int liquidQ : queue) {
                System.out.print("Liquids left: ");
                System.out.print(liquidQ + ", ");
            }

        } else {

            System.out.println("Liquids left: none");

        }


        //Third Line Output
        if (!stack.isEmpty()) {


            System.out.print("Ingredients left: ");
            int remainingSize = stack.size();

            for (int ingredientSt : stack) {

                if (remainingSize > 1) {
                    remainingSize--;
                    System.out.print(ingredientSt + ", ");
                } else {
                    System.out.println(ingredientSt);
                }

            }

        } else {

            System.out.println("Ingredients left: none");

        }

        //FourthLineInput
        for (Map.Entry<String, Integer> entry : advancedMaterials.entrySet()) {

            System.out.println(entry.getKey() + ": " + entry.getValue());

        }


    }
}
