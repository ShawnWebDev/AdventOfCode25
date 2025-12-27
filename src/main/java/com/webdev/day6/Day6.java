package com.webdev.day6;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day6 {
    Path input = Paths.get("src/main/resources/testInput.txt");
    Map<Integer, ArrayList<String>> map = new HashMap<>();
    long answer = 0;

    public long runDay6Part1() {
        try {
            this.parseDataPt1();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(map);

        for (List<String> list : map.values()) {
            String operation = list.getLast();
            long total = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                if (operation.equals("+")) {
                    total += Integer.parseInt(list.get(i));
                } else {
                    if (total == 0) {
                        total = 1;
                    }
                    total *= Integer.parseInt(list.get(i));
                }
            }
            answer += total;
        }

        return answer;
    }


    public long runDay6Part2() {
        try {
            this.parseDataPt2();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(map);
        for (List<String> list : map.values()) {
            String operation = list.getLast();
            //System.out.println(list);
        }

        return 0L;
    }


    private void parseDataPt1() throws IOException {
        Scanner scanner = new Scanner(input);

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            int pos = 0;
            for (String s : line) {
                if (s.isEmpty()) {
                    continue;
                }
                map.putIfAbsent(pos, new ArrayList<>());
                map.get(pos).add(s);
                pos++;
            }
        }
    }

    private void parseDataPt2() throws IOException {
        Scanner scanner = new Scanner(input);

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split("");
            int pos = 0;
            for (String s : line) {
                System.out.println("string: " + s);
                if (s.isEmpty()) {
                    continue;
                }
                // todo : check for array of only empty space that will be new pos increment???
                map.putIfAbsent(pos, new ArrayList<>());
                map.get(pos).add(s);
                System.out.println(map.get(pos));
                pos++;
            }
        }
    }
}