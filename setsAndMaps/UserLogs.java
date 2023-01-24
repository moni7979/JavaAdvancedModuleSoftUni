package setsAndMaps;

import java.util.*;


public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> userMap = new TreeMap<>();
        while (!input.contains("end")) {
            String ip = input.split(" ")[0].split("=")[1];
            String user = input.split(" ")[2].split("=")[1];

            Map<String, Integer> ipAndCountMap = new LinkedHashMap<>();
            if (!userMap.containsKey(user)) {
                //userMap.put(user, new LinkedHashMap<>());
                ipAndCountMap.put(ip, 1);
                userMap.put(user, ipAndCountMap);

            } else {
                ipAndCountMap = userMap.get(user);
                if (ipAndCountMap.containsKey(ip)) {
                    int newValue = ipAndCountMap.get(ip) + 1;
                    ipAndCountMap.put(ip, newValue);

                } else {
                    ipAndCountMap.put(ip, 1);

                }
            }
            userMap.put(user, ipAndCountMap);


            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : userMap.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            int remainingEntries = entry.getValue().size();

            for (Map.Entry<String, Integer> secondEntry : entry.getValue().entrySet()) {

                if (remainingEntries > 1) {
                    remainingEntries--;
                    System.out.print(secondEntry.getKey() + " => " + secondEntry.getValue() + ", ");
                } else {
                    System.out.print(secondEntry.getKey() + " => " + secondEntry.getValue() + ".");
                }
            }
            System.out.println();
        }
    }
}
