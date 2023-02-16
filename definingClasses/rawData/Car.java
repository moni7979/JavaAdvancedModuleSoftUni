package definingClasses.rawData;

public class Car {

    private String model;

    private Engine engine;

    private Cargo cargo;

    private Tyre tyres;

    public Car(String model ,Engine engine, Cargo cargo, Tyre tyres) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = tyres;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tyre getTyres() {
        return tyres;
    }

    public void setTyres(Tyre tyres) {
        this.tyres = tyres;
    }
}
