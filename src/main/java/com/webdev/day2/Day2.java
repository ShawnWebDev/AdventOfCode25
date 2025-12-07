package com.webdev.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day2 {
    File input = new File("src/main/resources/testInput.txt");

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
        List<Long> invalidIds = new ArrayList<>();

        try (Scanner scanner = new Scanner(input)) {
            idRanges = List.of(scanner.nextLine().split(","));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        long invalidIdSum = 0L;
        // queue up sequences until sequence.length is half of value, then check remaining parts for each new repeated sequence???

/*        for (String idRange : idRanges) {
            long start = Long.parseLong(idRange.split("-")[0]);
            long end = Long.parseLong(idRange.split("-")[1]);
            System.out.println("start: " + start);
            System.out.println("end: " + end);

            for (long i = start; i <= end; i++) {*/
                String valueStr = String.valueOf(1188511885);
                int valLen = valueStr.length();
                Queue<String> sequence = new LinkedList<>();
                sequence.add(String.valueOf(valueStr.charAt(0)));
                for (int j = 1; j < valLen - 1; j++) {
                    if (j < valLen / 2) {;
                        sequence.add(sequence.element() + valueStr.substring(1, j+1));
                    }
                }
                // sequence is good..
                System.out.println(sequence);

                // todo : something here is wrong, check later.
                for (String seq : sequence) {
                    int seqLen = seq.length();
                    if (valLen % seqLen == 0) {
                        boolean isInvalid = false;
                        for (int j = 0; j <= valLen - 1; j+=seqLen) {
                            String value = valueStr.substring(j, j+seqLen);
                            if (!seq.equals(value)) {
                                isInvalid = true;
                                break;
                            }
                        }
                        if (isInvalid) {
                            invalidIds.add(Long.parseLong(valueStr));
                            invalidIdSum += Long.parseLong(valueStr);
                        }
                    }
                }
  /*          }
        }*/

        System.out.println("invalid sum: " + invalidIdSum);
        System.out.printf("invalid ids: " + invalidIds);


        return invalidIdSum;
    }
}
