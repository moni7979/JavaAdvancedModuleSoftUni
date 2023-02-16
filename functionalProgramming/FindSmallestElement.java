package functionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> getLastIndex = list -> list.lastIndexOf(Collections.min(list));
        int lastIndex = getLastIndex.apply(numbers);
        System.out.println(lastIndex);
    }
}
