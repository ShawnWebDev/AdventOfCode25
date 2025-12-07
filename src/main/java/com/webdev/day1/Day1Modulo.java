package com.webdev.day1;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Day1Modulo {
    public int runDay1() {
        int zeroCount = 0;
        File input = new File("src/main/resources/day1_Input.txt");
        int dialPos = 50;

        try {
            Scanner sc = new Scanner(input);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                int direction = String.valueOf(line.charAt(0)).equals("L") ? -1 : 1;
                int amount = Integer.parseInt(line.substring(1));

                for (int i = 0; i < amount; i++) {
                    dialPos = (dialPos + direction) % 100;

                    if (dialPos == 0) {
                        zeroCount++;
                    }
                }
            }
            sc.close();

        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }

        return zeroCount;
    }
}
