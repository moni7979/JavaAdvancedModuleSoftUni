package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _ex_01_reverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] n = scanner.nextLine().split("\\s+");
        for (int i = 0; i < n.length; i++) {
            stack.push(Integer.valueOf(n[i]));
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
