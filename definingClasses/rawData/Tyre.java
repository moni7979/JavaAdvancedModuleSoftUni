package definingClasses.rawData;

import java.util.List;


public class Tyre {


    private List<Double> tyreList;


    private int tyreAge;

    public Tyre(List<Double> tyreList) {
        this.tyreList = tyreList;
    }


    public List<Double> getTyreList() {
        return tyreList;
    }

    public void setTyreList(List<Double> tyreList) {
        this.tyreList = tyreList;
    }

    public int getTyreAge() {
        return tyreAge;
    }

    public void setTyreAge(int tyreAge) {
        this.tyreAge = tyreAge;
    }
}
