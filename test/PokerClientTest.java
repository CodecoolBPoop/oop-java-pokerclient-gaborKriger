import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerClientTest {

    @Test
    void testHighestCardIsMineFirstCase() {
        PokerClient pokerClient = new PokerClient("h3", "d2", "s3", "s4", "cq");
        assertDoesNotThrow( () -> {
            boolean result = pokerClient.highestCardIsMine("s3", "h4", "s5", "d6", "sj");
            assertEquals(true,result,"Test : Failure");
        });
        System.out.println("Test : Passed");
    }

    @Test
    void testHighestCardIsMineSecondCase() {
        PokerClient pokerClient = new PokerClient("h3", "d2", "s3", "s4", "cq");
        assertDoesNotThrow( () -> {
            boolean result = pokerClient.highestCardIsMine("s3", "h4", "s5", "d6", "sk");
            assertEquals(false,result,"Test : Failure");
        });
        System.out.println("Test : Passed");
    }
}