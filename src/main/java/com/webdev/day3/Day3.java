package com.webdev.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
    File input = new File("src/main/resources/day3_Input.txt");

    public int runDay3Part1() {
        int totalJoltage = 0;

        try {
            Scanner sc = new Scanner(input);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                int lineLength = line.length();
                int largest = 0;
                int largestIndex = 0;
                int num;

                for(int i = 0; i < lineLength - 1; i++) {
                    num = line.charAt(i) - '0';
                    if(num > largest) {
                        largest = num;
                        largestIndex = i;
                    }
                    if (num == 9) {
                        break;
                    }
                }

                int curr = largest * 10;
                largest = 0;

                for(int i = largestIndex + 1; i < lineLength; i++) {
                    num = line.charAt(i) - '0';
                    if(num > largest) {
                        largest = num;
                    }
                    if (num == 9) {
                        break;
                    }
                }
                curr = curr + largest;

                totalJoltage += curr;
            }

        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return totalJoltage;
    }

    public long runDay3Part2() {
        long totalJoltage = 0L;
        try {
            Scanner sc = new Scanner(input);
            final int NEEDED = 12;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                int lineLength = line.length();
                int largest = 0;
                int largestIndex = 0;
                int found = NEEDED -1;
                int num;
                StringBuilder sb = new StringBuilder(NEEDED);

                while (found >= 0) {
                    for(int i = largestIndex; i < lineLength - found; i++) {
                        num = line.charAt(i) - '0';
                        if (num > largest) {
                            largest = num;
                            largestIndex = i + 1;
                        }
                    }
                    sb.append(largest);
                    largest = 0;
                    found--;
                }

                totalJoltage += Long.parseLong(sb.toString());
            }

        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return totalJoltage;
    }
}