package com.webdev.day1;

import com.webdev.util.CircularDoublyLinkedList;
import com.webdev.util.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1LinkedList {

    public int runDay1() {
        int zeroCount = 0;
        File input = new File("src/main/resources/day1_Input.txt");

        Node head = new Node(0);
        CircularDoublyLinkedList dLinkedList = new CircularDoublyLinkedList(head, 100);
        dLinkedList.populateList();
        Node current = dLinkedList.getStartingNode(50);

        try {
            Scanner sc = new Scanner(input);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                char direction = line.charAt(0);
                int amount = Integer.parseInt(line.substring(1));

                for (int i = 0; i < amount; i++) {
                    if (direction == 'L') {
                        current = current.getPrev();
                    } else {
                        current = current.getNext();
                    }
                    if (current.getData() == 0) {
                        zeroCount++;
                    }
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return zeroCount;
    }
}