package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private List<Rabbit> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {

        if (data.size() < capacity) {
            data.add(rabbit);
        }

    }

    public boolean removeRabbit(String name) {

        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                data.remove(rabbit);
                return true;
            }
        }
        return false;

    }

    public void removeSpecies(String species) {

        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species)) {
                data.remove(rabbit);
            }
        }

    }

    public Rabbit sellRabbit(String name) {

        for (Rabbit rabbit : data) {

            if (rabbit.getName().equals(name)) {
                rabbit.setAvailable(false);
                return rabbit;
            }

        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbitsBySpecies = new ArrayList<>();

        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species)) {

                rabbit.setAvailable(false);
                rabbitsBySpecies.add(rabbit);

            }
        }
        return rabbitsBySpecies;
    }

    public int count() {

        int count = 0;
        for (Rabbit rabbit : data) {

            if (rabbit.isAvailable()) {
                count++;
            }

        }
        return count;
    }

    public String report() {

        StringBuilder sb = new StringBuilder();

        System.out.printf("Rabbits available at %s:%n", getName());
        for (Rabbit rabbit : data) {
            if (rabbit.isAvailable()) {

               sb.append(rabbit);
               sb.append(System.lineSeparator());

            }
        }
        return String.valueOf(sb);
    }

}
