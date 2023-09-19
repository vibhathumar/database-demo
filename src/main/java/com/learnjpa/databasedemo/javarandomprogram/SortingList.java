package com.learnjpa.databasedemo.javarandomprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingList {

    static List<Employees> employees = Arrays.asList(
            new Employees(1,"Vibha", "Thumar", 32),
            new Employees(2,"Rakesh", "Thumar", 34),
            new Employees(3,"Yaana", "Thumar", 3),
            new Employees(4,"Vira", "Thumar", 2)
    );

    public static void main(String[] args) {
       List<Employees> sortedList = employees.stream()
               .sorted(Comparator.comparingInt(Employees::getAge))
               .collect(Collectors.toList());

        sortedList.forEach(System.out::println);

        List<String> sortedListByName = employees.stream()
                .sorted(Comparator.comparing(Employees::getFirstName))
                .map(firstName -> firstName .getFirstName())
                .collect(Collectors.toList());

        System.out.println("\nSorting By First Name : ");
        sortedListByName.forEach(System.out::println);
    }
}
