package shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {

    private int capacity;
    private List<Animal> data;


    public Shelter(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Animal animal) {

        if (data.size() < capacity) {
            //FIXME check for egality

            data.add(animal);
        }

    }

    public boolean remove(String name) {

        for (Animal animal : data) {

            if (animal.getName().equals(name)) {
                data.remove(animal);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {

        for (Animal animal : data) {

            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                return animal;
            }

        }
        return null;
    }

    public Animal getOldestAnimal() {

        int currentOldest = 0;
        for (Animal animal : data) {

            if (animal.getAge() > currentOldest) {
                //FIXME check for egality
                currentOldest = animal.getAge();
            }

        }

        for (Animal animal : data) {
            if (animal.getAge() == currentOldest) {
                return animal;
            }
        }
        return null;
    }


    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:");
        sb.append(System.lineSeparator());

        for (Animal animal : data) {

            sb.append(animal.getName());
            sb.append(" ");
            sb.append(animal.getCaretaker());
            sb.append(System.lineSeparator());

        }
        return String.valueOf(sb);
    }
}
