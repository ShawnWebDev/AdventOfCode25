package com.webdev.day7;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Day7 {
    Path input = Paths.get("src/main/resources/testInput.txt");
    // will need to keep track of previous line with split "tachyon beams"
    public int runDay7Part1() {
        int splits = 0;
        try {
            Scanner scanner = new Scanner(input);
            char[] line = scanner.nextLine().toCharArray();
            char[] prevLine = new char[line.length];
            while (scanner.hasNextLine()) {
                for (int i = 0; i < line.length; i++) {
                    if (line[i] == 'S') {
                        prevLine[i] = '|';
                    } else if (line[i] == '^' && prevLine[i] == '|') {
                        prevLine[i] = '^';
                        prevLine[i+1] = '|';
                        prevLine[i-1] = '|';
                        splits += 1;
                    }
                }
                line = scanner.nextLine().toCharArray();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return splits;
    }

    // will need to keep track of previous paths, sum converged paths, paths not converging are 1 if new path or previous value if no split, sum all at the end?
    public int runDay7Part2() {
        try {
            Scanner scanner = new Scanner(input);
            // will use strings due to possibility of more digits
            String[] line = scanner.nextLine().split("");
            String[] prevLine = new String[line.length];
            while (scanner.hasNextLine()) {

                System.out.println("Line: " + Arrays.toString(line));
                line = scanner.nextLine().split("");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

}
