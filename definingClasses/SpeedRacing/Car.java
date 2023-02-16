package definingClasses.SpeedRacing;

public class Car {

    private String model;

    private double fuelAmount;

    private double fuelCostFor1Km;

    private int distanceTraveled;

    public Car(String model, int fuelAmount, double fuelCostFor1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1Km;
        this.distanceTraveled = 0;
    }

    public boolean drive(int kmToDrive) {
        //TODO
        double needFuel = kmToDrive * this.fuelCostFor1Km;
        if (this.fuelAmount >= needFuel) {
            this.fuelAmount -= needFuel;
            this.distanceTraveled += kmToDrive;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
