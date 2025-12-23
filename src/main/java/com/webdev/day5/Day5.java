package com.webdev.day5;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Day5 {
    Path input = Paths.get("src/main/resources/day5_Input.txt");
    List<long[]> freshRanges = new ArrayList<>();
    List<Long> ingredientIds = new ArrayList<>();

    public int runDay5Part1() {
        int freshIngredients = 0;

        try {
            this.parseData();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (long id : ingredientIds) {
            for (long[] range : freshRanges) {
                if (id >= range[0] && id <= range[1]) {
                    freshIngredients++;
                    break;
                }
            }
        }

        return freshIngredients;
    }

    public long runDay5Part2() {

        try {
            this.parseData();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // since range is low-high, sort the ranges by the starting(low) number in ascending order for a simple sequence check,
        freshRanges.sort(Comparator.comparing(arr -> arr[0]));

        long total = 0;
        long currentMax = 0;

        for (long[] range : freshRanges) {
            long start = range[0];
            long end = range[1];
            // start is higher than last max, full range is unique
            if (start > currentMax) {
                total += countRange(end, start);
                currentMax = end;
            }
            // end is higher than last max but start is lower, part of range is unique,
            // currentMax is counted from previous range so add 1, that is new start
            else if (end > currentMax) {
                total += countRange(end, currentMax + 1);
                currentMax = end;
            }
            // neither is higher than last max, range is not unique
        }

        return total;
    }

    private static long countRange(long end, long start) {
        return (end - start) + 1;
    }

    private void parseData() throws IOException {
        Scanner sc = new Scanner(input);
        boolean switched = false;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                switched = true;
                continue;
            }
            if (switched) {
                this.ingredientIds.add(Long.parseLong(line));
            } else {
                String[] range = line.split("-");
                this.freshRanges.add(new long[]{Long.parseLong(range[0]), Long.parseLong(range[1])});
            }
        }
        sc.close();
    }
}
