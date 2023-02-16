package definingClasses.rawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            List<Double> tyreList = new ArrayList<>();

            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];

            double tyre1Pressure = Double.parseDouble(input[5]);
            int tyre1Age = Integer.parseInt(input[6]);

            tyreList.add(tyre1Pressure);

            double tyre2Pressure = Double.parseDouble(input[7]);
            int tyre2Age = Integer.parseInt(input[8]);

            tyreList.add(tyre2Pressure);

            double tyre3Pressure = Double.parseDouble(input[9]);
            int tyre3Age = Integer.parseInt(input[10]);

            tyreList.add(tyre3Pressure);

            double tyre4Pressure = Double.parseDouble(input[11]);
            int tyre4Age = Integer.parseInt(input[12]);

            tyreList.add(tyre4Pressure);



            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tyre tyres = new Tyre(tyreList);

            Car car = new Car(model ,engine, cargo, tyres);

            carList.add(car);

        }

        String command = scanner.nextLine();
        for (Car car : carList) {


            if (command.equals("fragile")) {

                boolean isUnder1 = false;
                for (double tyrePressure : car.getTyres().getTyreList()) {
                    if (tyrePressure < 1) {
                        isUnder1 = true;
                        break;
                    }
                }
                if (isUnder1) {
                    System.out.println(car.getModel());
                }


            } else if (command.equals("flamable") && car.getEngine().getEnginePower() > 250) {

                System.out.println(car.getModel());
            }

        }
    }
}


