package com.webdev.day6;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day6 {
    Path input = Paths.get("src/main/resources/day6_Input.txt");
    Map<Integer, ArrayList<String>> map = new HashMap<>();

    public long runDay6Part1() {
        try {
            this.parseData(true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(map);
        long answer = 0;

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
            this.parseData(false);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(map);
        String operation = "";
        long total = 0, answer = 0;
        for (List<String> list : map.values()) {
            if (list.getLast().equals("+") || list.getLast().equals("*")) {
                // new equation
                operation = list.getLast();
                list.set(list.size() - 1, "");
                total = operation.equals("+") ? 0 : 1;
                System.out.println("curr answer: " + answer);
            }

            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                if (!s.equals(" ") && !s.isEmpty()) {
                    sb.append(s);
                }
            }
            System.out.println("builder: " + sb.toString());
            if (sb.toString().isEmpty()) {
                answer += total;
                continue;
            }

            int numStr = Integer.parseInt(sb.toString());
            if (operation.equals("+")) {
                total += numStr;
            } else {
                total *= numStr;
            }

            System.out.println("running total: " + total);
        }

        // need to get last total
        answer += total;

        return answer;
    }


    private void parseData(boolean addSpace) throws IOException {
        Scanner scanner = new Scanner(input);
        String splitter = addSpace ? " " : "";
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(splitter);
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
}