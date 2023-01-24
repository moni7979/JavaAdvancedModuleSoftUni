package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        ArrayDeque<Character> openParStack = new ArrayDeque<>();
        ArrayDeque<Character> closedParQueue = new ArrayDeque<>();
        boolean isBalanced = false;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(' || input[i] == '{' || input[i] == '[') {
                openParStack.push(input[i]);
            } else {
                closedParQueue.add(input[i]);
            }
        }

        if (openParStack.size() != closedParQueue.size()) {
            System.out.println("NO");
            return;
        } else {
            while (!openParStack.isEmpty()) {
                char openPar;
                if (!openParStack.isEmpty()) {
                    openPar = openParStack.pop();
                } else {
                    break;
                }
                char closedPar;
                if (!closedParQueue.isEmpty()) {
                    closedPar = closedParQueue.poll();
                } else {
                    break;
                }

                if (openPar == '(' && closedPar == ')' || openPar == '[' && closedPar == ']' || openPar == '{' && closedPar == '}') {
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
