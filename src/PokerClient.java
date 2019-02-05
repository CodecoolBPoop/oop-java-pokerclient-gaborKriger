import java.util.LinkedList;
import java.util.List;

public class PokerClient {

    private List<Card> myCards = new LinkedList<>();
    private List<Card> otherCards = new LinkedList<>();

    public PokerClient(String p1, String p2, String p3, String p4, String p5) {
        myCards.add(new Card(p1.toUpperCase()));
        myCards.add(new Card(p2.toUpperCase()));
        myCards.add(new Card(p3.toUpperCase()));
        myCards.add(new Card(p4.toUpperCase()));
        myCards.add(new Card(p5.toUpperCase()));
    }

    public boolean highestCardIsMine(String p1, String p2, String p3, String p4, String p5) {
        fillOtherCards(p1, p2, p3, p4, p5);
        Card highestCard = findHighestCard();
        return myCards.contains(highestCard);
    }

    private Card findHighestCard() {
        Card highestCard = new Card("s2");
        for (Card myCard : myCards) {
            for (Card otherCard : otherCards) {
                if (myCard.getValue() <= otherCard.getValue() && otherCard.getValue() >= highestCard.getValue()) {
                    highestCard = otherCard;
                } else if (myCard.getValue() > highestCard.getValue()) {
                    highestCard = myCard;
                }
            }
        }
        return highestCard;
    }

    private void fillOtherCards(String p1, String p2, String p3, String p4, String p5) {
        otherCards.add(new Card(p1.toUpperCase()));
        otherCards.add(new Card(p2.toUpperCase()));
        otherCards.add(new Card(p3.toUpperCase()));
        otherCards.add(new Card(p4.toUpperCase()));
        otherCards.add(new Card(p5.toUpperCase()));
    }
}