import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CardTest {

    @Test
    void testConstructorBadColor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Card("a10");
            System.out.println("Test : Failure");
        });
        System.out.println("Test : Passed (testConstructorBadColor)");
    }

    @Test
    void testConstructorBadValueFirstCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Card("s11");
            System.out.println("Test : Failure");
        });
        System.out.println("Test : Passed (testConstructorBadValueFirstCase)");
    }

    @Test
    void testConstructorBadValueSecondCase() {
        assertThrows(NumberFormatException.class, () -> {
            new Card("si");
            System.out.println("Test : Failure");
        });
        System.out.println("Test : Passed (testConstructorBadValueSecondCase)");
    }

    @Test
    void testConstructorNothingValue() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            new Card("");
            System.out.println("Test : Failure");
        });
        System.out.println("Test : Passed (testConstructorBadValueSecondCase)");
    }

    @Test
    void testGetValueFirstCase() {
        Card card = new Card("s2");
        assertDoesNotThrow( () -> {
            assertEquals(2,card.getValue(),"Test : Failure");
        });
        System.out.println("Test : Passed (testGetValueFirstCase)");
    }

    @Test
    void testGetValueSecondCase() {
        Card card = new Card("h10");
        assertDoesNotThrow( () -> {
            assertEquals(10,card.getValue(),"Test : Failure");
        });
        System.out.println("Test : Passed (testGetValueSecondCase)");
    }

    @Test
    void testGetValueThirdCase() {
        Card card = new Card("cj");
        assertDoesNotThrow( () -> {
            assertEquals(11,card.getValue(),"Test : Failure");
        });
        System.out.println("Test : Passed (testGetValueThirdCase)");
    }

    @Test
    void testGetValueFourCase() {
        Card card = new Card("ca");
        assertDoesNotThrow( () -> {
            assertEquals(14,card.getValue(),"Test : Failure");
        });
        System.out.println("Test : Passed (testGetValueFourCase)");
    }
}