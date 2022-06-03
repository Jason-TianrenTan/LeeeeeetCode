package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("abc"));
        employeeList.add(new Employee("def"));
        employeeList.add(new Employee("xyz"));
        List<Employee> result = employeeList.stream().filter(e -> e.getName().startsWith("a")).collect(Collectors.toList());
        result.forEach(e -> System.out.println(e.getName()));

        List<Integer> numbers = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        int sum = numbers.stream().filter(x -> x % 2 == 0).map(x -> x * x).reduce(0, (ans, i) -> ans + i);
        System.out.println(sum);
    }
}
