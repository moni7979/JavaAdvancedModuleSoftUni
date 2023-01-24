package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();

            if (command.startsWith("1")) {
                int element = Integer.parseInt(command.split("\\s+")[1]);
                stack.push(element);

            } else if (command.contains("2")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else if (command.contains("3")) {
                System.out.println(Collections.max(stack));
            }

        }
    }
}
