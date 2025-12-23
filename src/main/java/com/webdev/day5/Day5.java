package com.webdev.day5;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Day5 {
    Path input = Paths.get("src/main/resources/testInput.txt");
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
        // since range is low->high - sort the ranges by the starting(low) number in ascending order,
        // start by getting id[0] range into count and begin iteration from id[1],
        // get difference of next range's start number to previous range's ending number,
        // if difference is negative, start number is valid,
        // if difference is positive, start number is added to diff,
        // as long as end number is greater than sum, get count (end - new start)
        // add count to total
        // Will think on it

        //???

        freshRanges.sort(Comparator.comparing(arr -> arr[0]));


        return 0L;
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
    }
}
