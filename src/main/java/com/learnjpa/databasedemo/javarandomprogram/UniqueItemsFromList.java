package com.learnjpa.databasedemo.javarandomprogram;

import org.springframework.data.relational.core.sql.In;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueItemsFromList {
    public static void main(String[] args) {

        // 1. String[] array
        List<String > companies = new ArrayList<>();
        companies.add("Meta");
        companies.add("Apple");
        companies.add("Meta");
        companies.add("Apple");
        companies.add("Amazon");


        Map<String , Integer> resultMap = new HashMap<>();
        //companies.forEach(e -> resultMap.compute(e, (k, v) -> v == null ? 1L : v + 1L));
        companies.forEach(company -> {
            if(Collections.frequency(companies, company) > 1){
                resultMap.put(company, Collections.frequency(companies, company));
            }
        });

        // 4.1 print Map for duplicate count
        System.out.println("\n4. Map Key as Company and Value as its duplicate count : \n" + resultMap);

    }
}
