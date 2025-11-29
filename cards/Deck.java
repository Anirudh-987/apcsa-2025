package cards;

import java.util.Random;

public class Deck {

  private Card[] cards;     // full deck of 52 cards
    private int index;        // next card to draw

    public Deck() {
        cards = new Card[52];
        index = 0;

        int c = 0;
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 0; value < 13; value++) {
                cards[c++] = new Card(suit, value);
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < cards.length; i++) {
            int j = rand.nextInt(52);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
        index = 0; // reset draw position
    }

    public void cut(int pos) {
        if (pos < 0 || pos > 51) return;

        Card[] newDeck = new Card[52];
        int p = 0;

        // cards from pos to end first
        for (int i = pos; i < 52; i++) {
            newDeck[p++] = cards[i];
        }
        // then cards from 0 to pos-1
        for (int i = 0; i < pos; i++) {
            newDeck[p++] = cards[i];
        }

        cards = newDeck;
        index = 0;
    }

    // Returns next card or null if empty
    public Card draw() {
        if (index >= 52)
            return null;
        return cards[index++];
    }

    // Print first n cards on one line
    public void print(int n) {
        for (int i = 0; i <= n && i < 52; i++) {
            System.out.print(cards[i] + " ");
        }
        System.out.println();
    }
}
