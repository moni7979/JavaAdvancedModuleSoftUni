package definingClasses.companyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] information = scanner.nextLine().split(" ");

            Employee currentEmployee = null;

            String name = information[0];
            double salary = Double.parseDouble(information[1]);
            String position = information[2];
            String department = information[3];

            if (information.length == 6) {
                String email = information[4];
                int age = Integer.parseInt(information[5]);

                currentEmployee = new Employee(name, salary, position, department);
                currentEmployee.setEmail(email);
                currentEmployee.setAge(age);



            } else if (information.length == 5) {
                if (information[4].contains("@")) {

                    String email = information[4];
                    currentEmployee = new Employee(name, salary, position, department);
                    currentEmployee.setEmail(email);


                } else {

                    int age = Integer.parseInt(information[4]);
                    currentEmployee = new Employee(name, salary, position, department);
                    currentEmployee.setAge(age);


                }
            } else if (information.length == 4) {

                currentEmployee = new Employee(name, salary, position, department);

            }

            if (!departments.containsKey(department)) {
                departments.put(department, new Department(department));
            }

            departments.get(department).getEmployees().add(currentEmployee);

        }

        Department maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get().getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));

    }
}
