package definingClasses.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Engine> engines = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split(" ");

            String modelInput = input[0];
            int powerInput = Integer.parseInt(input[1]);
            int displacement = 0;
            String efficiency = null;


            //Engine engineInput = new Engine(modelInput, powerInput);
            if (input.length == 4) {
                displacement = Integer.parseInt(input[2]);
                efficiency = input[3];

            } else if (input.length == 3) {
                if (Character.isDigit(input[2].charAt(0))) {
                    displacement = Integer.parseInt(input[2]);

                } else {
                    efficiency = input[2];

                }
            }

            Engine engine = new Engine(modelInput, powerInput, displacement, efficiency);
            engines.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split(" ");
            String carModelInput = input[0];
            String engineInput = input[1];
            int weight = 0;
            String color = null;


            if (input.length == 4) {
                weight = Integer.parseInt(input[2]);
                color = input[3];

            } else if (input.length == 3) {

                if (Character.isDigit(input[2].charAt(0))) {

                    weight = Integer.parseInt(input[2]);

                } else {

                    color = input[2];

                }
            }

            Engine carEngine = null;
            for (Engine engine : engines) {
                if (engineInput.equals(engine.getModel())) {
                    carEngine = engine;
                    break;
                }
            }

            Car car = new Car(carModelInput, carEngine, weight, color);
            System.out.print(car);
        }

    }
}
