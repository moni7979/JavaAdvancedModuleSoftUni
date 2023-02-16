package definingClasses.pokemonTrainer;

import java.util.List;

public class Trainer {

    private String name;
    private int numberBadges;
    private List<Pokemon> pokemonList;


    public Trainer(String name, List<Pokemon> pokemonList) {
        this.name = name;
        this.numberBadges = 0;
        this.pokemonList = pokemonList;
    }

    public int getNumberBadges() {
        return numberBadges;
    }

    public void commandExecuting(String command) {

        if (isExist(command)) {
            numberBadges += 1;
        } else {

            for (int i = 0; i < pokemonList.size(); i++) {

                pokemonList.get(i).setHealth(pokemonList.get(i).getHealth() - 10);
                if (pokemonList.get(i).getHealth() <= 0) {
                    pokemonList.remove(i);
                    i--;
                }

            }
        }
    }


    private boolean isExist(String command) {

        for(Pokemon pokemon : pokemonList) {
            if (pokemon.getElement().equals(command)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return name + " " + numberBadges + " " + pokemonList.size();
    }

}
