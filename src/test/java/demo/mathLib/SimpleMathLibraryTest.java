package demo.mathLib;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleMathLibraryTest {
    SimpleMathLibrary simpleMathLibrary;

    @BeforeAll
    static void start() {
        System.out.println("START");
    }

    @BeforeEach
    void setUp() {
        simpleMathLibrary = new SimpleMathLibrary();
    }

    @Test
    void addTest() {
        double add = simpleMathLibrary.add(5, 15);
        if (add == 21) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
            throw new AssertionError();
        }
    }

    @Test
    void minusTest() {
        double minus = simpleMathLibrary.minus(15, 5);
        if (minus == 10) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
            throw new AssertionError();
        }
    }

    @Test
    void divideTest() {
        double divide = simpleMathLibrary.divide(1000, 20);
        assertEquals(50, divide);
    }

    @Test
    void multiplyTest() {
        double multiply = simpleMathLibrary.multiply(1000, 2);
        assertEquals(2000, multiply);
    }

    @Test
    void divideByZeroTest() {
        double divide = simpleMathLibrary.divide(1000, 20);
        assertThrows(RuntimeException.class, () -> simpleMathLibrary.divide(1000, 0));
    }

    @AfterAll
    static void end() {
        System.out.println("END");
    }
}
