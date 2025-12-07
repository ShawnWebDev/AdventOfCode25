package com.webdev.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day2 {

    public long runDay2Part1() {
        File input = new File("src/main/resources/day2_Input.txt");
        List<String> idRanges = new ArrayList<>();

        try (Scanner scanner = new Scanner(input)) {
            idRanges = List.of(scanner.nextLine().split(","));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        long invalidIdSum = 0L;
        // split id value in half if even amount of digits
        // if each half is equal, it is invalid
        for (String ids : idRanges) {
            long start = Long.parseLong(ids.split("-")[0]);
            long end = Long.parseLong(ids.split("-")[1]);

            for (long i = start; i <= end; i++) {
                String valueStr = String.valueOf(i);
                if (valueStr.length() % 2 == 0) {
                    String firstHalf = valueStr.substring(0, (valueStr.length() / 2));
                    String secondHalf = valueStr.substring((valueStr.length() / 2));
                    if (Integer.parseInt(firstHalf) == Integer.parseInt(secondHalf)) {
                        invalidIdSum += Long.parseLong(firstHalf+secondHalf);
                    }
                }
            }
        }

        System.out.printf("invalid sum: " + invalidIdSum);

        return invalidIdSum;
    }
}
