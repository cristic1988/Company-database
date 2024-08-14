package org.example.app.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeesUpdateView {

    public Map<String, String> getData() {
        System.out.println("\nUPDATE FORM");
        Map<String, String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input id: ");
        map.put("id", scanner.nextLine().trim());
        System.out.print("Input name: ");
        map.put("name", scanner.nextLine().trim());
        System.out.print("Input age: ");
        map.put("age", scanner.nextLine().trim());
        System.out.print("Input position: ");
        map.put("position", scanner.nextLine().trim());
        System.out.print("Input salary: ");
        map.put("salary", scanner.nextLine().trim());
        return map;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}

