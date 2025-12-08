package com.webdev.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day2 {
    File input = new File("src/main/resources/day2_Input.txt");

    public long runDay2Part1() {
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
    public long runDay2Part2() {
        List<String> idRanges = new ArrayList<>();

        try (Scanner scanner = new Scanner(input)) {
            idRanges = List.of(scanner.nextLine().split(","));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        long invalidIdSum = 0L;
        // split input and extract range iterate,
        // get all possible sequences from 0 to value.length / 2 since a sequence cannot be larger than half the base value to repeat,
        // a sequence length must be a multiple of value length since it has to be made only of at least two of the sequence.

        for (String idRange : idRanges) {
            long start = Long.parseLong(idRange.split("-")[0]);
            long end = Long.parseLong(idRange.split("-")[1]);

            for (long i = start; i <= end; i++) {
                String valueStr = String.valueOf(i);
                int valLen = valueStr.length();
                // start at 1 to get substring (0, 1) and not divide by 0 when checking value length is divisible by sequence length
                for (int j = 1; j <= valLen / 2; j++) {
                    if (valLen % j == 0) {
                        String seqNum = valueStr.substring(0, j);
                        String repeatedSeq = seqNum.repeat(valLen / seqNum.length());

                        if (repeatedSeq.equals(valueStr)) {
                            invalidIdSum += i;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("invalid sum: " + invalidIdSum);
        return invalidIdSum;
    }
}
