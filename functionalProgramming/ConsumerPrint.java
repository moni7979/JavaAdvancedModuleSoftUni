package functionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");

        Consumer<String[]> printArray = array -> {
            for (String name : array) {
                System.out.println(name);
            }
        };
        printArray.accept(names);
    }
}
