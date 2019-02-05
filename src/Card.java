import java.util.HashMap;
import java.util.Map;

public class Card {

    private String cardCode;
    private Map<String, Integer> alphabeticCardValue = new HashMap<String, Integer>() {{
        put("J", 11);
        put("Q", 12);
        put("K", 13);
        put("A", 14);
    }};

    public Card(String cardCode) throws IllegalArgumentException {
        this.cardCode = cardCode;
        validateCardCode(cardCode);
    }

    private void validateCardCode(String cardCode) {
        checkCardColorIsValid();
        checkCardNumberIsValid(cardCode);
    }

    private void checkCardNumberIsValid(String cardCode) {
        String cardValue = cardCode.substring(1).toUpperCase();
        int intCardValue;
        if (alphabeticCardValue.get(cardCode.substring(1).toUpperCase()) == null) {
            // raises exception if cardValue is a letter, but not J/Q/K/A
            intCardValue = Integer.parseInt(cardValue);
            if (intCardValue > 10) {
                throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
            }
            if (intCardValue < 2) {
                throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
            }
        }
    }

    private void checkCardColorIsValid() {
        String cardColor = this.cardCode.substring(0, 1).toUpperCase();
        String acceptedColor = "SCDH";
        if (!acceptedColor.contains(cardColor)) {
            throw new IllegalArgumentException("card color isn't valid: " + cardColor);
        }
    }

    public int getValue() {
        String cardValue = cardCode.substring(1).toUpperCase();
        int intCardValue;
        if (alphabeticCardValue.get(cardValue) == null) {
            intCardValue = Integer.parseInt(cardValue);
        } else {
            intCardValue = alphabeticCardValue.get(cardValue);
        }
        return intCardValue;
    }
}
