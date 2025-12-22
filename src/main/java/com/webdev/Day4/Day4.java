package com.webdev.Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day4 {
    Path input = Paths.get("src/main/resources/day4_Input.txt");
    // as (y, x) because need to move to adjacent string y before getting position x
    int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},/*{0, 0},*/ {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };
    int MAX_ADJACENT = 3;

    public int runDay4Part1() {

        int  accessibleRolls = 0;
        try {
            List<String> lines = Files.readAllLines(input);
            // refactored to use helper method from day 2 problem change instead of getting int value directly.
            Map<Integer,List<Integer>> currentAccessibleRoles = this.getCurrentAccessibleRoles(lines);
            for (List<Integer> rolls : currentAccessibleRoles.values()) {
                accessibleRolls += rolls.size();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return accessibleRolls;
    }

    public int runDay4Part2() {
        int accessibleRollsRemoved = 0;

        try {
            List<String> lines = Files.readAllLines(input);

            // get cords of each char to modify for each string using a StringBuilder for each.
            Map<Integer,List<Integer>> currentAccessibleRoles = this.getCurrentAccessibleRoles(lines);
            int accessibleRolls = currentAccessibleRoles.size();
            String currentRow;
            StringBuilder builderRow;
            while (accessibleRolls != 0) {
                for (Integer row : currentAccessibleRoles.keySet()) {
                    currentRow = lines.get(row);
                    builderRow = new StringBuilder(currentRow);
                    for (Integer foundIdx : currentAccessibleRoles.get(row)) {
                        builderRow.setCharAt(foundIdx, '.');
                        accessibleRollsRemoved++;
                    }
                    lines.set(row, builderRow.toString());
                }
                currentAccessibleRoles = this.getCurrentAccessibleRoles(lines);
                accessibleRolls = currentAccessibleRoles.size();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return accessibleRollsRemoved;
    }

    // returns Map of <key = y, values = List[x]> cords of accessible rolls.
    private Map<Integer,List<Integer>> getCurrentAccessibleRoles(List<String> lines) {
        Map<Integer,List<Integer>> accessibleRolls = new HashMap<>();
        int adjacentRolls;

        for (int i = 0; i < lines.size(); i++) {
            String row = lines.get(i);
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '@') {
                    adjacentRolls = 0;
                    for (int[] direction : directions) {
                        int y = i + direction[0];
                        int x = j + direction[1];
                        // check if direction in bounds
                        if (y >= 0 && y < lines.size() && x >= 0 && x < row.length()) {
                            char adjChar = lines.get(y).charAt(x);
                            if (adjChar == '@') {
                                adjacentRolls++;
                            }
                        }
                        if (adjacentRolls > MAX_ADJACENT) break;
                    }
                    if (adjacentRolls <= MAX_ADJACENT) {
                        if (accessibleRolls.containsKey(i)) {
                            accessibleRolls.get(i).add(j);
                        } else {
                            accessibleRolls.put(i, new ArrayList<>());
                            accessibleRolls.get(i).add(j);
                        }
                    }
                }

            }
        }
        return accessibleRolls;
    }

}