package day1Tests;

import com.webdev.day1.Day1LinkedList;
import com.webdev.day1.Day1Modulo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class day1Tests {

    // mostly for testing runtime speeds
    @Test
    @DisplayName("Test day 1 modulo runtime")
    public void testDay1Modulo() {
        Day1Modulo day1 = new Day1Modulo();
        int answer = day1.runDay1();
        System.out.println(answer);
        // ~50ms
    }

    @Test
    @DisplayName("Test day 1 linked list runtime")
    public void testDay1LinkedList() {
        Day1LinkedList day1 = new Day1LinkedList();
        int answer = day1.runDay1();
        System.out.println(answer);
        // ~20ms
    }

}
