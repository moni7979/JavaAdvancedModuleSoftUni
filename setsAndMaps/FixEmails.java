package setsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailMap = new LinkedHashMap<>();
        String name = scanner.nextLine();
        while (!name.contains("stop")) {
            String email = scanner.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emailMap.put(name, email);
            }

            name = scanner.nextLine();
        }

        emailMap.entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
