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

    public Card(String cardCode) {
        this.cardCode = cardCode;
        validateCardCode();
    }

    private void validateCardCode() {
        checkCardColorIsValid();
        checkCardNumberIsValid();
    }

    private void checkCardColorIsValid() {
        String cardColor = this.cardCode.substring(0, 1).toUpperCase();
        String acceptedColor = "SCDH";
        if (!acceptedColor.contains(cardColor)) {
            throw new IllegalArgumentException("card color isn't valid: " + cardColor);
        }
    }

    private void checkCardNumberIsValid() {
        String cardValue = this.cardCode.substring(1).toUpperCase();
        // raises exception if cardValue is a letter, but not J/Q/K/A
        if (alphabeticCardValue.get(cardValue) == null) {
            try {
                int intCardValue = Integer.parseInt(cardValue);
                if (intCardValue < 2 || intCardValue > 10) {
                    throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
                }
            } catch (NumberFormatException nfe) {
                throw new NumberFormatException("card number isn't number: " + nfe);
            }
        }
    }

    public int getValue() {
        String cardValue = this.cardCode.substring(1).toUpperCase();
        int intCardValue;
        if (alphabeticCardValue.get(cardValue) == null) {
            intCardValue = Integer.parseInt(cardValue);
        } else {
            intCardValue = alphabeticCardValue.get(cardValue);
        }
        return intCardValue;
    }
}
