package definingClasses.pokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Pokemon>> trainerMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {

            String[] tokens = input.split(" ");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (!trainerMap.containsKey(trainerName)) {

                trainerMap.put(trainerName, new LinkedList<>());
                trainerMap.get(trainerName).add(pokemon);

            } else {
                trainerMap.get(trainerName).add(pokemon);
            }


            input = scanner.nextLine();
        }

        List<Trainer> trainerList = trainerMap.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(), t.getValue()))
                .collect(Collectors.toList());


        String elements = scanner.nextLine();
        while (!elements.equals("End")) {

            for (Trainer trainer : trainerList) {
                trainer.commandExecuting(elements);
            }

            elements = scanner.nextLine();
        }


        trainerList.stream()
                .sorted(Comparator.comparingInt(Trainer::getNumberBadges).reversed())
                .forEach(System.out::println);


    }
}
