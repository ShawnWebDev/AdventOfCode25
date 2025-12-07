import com.webdev.day1.Day1LinkedList;
import com.webdev.day1.Day1Modulo;
import com.webdev.day2.Day2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


// mostly for running solutions and testing runtime speed
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
    @DisplayName("Test day 2 run")
    public void testDay2Part1() {
        Day2 day2 = new Day2();
        Long answer = day2.runDay2Part1();
    }

}
