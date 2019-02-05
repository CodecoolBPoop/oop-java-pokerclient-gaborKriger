import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerClientTest {

    @Test
    void testHighestCardIsMineFirstCase() {
        PokerClient pokerClient = new PokerClient("h3", "d2", "s3", "s4", "cq");
        assertDoesNotThrow( () -> {
            boolean result = pokerClient.highestCardIsMine("s3", "h4", "s5", "d6", "sj");
            assertTrue(result, "Test : Failure");
        });
        System.out.println("Test : Passed (testHighestCardIsMineFirstCase)");
    }

    @Test
    void testHighestCardIsMineSecondCase() {
        PokerClient pokerClient = new PokerClient("h3", "d2", "s3", "s4", "cq");
        assertDoesNotThrow( () -> {
            boolean result = pokerClient.highestCardIsMine("s3", "h4", "s5", "d6", "sk");
            assertFalse(result, "Test : Failure");
        });
        System.out.println("Test : Passed (testHighestCardIsMineSecondCase)");
    }

    @Test
    void testHighestCardIsMineThirdCase() {
        PokerClient pokerClient = new PokerClient("h2", "d2", "c2", "s2", "c3");
        assertDoesNotThrow( () -> {
            boolean result = pokerClient.highestCardIsMine("h2", "d2", "c2", "s2", "c3");
            assertFalse(result, "Test : Failure");
        });
        System.out.println("Test : Passed (testHighestCardIsMineThirdCase)");
    }
}