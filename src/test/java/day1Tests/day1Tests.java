package day1Tests;

import com.webdev.day1.Day1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class day1Tests {

    // mostly for testing runtime speeds
    @Test
    @DisplayName("Test day 1 runtime")
    public void testDay1() {
        Day1 day1 = new Day1();
        int answer = day1.runDay1();
        assertEquals(5657,answer);
    }

}
