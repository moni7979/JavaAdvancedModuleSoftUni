package midExamPrep.christmas;

import java.util.LinkedList;
import java.util.List;

public class Bag {

    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {

        this.color = color;
        this.capacity = capacity;
        data = new LinkedList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {

        if (data.size() < capacity) {
            data.add(present);
        }

    }

    public boolean remove(String name) {

        for (Present present : data) {
            if (present.getName().equals(name)) {
                data.remove(present);
                return true;
            }
        }
        return false;

    }

    public Present heaviestPresent() {

        double heaviest = 0.0;
        for (Present present : data) {
             if (present.getWeight() > heaviest) {
                 heaviest = present.getWeight();
             }
        }

        for (Present findPresent : data) {

            if (findPresent.getWeight() == heaviest) {
                return findPresent;
            }

        }

        return null;
    }

    public Present getPresent(String name) {

        for (Present present : data) {
            if (present.getName().equals(name)) {
                return present;
            }
        }
        return null;
    }

    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s bag contains:", this.color));
        sb.append(System.lineSeparator());

        for (Present present : data) {

            sb.append(present);
            sb.append(System.lineSeparator());

        }

        return String.valueOf(sb);

    }

}
