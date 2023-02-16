package definingClasses.SpeedRacing;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> garage = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split(" ");

            String model = input[0];
            int fuelAmount = Integer.parseInt(input[1]);
            double consumption = Double.parseDouble(input[2]);

            Car car = new Car(model, fuelAmount, consumption);
            garage.put(model, car);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {

                String[] tokens = command.split(" ");
                String carModelToDrive = tokens[1];
                int kmToDrive = Integer.parseInt(tokens[2]);


            Car carToDrive = garage.get(carModelToDrive);

            if (!carToDrive.drive(kmToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine();
        }

        for (Car car : garage.values()) {
            System.out.println(car.toString());
        }

    }
}
