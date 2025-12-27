import com.webdev.Day4.Day4;
import com.webdev.day1.Day1LinkedList;
import com.webdev.day1.Day1Modulo;
import com.webdev.day2.Day2;
import com.webdev.day3.Day3;
import com.webdev.day5.Day5;
import com.webdev.day6.Day6;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;


// for running solutions and testing runtime speed
public class Tests {


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

    @Test
    @DisplayName("Test day 2 part 1 run")
    public void testDay2Part1() {
        Day2 day2 = new Day2();
        Long answer = day2.runDay2Part1();
        System.out.println(answer);
    }

    @Test
    @DisplayName("Test day 2 part 2 run")
    public void testDay2Part2() {
        Day2 day2 = new Day2();
        Long answer = day2.runDay2Part2();
        System.out.println(answer);
    }

    @Test
    @DisplayName("Test day 3 part 1 run")
    public void testDay3Part1() {
        Day3 day3 = new Day3();
        int answer = day3.runDay3Part1();
        System.out.println(answer);
    }

    @Test
    @DisplayName("Test day 3 part 2 run")
    public void testDay3Part2() {
        Day3 day3 = new Day3();
        Long answer = day3.runDay3Part2();
        System.out.println(answer);
    }

    @Test
    @DisplayName("Test day 4 part 1 run")
    public void testDay4Part1() {
        Day4 day4 = new Day4();
        int answer = day4.runDay4Part1();
        System.out.println(answer);
    }

    @Test
    @DisplayName("Test day 4 part 2 run")
    public void testDay4Part2() {
        Day4 day4 = new Day4();
        int answer = day4.runDay4Part2();
        System.out.println(answer);
    }

    @Test
    @DisplayName("Test day 5 part 1 run")
    public void testDay5Part1() {
        Day5 day5 = new Day5();
        int answer = day5.runDay5Part1();
        System.out.println("answer: " + answer);
    }

    @Test
    @DisplayName("Test day 5 part 2 run")
    public void testDay5Part2() {
        Day5 day5 = new Day5();
        long answer = day5.runDay5Part2();
        System.out.println("answer: " + answer);
    }

    @Test
    @DisplayName("Test day 6 part 1 run")
    public void testDay6Part1() {
        Day6 day6 = new Day6();
        long answer = day6.runDay6Part1();
        System.out.println("answer: " + answer);
    }

    @Test
    @DisplayName("Test day 6 part 2 run")
    public void testDay6Part2() {
        Day6 day6 = new Day6();
        long answer = day6.runDay6Part2();
        System.out.println("answer: " + answer);
    }
}
